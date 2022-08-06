package com.dearme.demo.domain.counsel.service;


import com.dearme.demo.domain.counsel.dto.VideoSaveResponseDto;
//import com.google.api.gax.core.CredentialsProvider;
//import com.google.api.gax.core.FixedCredentialsProvider;
//import com.google.auth.oauth2.ServiceAccountCredentials;
//import com.google.cloud.speech.v1.*;
//import com.google.protobuf.ByteString;
import lombok.RequiredArgsConstructor;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.ResponseHandler;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.BasicResponseHandler;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CounselServiceImpl implements CounselService{

    @Override
    @Transactional
    public VideoSaveResponseDto videoSave() {
//        String filePath = "src/main/resources/KOR_F_RM0769FLJH0325.pcm";
//        String text="";
//        try {
//            CredentialsProvider credentialsProvider = FixedCredentialsProvider.create(ServiceAccountCredentials.fromStream(new FileInputStream("src/main/resources/my-project-0801-358104-1615eb198267.json")));
//            SpeechSettings settings = SpeechSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
//            // Instantiates a client
//            SpeechClient speech=SpeechClient.create(settings);
//            // 오디오 파일에 대한 설정부분
//            RecognitionConfig config = RecognitionConfig.newBuilder()
//                    .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
//                    .setSampleRateHertz(16000)
//                    .setLanguageCode("ko-KR")
//                    .build();
//            RecognitionAudio audio = getRecognitionAudio(filePath); // Audio 파일에 대한 RecognitionAudio 인스턴스 생성
//            RecognizeResponse response = speech.recognize(config, audio); // 요청에 대한 응답
//            List<SpeechRecognitionResult> results = response.getResultsList(); // 응답 결과들
//
//            for (SpeechRecognitionResult result: results) {
//                SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
//                System.out.printf("Transcription: %s%n", alternative.getTranscript());
//                text=alternative.getTranscript();
//            }
//
//            speech.close();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        try {
//
//            HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead
//            HttpPost postRequest = new HttpPost("https://naveropenapi.apigw.ntruss.com/sentiment-analysis/v1/analyze"); //POST 메소드 URL 새성
//
//            postRequest.addHeader("X-NCP-APIGW-API-KEY-ID", "w9jazjzk55");
//            postRequest.addHeader("X-NCP-APIGW-API-KEY", "fDUi38NcCgGHvIVgivrb7EbVuX7IxXMnYr9sxXjD");
//            postRequest.addHeader("Content-Type", "application/json; charset=UTF-8");
//            JSONObject obj = new JSONObject();
//            obj.put("content", text);
//
//            StringEntity se = new StringEntity(obj.toString(),"UTF-8");
//            se.setContentEncoding("UTF-8");
//            se.setContentType("application/json");
//            postRequest.setEntity(se);
//
//
//            HttpResponse response = httpClient.execute(postRequest);		//Response 출력
//
//            if (response.getStatusLine().getStatusCode() == 200) {
//                ResponseHandler<String> handler = new BasicResponseHandler();
//                String body = handler.handleResponse(response);
//                System.out.println(body);
//            } else {
//                System.out.println("response is error : " + response.getStatusLine().getStatusCode());
//            }
//        } catch (Exception e){
//            System.err.println(e.toString());
//        }

//        return new VideoSaveResponseDto(text);
        return null;
    }
    // Local 이나 Remote이거나 구분해서 RecognitionAudio 만들어 주는 부분
//    public static RecognitionAudio getRecognitionAudio(String filePath) throws IOException {
//        RecognitionAudio recognitionAudio;
//
//        // 파일이 GCS에 있는 경우
//        if (filePath.startsWith("gs://")) {
//            recognitionAudio = RecognitionAudio.newBuilder()
//                    .setUri(filePath)
//                    .build();
//        }
//        else { // 파일이 로컬에 있는 경우
//            Path path = Paths.get(filePath);
//            byte[] data = Files.readAllBytes(path);
//            ByteString audioBytes = ByteString.copyFrom(data);
//
//            recognitionAudio = RecognitionAudio.newBuilder()
//                    .setContent(audioBytes)
//                    .build();
//        }
//
//        return recognitionAudio;
//    }
}
