package com.dearme.demo.domain.board.service;

import com.dearme.demo.domain.board.dto.BoardResponseDto;
import com.dearme.demo.domain.board.dto.BoardSaveRequestDto;
import com.dearme.demo.domain.board.dto.BoardUpdateRequestDto;
import com.dearme.demo.domain.board.entity.Board;
import com.dearme.demo.domain.board.entity.Comment;
import com.dearme.demo.domain.board.repository.BoardRepository;
import com.dearme.demo.domain.board.repository.CommentRepository;
import com.google.cloud.speech.v1.*;
import com.google.protobuf.ByteString;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    @Override
    @Transactional
    public Board boardSave(BoardSaveRequestDto dto){
        Board board;
        board = dto.toBoardEntity();
        boardRepository.save(board);
        return board;
    }
    @Override
    public Page<Board> getBoards(PageRequest pageRequest){
        String filePath = "C:\\Users\\multicampus\\Documents\\카카오톡 받은 파일\\0801demo\\demo\\src\\main\\resources\\KOR_F_RM0769FLJH0325.pcm";
        try {
            SpeechClient speech = SpeechClient.create(); // Client 생성

            // 오디오 파일에 대한 설정부분
            RecognitionConfig config = RecognitionConfig.newBuilder()
                    .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
                    .setSampleRateHertz(16000)
                    .setLanguageCode("en-US")
                    .build();

            RecognitionAudio audio = getRecognitionAudio(filePath); // Audio 파일에 대한 RecognitionAudio 인스턴스 생성
            RecognizeResponse response = speech.recognize(config, audio); // 요청에 대한 응답
            List<SpeechRecognitionResult> results = response.getResultsList(); // 응답 결과들

            for (SpeechRecognitionResult result: results) {
                SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
                System.out.printf("Transcription: %s%n", alternative.getTranscript());
            }

            speech.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return boardRepository.findAll(pageRequest);
    }
    // Local 이나 Remote이거나 구분해서 RecognitionAudio 만들어 주는 부분
    public static RecognitionAudio getRecognitionAudio(String filePath) throws IOException {
        RecognitionAudio recognitionAudio;

        // 파일이 GCS에 있는 경우
        if (filePath.startsWith("gs://")) {
            recognitionAudio = RecognitionAudio.newBuilder()
                    .setUri(filePath)
                    .build();
        }
        else { // 파일이 로컬에 있는 경우
            Path path = Paths.get(filePath);
            byte[] data = Files.readAllBytes(path);
            ByteString audioBytes = ByteString.copyFrom(data);

            recognitionAudio = RecognitionAudio.newBuilder()
                    .setContent(audioBytes)
                    .build();
        }

        return recognitionAudio;
    }
    @Transactional
    public BoardResponseDto getBoard(Long boardid){
        Board board= boardRepository.findBoardByBoardid(boardid);
        board.updateHitCnt();
        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setUserid(board.getUserid());
        boardResponseDto.setTitle(board.getTitle());
        boardResponseDto.setContents(board.getContents());
        boardResponseDto.setHitCnt(board.getHitCnt());
        boardResponseDto.setDate(board.getDate());

        List<Comment> comment = commentRepository.findCommentByBoardid(boardid);
        boardResponseDto.setComment(comment);
        return boardResponseDto;
    }

    @Transactional
    public Long updateBoard(Long boardid, BoardUpdateRequestDto dto) {
        Board board = boardRepository.findBoardByBoardid(boardid);
        board.update(dto.getTitle(), dto.getContents(), dto.getDate());
        return boardid;
    }

    @Transactional
    public void deleteBoard(Long boardid) {
        Board board = boardRepository.findBoardByBoardid(boardid);
        boardRepository.delete(board);
    }


}
