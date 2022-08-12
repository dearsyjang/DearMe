package com.dearme.demo.domain.videodiary.service;


import com.dearme.demo.domain.user.entity.Type;
import com.dearme.demo.domain.user.entity.User;
import com.dearme.demo.domain.user.exception.NoExistUserException;
import com.dearme.demo.domain.user.repository.UserRepository;
import com.dearme.demo.domain.videodiary.dto.*;
import com.dearme.demo.domain.videodiary.entity.VideoDiary;
import com.dearme.demo.domain.videodiary.exception.CounselorPostVideoDiaryException;
import com.dearme.demo.domain.videodiary.exception.NoPermissionVideoDiaryException;
import com.dearme.demo.domain.videodiary.exception.NoVideoDiaryException;
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
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Calendar;

@Service
@RequiredArgsConstructor
public class VideoDiaryServiceImpl implements VideoDiaryService {
    private final UserRepository userRepository;
    private final VideoDiaryRepository videoDiaryRepository;
    @Value("${sentiment.id:0}")
    private String SENTIMENT_ID;
    @Value("${sentiment.key:0}")
    private String SENTIMENT_KEY;

    @Override
    public PostVideoDiaryResponseDto postVideoDiary(String id, PostVideoDiaryRequestDto dto) throws IOException {
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        if(user.getType().equals(Type.COUNSELOR))
            throw new CounselorPostVideoDiaryException();
        VideoDiary videoDiary = dto.toEntity();
        videoDiary.setUser(user);
        String[] text = videoSTT(videoDiary.getRealFileName());
        videoDiary.setContents(text[0]);
        videoDiary.setSentiment(text[1]);
        if(text[2].equals(null))
            throw new NoVideoDiaryException();
        videoDiary.setPercentage(Double.parseDouble(text[2]));
        videoDiary.setPositive(Double.parseDouble(text[3]));
        videoDiary.setNegative(Double.parseDouble(text[4]));
        videoDiary.setNeutral(Double.parseDouble(text[5]));
        videoDiaryRepository.save(videoDiary);
        return new PostVideoDiaryResponseDto(videoDiary.getId(), videoDiary.getTitle(), videoDiary.getContents(), videoDiary.getSentiment(), videoDiary.getPercentage(), videoDiary.getPositive(), videoDiary.getNegative(), videoDiary.getNeutral());
    }

    @Override
    public PostVideoDiaryResponseDto postUpdateVideoDiary(String id, Long videoDiaryId, PostUpdateVideoDiaryRequestDto dto) {
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        if(user.getType().equals(Type.COUNSELOR))
            throw new CounselorPostVideoDiaryException();
        VideoDiary videoDiary = videoDiaryRepository.findVideoDiaryById(videoDiaryId);
        if(user.getId().equals(videoDiary.getUser().getId())){
            videoDiary.updateTitle(dto.getTitle());
            videoDiary.updateContents(dto.getContents());
            if(dto.getSentiment().equals(videoDiary.getSentiment())){
                String result[] = new String[5];
                result = getSentiment(videoDiary.getContents());
                if(result[0].equals(null))
                    throw new NoVideoDiaryException();
                videoDiary.updateSentiment(result[0]);
                videoDiary.updatePercentage(Double.parseDouble(result[1]));
                videoDiary.updatePositive(Double.parseDouble(result[2]));
                videoDiary.updateNegative(Double.parseDouble(result[3]));
                videoDiary.updateNeutral(Double.parseDouble(result[4]));
            }else{
                videoDiary.updateSentiment(dto.getSentiment());
                videoDiary.updatePercentage(100);

                double posi=0, nega=0,neu=0;

                if(dto.getSentiment().equals("positive")) posi=100;
                else if(dto.getSentiment().equals("negative")) nega=100;
                else neu=100;

                videoDiary.updatePositive(posi);
                videoDiary.updateNegative(nega);
                videoDiary.updateNeutral(neu);
            }
        }else{
            throw new NoPermissionVideoDiaryException();
        }
        return new PostVideoDiaryResponseDto(videoDiary.getId(), videoDiary.getTitle(), videoDiary.getContents(), videoDiary.getSentiment(), videoDiary.getPercentage(),videoDiary.getPositive(), videoDiary.getNegative(), videoDiary.getNeutral());
    }

    @Override
    public VideoDiaryDetailsResponseDto getDetails(String id, Long videoDiaryId) {
        VideoDiary videoDiary = videoDiaryRepository.findById(videoDiaryId).get();
        if(!videoDiary.getUser().getId().equals(id))
            throw new NoPermissionVideoDiaryException();
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
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        VideoDiary videoDiary = videoDiaryRepository.findById(videoDiaryId).get();
        if(user.getId().equals(videoDiary.getUser().getId()))
            videoDiaryRepository.deleteByUser_IdAndId(id, videoDiaryId);
        else
            throw new NoPermissionVideoDiaryException();

    }


    public String[] videoSTT(String path){
        //서버에서 실행시킬 때

        String filePath = "/video/" + path + "/" + path;

        try{
            Process p = Runtime.getRuntime().exec("ffmpeg -i " + filePath + ".mp4 " + filePath + ".mp3");
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;

            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch(Exception e){
            System.out.println(e);
        }

        filePath = filePath+".mp3";

         String[] text= new String[6];
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
            StringBuilder sb =new StringBuilder();
            for (SpeechRecognitionResult result: results) {
                SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
                sb.append(alternative.getTranscript());
                System.out.printf("Transcription: %s%n", alternative.getTranscript());
            }
            text[0]=sb.toString();
            speech.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        String result[] = new String[5];
        result = getSentiment(text[0]);
        for(int i=1;i<=5;i++){
            text[i]=result[i-1];
        }

        return text;
    }

    public String[] getSentiment(String text){
        String []result = new String[5];
        try {

            HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead
            HttpPost postRequest = new HttpPost("https://naveropenapi.apigw.ntruss.com/sentiment-analysis/v1/analyze"); //POST 메소드 URL 새성

            postRequest.addHeader("X-NCP-APIGW-API-KEY-ID", SENTIMENT_ID);
            postRequest.addHeader("X-NCP-APIGW-API-KEY", SENTIMENT_KEY);
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

                JSONObject jObj = new JSONObject(body.toString());
                JSONObject jObj2 = jObj.getJSONObject("document");
                JSONObject jObj3 = jObj2.getJSONObject("confidence");

                result[0]=jObj2.getString("sentiment");
                double max=0;

                double negative= Math.round(Double.parseDouble(jObj3.get("negative").toString())*1000)/1000.0;
                max=Math.max(max, negative);
                double positive= Math.round(Double.parseDouble(jObj3.get("positive").toString())*1000)/1000.0;
                max=Math.max(max, positive);
                double neutral= Math.round(Double.parseDouble(jObj3.get("neutral").toString())*1000)/1000.0;
                max=Math.max(max, neutral);

                result[0]=jObj2.getString("sentiment");
                result[1]=max+"";
                result[2]=positive+"";
                result[3]=negative+"";
                result[4]=neutral+"";
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
