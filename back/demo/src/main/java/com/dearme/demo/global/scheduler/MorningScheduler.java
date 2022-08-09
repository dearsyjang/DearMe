package com.dearme.demo.global.scheduler;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MorningScheduler {
    @Scheduled(cron = "0 30 8 ? * *")   //매일 오전 8시 30분에
    public void cronJobSch() throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Java cron job expression:: " + strDate);
        HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead

        HttpPost postRequest = new HttpPost("https://fcm.googleapis.com/fcm/send"); //POST 메소드 URL 새성

        postRequest.addHeader("Authorization", "key=AAAAKS2P-dM:APA91bGITP1z00rK_NARUuqMhETEsfcnUoPtAcXpZhVRxhSKo_BIHWSobaH76n1_pNtf7kDqpV4HC2_YiyZkKaM2PfzSzfxKrpDtFny2jM6IDyZOX2NObYW30yyypmFRnHKwIa-3Ix54");
        postRequest.addHeader("Content-Type", "application/json");


        JSONArray jsonArray = new JSONArray();
        JSONObject json = new JSONObject();
        json.put("title", "새벽 테스트 제목");
        json.put("body", "새벽 테스트 내용");

        JSONObject obj = new JSONObject();
        obj.put("to", "eprRC94iRxKgcWXgNGwOWN:APA91bH5xnP3osGxFGkYdESJw0BkwxdwxaBfVSyHVsZpQllxHk4YDfirNgkyQf152UWYspo-tngRjhoVO6HFtz7xPzksYACahDTMi7OZibD1RIqDSaXuq1YpYsONbfL3bIg3GQi0sDe7");
        obj.put("priority", "high");
        obj.put("notification", json);

        System.out.println(obj);

        StringEntity se = new StringEntity(obj.toString(),"UTF-8");
        se.setContentEncoding("UTF-8");
        se.setContentType("application/json");
        postRequest.setEntity(se);

        HttpResponse response = httpClient.execute(postRequest);		//Response 출력
        if (response.getStatusLine().getStatusCode() == 200) {
            System.out.println("푸시 알림 전송");
        } else {
            System.out.println("response is error : " + response.getStatusLine().getStatusCode());
        }
    }
}