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
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TextDiaryServiceImpl implements TextDiaryService{
    private final TextDiaryRepository textDiaryRepository;
    private final UserRepository userRepository;

    @Override
    public PostTextDiaryResponseDto postTextDiary(String id, PostTextDiaryRequestDto dto) {
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        TextDiary textDiary = dto.toEntity();
        textDiary.setUser(user);
        String[] text = getSentiment(dto.getContents());
        textDiary.setSentiment(text[0]);
        textDiary.setPercentage(Long.parseLong(text[1]));
        return new PostTextDiaryResponseDto(textDiaryRepository.save(textDiary).getId(), textDiary.getSentiment(), textDiary.getPercentage());
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
}
