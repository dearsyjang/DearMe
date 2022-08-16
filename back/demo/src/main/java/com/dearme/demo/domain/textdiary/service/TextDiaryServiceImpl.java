package com.dearme.demo.domain.textdiary.service;

import com.dearme.demo.domain.counselingdocument.entity.CounselingDocument;
import com.dearme.demo.domain.counselingdocument.exception.NoExistDocumentException;
import com.dearme.demo.domain.counselingdocument.repository.CounselingDocumentRepository;
import com.dearme.demo.domain.textdiary.dto.PostTextDiaryRequestDto;
import com.dearme.demo.domain.textdiary.dto.PostTextDiaryResponseDto;
import com.dearme.demo.domain.textdiary.dto.TextDiaryDetailsResponseDto;
import com.dearme.demo.domain.textdiary.dto.TextDiaryListResponseDto;
import com.dearme.demo.domain.textdiary.entity.TextDiary;
import com.dearme.demo.domain.textdiary.exception.AlreadyExistTextDiaryException;
import com.dearme.demo.domain.textdiary.exception.NoPermissionTextDiaryException;
import com.dearme.demo.domain.textdiary.exception.TextDiarySentimentException;
import com.dearme.demo.domain.textdiary.repository.TextDiaryRepository;
import com.dearme.demo.domain.user.entity.Type;
import com.dearme.demo.domain.user.entity.User;
import com.dearme.demo.domain.user.exception.NoExistUserException;
import com.dearme.demo.domain.user.repository.UserRepository;
import com.dearme.demo.domain.videodiary.exception.CounselorPostVideoDiaryException;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
public class TextDiaryServiceImpl implements TextDiaryService{
    private final TextDiaryRepository textDiaryRepository;
    private final UserRepository userRepository;
    private final CounselingDocumentRepository counselingDocumentRepository;

    @Value("${sentiment.id:0}")
    private String SENTIMENT_ID;
    @Value("${sentiment.key:0}")
    private String SENTIMENT_KEY;

    @Override
    public PostTextDiaryResponseDto postTextDiary(String id, PostTextDiaryRequestDto dto) {
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        if(user.getType().equals(Type.COUNSELOR))
            throw new CounselorPostVideoDiaryException();
        TextDiary textDiary = dto.toEntity();
        if (textDiaryRepository.existsTextDiaryByUser_IdAndYearAndMonthAndDay(id, textDiary.getYear(), textDiary.getMonth(), textDiary.getDay())) {
            throw new AlreadyExistTextDiaryException();
        }
        textDiary.setUser(user);
        textDiary.setSentimentInfo(getSentiment(dto.getContents()));
        return new PostTextDiaryResponseDto(textDiaryRepository.save(textDiary).getId(), textDiary.getSentiment(), textDiary.getPercentage(), textDiary.getPositive(), textDiary.getNegative(), textDiary.getNeutral());
    }

    @Override
    public TextDiaryDetailsResponseDto getDetails(String id, Long textDiaryId) {
        TextDiary textDiary = textDiaryRepository.findById(textDiaryId).get();
        if(!textDiary.getUser().getId().equals(id)) {
            Long userId = textDiary.getUser().getUserId();
            CounselingDocument latestCounselingDocument = counselingDocumentRepository.findTop1ByCounselor_IdAndUser_UserIdOrderByYearDescMonthDescHoursDesc(id, userId).orElseThrow(() -> {
                throw new NoExistDocumentException();
            });
            if(!latestCounselingDocument.getIsOpen())
                throw new NoPermissionTextDiaryException();
        }
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
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        TextDiary textDiary = textDiaryRepository.findById(textDiaryId).get();
        if(user.getId().equals(textDiary.getUser().getId()))
            textDiaryRepository.deleteByUser_IdAndId(id, textDiaryId);
        else
            throw new NoPermissionTextDiaryException();

    }

    @Override
    public TextDiaryListResponseDto getUserList(String id, Long userId, Integer year, Integer month) {
        CounselingDocument latestCounselingDocument = counselingDocumentRepository.findTop1ByCounselor_IdAndUser_UserIdOrderByYearDescMonthDescHoursDesc(id, userId).orElseThrow(() -> {
            throw new NoExistDocumentException();
        });
        User user = userRepository.findUserByUserId(userId).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        if(latestCounselingDocument.getIsOpen()){
            return getList(user.getId(), year, month);
        }
        throw new NoPermissionTextDiaryException();
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
                if(result.length!=5)
                    throw new TextDiarySentimentException();
                result[0]=jObj2.getString("sentiment");
                result[1]=max+"";
                result[2]=positive+"";
                result[3]=negative+"";
                result[4]=neutral+"";
            } else {
                throw new TextDiarySentimentException();
            }
        } catch (Exception e){
            throw new TextDiarySentimentException();
        }
        return result;
    }
}
