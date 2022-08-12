package com.dearme.demo.global.scheduler;

import com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CounselTimeJob implements Job {

    private static final SimpleDateFormat TIMESTAMP_FMT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSS");

    @Override
    public void execute(JobExecutionContext ctx) throws JobExecutionException {

        JobDataMap dataMap = ctx.getJobDetail().getJobDataMap();

        String ACCESS = dataMap.getString("ACCESS");
        String SECRET = dataMap.getString("SECRET");
        String ID_URL = dataMap.getString("ID_URL");
        String nickName = dataMap.getString("nickName");
        String date = dataMap.getString("date");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Java cron job expression:: " + strDate);
        try {

            HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead
            HttpPost postRequest = new HttpPost("https://sens.apigw.ntruss.com" + ID_URL); //POST 메소드 URL 새성
            String time = Long.toString(System.currentTimeMillis());
            postRequest.addHeader("x-ncp-apigw-timestamp", time);
            postRequest.addHeader("x-ncp-iam-access-key", ACCESS);
            postRequest.addHeader("x-ncp-apigw-signature-v2",makeSignature(time, ACCESS, SECRET, ID_URL) );
            postRequest.addHeader("Content-Type", "application/json; charset=UTF-8");


            JSONObject obj = new JSONObject();

            obj.put("type", "sms");
            obj.put("from", "01087624001");
            obj.put("content", "1");
            JSONObject obj2 = new JSONObject();
            obj2.put("to", "01087624001");
            obj2.put("content", date + "\n1시간 뒤 "+ nickName+ " 상담사님과 상담이 있어요!");
            ;
            List<JSONObject> jsonArray = new ArrayList<>();
            jsonArray.add(obj2);

            obj.put("messages", jsonArray);
            StringEntity se = new StringEntity(obj.toString(),"UTF-8");
            se.setContentEncoding("UTF-8");
            se.setContentType("application/json");
            postRequest.setEntity(se);


            HttpResponse response = httpClient.execute(postRequest);		//Response 출력
            if (response.getStatusLine().getStatusCode() == 200) {

                ResponseHandler<String> handler = new BasicResponseHandler();
                String body = handler.handleResponse(response);

            } else {
                System.out.println("response is error : " + response.getStatusLine().getStatusCode());
            }
        } catch (Exception e){
            System.err.println(e.toString());
        }
    }
    public static String makeSignature(String time, String ACCESS, String SECRET, String ID_URL) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        String space = " ";                    // one space
        String newLine = "\n";                    // new line
        String method = "POST";                    // method
        String url = ID_URL;    // url (include query string)
        String timestamp = time;            // current timestamp (epoch)
        String accessKey = ACCESS;            // access key id (from portal or Sub Account)
        String secretKey = SECRET;
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