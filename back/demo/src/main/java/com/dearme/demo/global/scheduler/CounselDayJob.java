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

public class CounselDayJob implements Job {

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

        postRequest.addHeader("Authorization", "key=AAAAfMMdu8U:APA91bHhV2aDPJHR9sxLLLejjVFSLkv7N6jlBpdxfi6GBBKcR-v9p9ErGexoS-FFFtOKHjD8-Gq9f8ina_k_YorZT1W9QZDnv2M-DlgFqWNUUuR-QMRpBwOj8fNhp9cLpuFXoEPXV8Cg");
        postRequest.addHeader("Content-Type", "application/json");


        JSONObject json = new JSONObject();
        json.put("title", "💌 " + date);
        json.put("body", "1시간 뒤 "+ nickName+ " 상담사님과 상담이 있어요!");
        json.put("image", "https://firebasestorage.googleapis.com/v0/b/dear-me-fef2a.appspot.com/o/dearme.PNG?alt=media&token=e485b31a-550b-4c37-a42c-c351875e01d0");
        json.put("color", "#ffb0f7");

        JSONObject obj = new JSONObject();
        obj.put("to", "d1NeInnkSKSFAU3mAuunGM:APA91bFFGVm24wK0VW3Heg8pyba1FQ1ijTDei5IF9JXJRAPoz6766RsIgDf-BO1CRbLFUtrjeaxZOBBhPpv-lFN_OksQ2Ekt-5d5Vp2fYn23Fla9n3DDqdKesOGr9dWyZpNtChdLmj4B");
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