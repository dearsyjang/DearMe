package com.dearme.demo.global.scheduler;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CounselJob implements Job {

    private static final SimpleDateFormat TIMESTAMP_FMT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSS");

    @Override
    public void execute(JobExecutionContext ctx) throws JobExecutionException {

        JobDataMap dataMap = ctx.getJobDetail().getJobDataMap();

        String nickName = dataMap.getString("nickName");
        String date = dataMap.getString("date");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Java cron job expression:: " + strDate);
        HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead

        HttpPost postRequest = new HttpPost("https://fcm.googleapis.com/fcm/send"); //POST 메소드 URL 새성

        postRequest.addHeader("Authorization", "key=AAAAKS2P-dM:APA91bGITP1z00rK_NARUuqMhETEsfcnUoPtAcXpZhVRxhSKo_BIHWSobaH76n1_pNtf7kDqpV4HC2_YiyZkKaM2PfzSzfxKrpDtFny2jM6IDyZOX2NObYW30yyypmFRnHKwIa-3Ix54");
        postRequest.addHeader("Content-Type", "application/json");


        JSONObject json = new JSONObject();
        json.put("title", "💌 " + date);
        json.put("body", nickName+" 상담사님과 1시간 뒤에 상담이 있어요. 마음을 가라앉히고 준비해주세요.⏳");
        json.put("image", "https://firebasestorage.googleapis.com/v0/b/dear-me-a0ca1.appspot.com/o/dearme.PNG?alt=media&token=5fdd01eb-f6e7-47e5-9f90-672e4aa67b2b");
        json.put("color", "#ffb0f7");

        JSONObject obj = new JSONObject();
        obj.put("to", "eprRC94iRxKgcWXgNGwOWN:APA91bH5xnP3osGxFGkYdESJw0BkwxdwxaBfVSyHVsZpQllxHk4YDfirNgkyQf152UWYspo-tngRjhoVO6HFtz7xPzksYACahDTMi7OZibD1RIqDSaXuq1YpYsONbfL3bIg3GQi0sDe7");
        obj.put("priority", "high");
        obj.put("notification", json);

        System.out.println(obj);

        StringEntity se = new StringEntity(obj.toString(),"UTF-8");
        se.setContentEncoding("UTF-8");
        se.setContentType("application/json");
        postRequest.setEntity(se);

        HttpResponse response = null;		//Response 출력
        try {
            response = httpClient.execute(postRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (response.getStatusLine().getStatusCode() == 200) {
            System.out.println("푸시 알림 전송");
        } else {
            System.out.println("response is error : " + response.getStatusLine().getStatusCode());
        }
    }
}