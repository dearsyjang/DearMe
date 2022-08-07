package com.dearme.demo.domain.videodiary.service;


import com.dearme.demo.domain.textdiary.dto.TextDiaryDetailsResponseDto;
import com.dearme.demo.domain.textdiary.dto.TextDiaryListResponseDto;
import com.dearme.demo.domain.textdiary.entity.TextDiary;
import com.dearme.demo.domain.textdiary.exception.NoPermissionTextDiaryException;
import com.dearme.demo.domain.user.entity.User;
import com.dearme.demo.domain.user.exception.NoExistUserException;
import com.dearme.demo.domain.user.repository.UserRepository;
import com.dearme.demo.domain.videodiary.dto.*;
import com.dearme.demo.domain.videodiary.entity.VideoDiary;
import com.dearme.demo.domain.videodiary.exception.NoPermissionVideoDiaryException;
import com.dearme.demo.domain.videodiary.repository.VideoDiaryRepository;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.speech.v1.*;
import com.google.protobuf.ByteString;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoDiaryServiceImpl implements VideoDiaryService {
    private final UserRepository userRepository;
    private final VideoDiaryRepository videoDiaryRepository;
    @Override
    public PostVideoDiaryResponseDto postVideoDiary(String id, PostVideoDiaryRequestDto dto) throws IOException {
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        VideoDiary videoDiary = dto.toEntity();
        videoDiary.setUser(user);
        String[] text = videoSTT(videoDiary.getRealfilename());
        videoDiary.setContents(text[0]);
        videoDiary.setSentiment(text[1]);
        videoDiary.setPercentage(Long.parseLong(text[2]));
        videoDiaryRepository.save(videoDiary);
        return new PostVideoDiaryResponseDto(videoDiary.getId(), videoDiary.getTitle(), videoDiary.getContents(), videoDiary.getSentiment(), videoDiary.getPercentage());
    }

    @Override
    public PostVideoDiaryResponseDto postUpdateVideoDiary(String id, Long videoDiaryId, PostUpdateVideoDiaryRequestDto dto) {
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        VideoDiary videoDiary = videoDiaryRepository.findVideoDiaryById(videoDiaryId);
        if(user.getUserId().equals(videoDiary.getUser().getUserId())){
            videoDiary.updateTitle(dto.getTitle());
            videoDiary.updateContents(dto.getContents());
            if(dto.getSentiment().equals(videoDiary.getSentiment())){
                String result[] = new String[2];
                result = getSentiment(videoDiary.getContents());
                videoDiary.updateSentiment(result[0]);
                videoDiary.updatePercentage(Long.parseLong(result[1]));
            }else{
                videoDiary.updateSentiment(dto.getSentiment());
                videoDiary.updatePercentage(100L);
            }
        }else{
            throw new NoPermissionVideoDiaryException();
        }
        return new PostVideoDiaryResponseDto(videoDiary.getId(), videoDiary.getTitle(), videoDiary.getContents(), videoDiary.getSentiment(), videoDiary.getPercentage());
    }

    @Override
    public VideoDiaryDetailsResponseDto getDetails(String id, Long videoDiaryId) {
        VideoDiary videoDiary = videoDiaryRepository.findById(videoDiaryId).get();
        if(!videoDiary.getUser().getId().equals(id)) throw new NoPermissionVideoDiaryException();
        return VideoDiaryDetailsResponseDto.of(videoDiary);
    }

    @Override
    public VideoDiaryListResponseDto getList(String id, Integer year, Integer month) {
        List<VideoDiary> videoDiaries = videoDiaryRepository.findAllByUser_IdAndYearAndMonth(id, year, month);
        List<VideoDiaryDetailsResponseDto> videoDiaryDetailsResponseDtos = new ArrayList<>();
        for(VideoDiary videoDiary : videoDiaries){
            videoDiaryDetailsResponseDtos.add(VideoDiaryDetailsResponseDto.of(videoDiary));
        }
        VideoDiaryListResponseDto dto = new VideoDiaryListResponseDto();
        dto.setVideoDiaries(videoDiaryDetailsResponseDtos);
        return dto;
    }

    @Override
    @Transactional
    public void delete(String id, Long videoDiaryId) {
        videoDiaryRepository.deleteByUser_IdAndId(id, videoDiaryId);
    }


    public String[] videoSTT(String path) throws IOException {
        //서버에서 실행시킬 때
        /*
        String filePath = path;
        filePath = filePath.substring(0, filePath.length()-4);
        String s;
        Process p;
        try{
            String[] cmd = {"/bin/sh", "-c", "ffmpeg -i " + filePath + ".mp4 " + filePath + ".mp3"};
            p = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
                System.out.println(s);
            p.waitFor();
            System.out.println("exit: " + p.exitValue());
            p.destroy();
        }catch (Exception e){
            e.printStackTrace();
        }
        filePath = filePath+".mp3";
        */

        //테스트용
        String filePath="src/main/resources/convert_test1.mp3";

        String[] text= new String[3];
        try {
            CredentialsProvider credentialsProvider = FixedCredentialsProvider.create(ServiceAccountCredentials.fromStream(new FileInputStream("src/main/resources/my-project-0801-358104-1615eb198267.json")));
            SpeechSettings settings = SpeechSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
            // Instantiates a client
            SpeechClient speech=SpeechClient.create(settings);
            // 오디오 파일에 대한 설정부분
            RecognitionConfig config = RecognitionConfig.newBuilder()
                    .setEncoding(RecognitionConfig.AudioEncoding.ENCODING_UNSPECIFIED)
                    .setSampleRateHertz(16000)
                    .setLanguageCode("ko-KR")
                    .build();

            RecognitionAudio audio = getRecognitionAudio(filePath); // Audio 파일에 대한 RecognitionAudio 인스턴스 생성
            RecognizeResponse response = speech.recognize(config, audio); // 요청에 대한 응답
            List<SpeechRecognitionResult> results = response.getResultsList(); // 응답 결과들
            for (SpeechRecognitionResult result: results) {
                SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
                System.out.printf("Transcription: %s%n", alternative.getTranscript());
                text[0]=alternative.getTranscript();
            }
            speech.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        String result[] = new String[2];
        result = getSentiment(text[0]);
        text[1]=result[0];
        text[2]=result[1];

        return text;
    }

    public static String[] getSentiment(String text){
        String []result = new String[2];
        try {

            HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead
            HttpPost postRequest = new HttpPost("https://naveropenapi.apigw.ntruss.com/sentiment-analysis/v1/analyze"); //POST 메소드 URL 새성

            postRequest.addHeader("X-NCP-APIGW-API-KEY-ID", "w9jazjzk55");
            postRequest.addHeader("X-NCP-APIGW-API-KEY", "fDUi38NcCgGHvIVgivrb7EbVuX7IxXMnYr9sxXjD");
            postRequest.addHeader("Content-Type", "application/json; charset=UTF-8");
            JSONObject obj = new JSONObject();
            obj.put("content", text);

            StringEntity se = new StringEntity(obj.toString(),"UTF-8");
            se.setContentEncoding("UTF-8");
            se.setContentType("application/json");
            postRequest.setEntity(se);


            HttpResponse response = httpClient.execute(postRequest);		//Response 출력

            if (response.getStatusLine().getStatusCode() == 200) {
                ResponseHandler<String> handler = new BasicResponseHandler();
                String body = handler.handleResponse(response);
                String []tempBody = body.split(",");
                String []tempBody2 = tempBody[0].split(":");
                result[0]=tempBody2[2].substring(1, tempBody2[2].length()-1);

                result[1] = body.split(result[0])[2].substring(2, 4);
            } else {
                System.out.println("response is error : " + response.getStatusLine().getStatusCode());
            }
        } catch (Exception e){
            System.err.println(e.toString());
        }
        return result;
    }
     //Local 이나 Remote이거나 구분해서 RecognitionAudio 만들어 주는 부분
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
            System.out.println(audioBytes);

            recognitionAudio = RecognitionAudio.newBuilder()
                    .setContent(audioBytes)
                    .build();
        }

        return recognitionAudio;
    }
}
