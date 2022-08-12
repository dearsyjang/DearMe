package com.dearme.demo.domain.textdiary.service;

import com.dearme.demo.domain.textdiary.dto.PostTextDiaryRequestDto;
import com.dearme.demo.domain.textdiary.dto.PostTextDiaryResponseDto;
import com.dearme.demo.domain.textdiary.dto.TextDiaryDetailsResponseDto;
import com.dearme.demo.domain.textdiary.dto.TextDiaryListResponseDto;
import com.dearme.demo.domain.textdiary.entity.TextDiary;
import com.dearme.demo.domain.textdiary.exception.NoPermissionTextDiaryException;
import com.dearme.demo.domain.textdiary.repository.TextDiaryRepository;
import com.dearme.demo.domain.user.entity.User;
import com.dearme.demo.domain.user.exception.NoExistUserException;
import com.dearme.demo.domain.user.repository.UserRepository;
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
import java.util.*;
import java.util.Calendar;

@Service
@RequiredArgsConstructor
public class TextDiaryServiceImpl implements TextDiaryService{
    private final TextDiaryRepository textDiaryRepository;
    private final UserRepository userRepository;

    @Value("${sentiment.id:0}")
    private String SENTIMENT_ID;
    @Value("${sentiment.key:0}")
    private String SENTIMENT_KEY;

    @Override
    public PostTextDiaryResponseDto postTextDiary(String id, PostTextDiaryRequestDto dto) {
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        TextDiary textDiary = dto.toEntity();
        textDiary.setUser(user);
        String[] text = getSentiment(dto.getContents());
        textDiary.setSentiment(text[0]);
        textDiary.setPercentage(Double.parseDouble(text[1]));
        textDiary.setPositive(Double.parseDouble(text[2]));
        textDiary.setNegative(Double.parseDouble(text[3]));
        textDiary.setNeutral(Double.parseDouble(text[4]));
        return new PostTextDiaryResponseDto(textDiaryRepository.save(textDiary).getId(), textDiary.getSentiment(), textDiary.getPercentage(), textDiary.getPositive(), textDiary.getNegative(), textDiary.getNeutral());
    }

    @Override
    public TextDiaryDetailsResponseDto getDetails(String id, Long textDiaryId) {
        TextDiary textDiary = textDiaryRepository.findById(textDiaryId).get();
        if(!textDiary.getUser().getId().equals(id)) throw new NoPermissionTextDiaryException();
        return TextDiaryDetailsResponseDto.of(textDiary);
    }

    @Override
    public TextDiaryListResponseDto getList(String id, Integer year, Integer month) {
        List<TextDiary> textDiaries = textDiaryRepository.findAllByUser_IdAndYearAndMonth(id, year, month);
        List<TextDiaryDetailsResponseDto> textDiaryDetailsResponseDtos = new ArrayList<>();
        for(TextDiary textDiary : textDiaries){
            textDiaryDetailsResponseDtos.add(TextDiaryDetailsResponseDto.of(textDiary));
        }
        TextDiaryListResponseDto dto = new TextDiaryListResponseDto();
        dto.setTextDiaries(textDiaryDetailsResponseDtos);
        return dto;
    }

    @Override
    @Transactional
    public void delete(String id, Long textDiaryId) {
        textDiaryRepository.deleteByUser_IdAndId(id, textDiaryId);
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

                double negative= Math.round(Float.parseFloat(jObj3.get("negative").toString())*100)/100.0;
                max=Math.max(max, negative);
                double positive= Math.round(Float.parseFloat(jObj3.get("positive").toString())*100)/100.0;
                max=Math.max(max, positive);
                double neutral= Math.round(Float.parseFloat(jObj3.get("neutral").toString())*100)/100.0;
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
}
