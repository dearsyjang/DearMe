package com.dearme.demo.global.scheduler;

import com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64;
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

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CounselTimeJob implements Job {

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
    public static String makeSignature(String time) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        String space = " ";                    // one space
        String newLine = "\n";                    // new line
        String method = "POST";                    // method
        String url = "/sms/v2/services/ncp:sms:kr:257491845770:deame/messages";    // url (include query string)
        String timestamp = time;            // current timestamp (epoch)
        String accessKey = "TMT1IsuM3qkEm2yQn6XI";            // access key id (from portal or Sub Account)
        String secretKey = "x6qkoe05cswMJdyhFSv090qcNywkkG1qcTFYiE1r";
        String message = new StringBuilder()
                .append(method)
                .append(space)
                .append(url)
                .append(newLine)
                .append(timestamp)
                .append(newLine)
                .append(accessKey)
                .toString();
        SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(signingKey);

        byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
        String encodeBase64String = Base64.encodeBase64String(rawHmac);
        return encodeBase64String;
    }
}