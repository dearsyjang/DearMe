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

public class MorningJob implements Job {

    private static final SimpleDateFormat TIMESTAMP_FMT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSS");

    @Override
    public void execute(JobExecutionContext ctx) throws JobExecutionException {

        JobDataMap dataMap = ctx.getJobDetail().getJobDataMap();

        String type = dataMap.getString("type");
        String sentiment = dataMap.getString("sentiment");
        double percentage = dataMap.getDouble("percentage");

        HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead

        HttpPost postRequest = new HttpPost("https://fcm.googleapis.com/fcm/send"); //POST 메소드 URL 새성

        postRequest.addHeader("Authorization", "key=AAAAfMMdu8U:APA91bHhV2aDPJHR9sxLLLejjVFSLkv7N6jlBpdxfi6GBBKcR-v9p9ErGexoS-FFFtOKHjD8-Gq9f8ina_k_YorZT1W9QZDnv2M-DlgFqWNUUuR-QMRpBwOj8fNhp9cLpuFXoEPXV8Cg");
        postRequest.addHeader("Content-Type", "application/json");

        String s = getYesterday(sentiment, percentage);
        String []split=s.split(",");
        JSONObject json = new JSONObject();
        if(type.equals("textDairy")) type="글 일기";
        else type="영상 일기";
        json.put("title", "💌  "+type + " 오늘의 편지" + " : " + split[0]);
        json.put("body", split[1]);
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
    public String getYesterday(String sentiment, double percentage){
        StringBuilder sb= new StringBuilder();

        if(sentiment.equals("positive")){
            if(percentage>=99){
                sb.append("어제는 정말 완벽한 하루였어요!,🎉오늘도 어제처럼 완벽하게!");
            }else if(percentage>=95){
                sb.append("어제는 좋은 일이 많으셨군요!,✨이대로 좋은 일만 계속되기를!");
            }else if(percentage>=90){
                sb.append("어제는 좋은 일이 가득했어요!,🎈오늘도 좋은 일이 많을거에요!");
            }else if(percentage>=80){
                sb.append("오늘도 어제처럼,😁행복한 하루를 보내시길 바래요!");
            }else if(percentage>=70){
                sb.append("안 좋은 일이 있어도 괜찮아요..,😊오늘은 행복한 일이 더 많이 있을거에요!");
            }else if(percentage>=55){
                sb.append("어제는 기분이 좋아졌다가 안좋아졌다가 하셨죠?,🩹오늘은 기분 좋은 일만 가득할거에요!");
            }
        }else if(sentiment.equals("negative")){
            if(percentage>=99){
                sb.append("어제는 기분이 안 좋은 날이였어요 ㅠㅠ...,🌈하지만 오늘은 좋은 날이 될 거에요!");
            }else if(percentage>=95){
                sb.append("어제는 안 좋은 일이 많으셨죠? ㅠㅠ...,🌟하지만 오늘은 좋은 일이 많을거에요! 화이팅!");
            }else if(percentage>=90) {
                sb.append("어제는 속상한 일이 많으셨군요...,💨오늘 훌훌 털고 행복한 하루를 보내봐요!");
            }else if(percentage>=80){
                sb.append("어제는 안 좋은 일이 있으셨군요..,🙏오늘은 행복한 일이 더 많이 일어나도록 기원할게요!");
            }else if(percentage>=70){
                sb.append("안 좋은 일이 있어도 괜찮아요..,📈오늘은 행복한 일이 더 많이 있을거에요!");
            }else if(percentage>=55){
                sb.append("어제는 기분이 좋아졌다가 안좋아졌다가 하셨죠?,🩹오늘은 기분 좋은 일만 가득할거에요!");
            }
        }else{
            sb.append("어제는 평범한 날이였어요!,💞하지만 오늘은 뭔가 특별한 일이 생길지도...?");
        }
        return sb.toString();

    }
}