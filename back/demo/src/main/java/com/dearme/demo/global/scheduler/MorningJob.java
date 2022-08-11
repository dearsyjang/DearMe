package com.dearme.demo.global.scheduler;

import com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
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

public class MorningJob implements Job {

    private static final SimpleDateFormat TIMESTAMP_FMT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSS");

    @Override
    public void execute(JobExecutionContext ctx) throws JobExecutionException {

//        JobDataMap dataMap = ctx.getJobDetail().getJobDataMap();
//
//        String type = dataMap.getString("type");
//        String sentiment = dataMap.getString("sentiment");
//        double percentage = dataMap.getDouble("percentage");
//
//        try {
//
//            HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead
//            HttpPost postRequest = new HttpPost("https://sens.apigw.ntruss.com/sms/v2/services/ncp:sms:kr:257491845770:deame/messages"); //POST 메소드 URL 새성
//            String time = Long.toString(System.currentTimeMillis());
//            postRequest.addHeader("x-ncp-apigw-timestamp", time);
//            postRequest.addHeader("x-ncp-iam-access-key", "TMT1IsuM3qkEm2yQn6XI");
//            postRequest.addHeader("x-ncp-apigw-signature-v2",makeSignature(time) );
//            postRequest.addHeader("Content-Type", "application/json; charset=UTF-8");
//
//            String s = getYesterday(sentiment, percentage);
//            String []split=s.split(",");
//            JSONObject obj = new JSONObject();
//            if(type.equals("textDiary")) type="글 일기";
//            else type="영상 일기";
//
//            obj.put("type", "sms");
//            obj.put("from", "01087624001");
//            obj.put("content", "1");
//            JSONObject obj2 = new JSONObject();
//            obj2.put("to", "01087624001");
//            if(sentiment.equals("neutral"))
//                obj2.put("content", "오늘의 명언\n" + split[0]+"\n" + split[1]);
//            else{
//                obj2.put("content", "오늘의 편지(" +type + ")\n" + split[0] + "\n" + split[1]);
//            }
//            List<JSONObject> jsonArray = new ArrayList<>();
//            jsonArray.add(obj2);
//
//            obj.put("messages", jsonArray);
//            StringEntity se = new StringEntity(obj.toString(),"UTF-8");
//            se.setContentEncoding("UTF-8");
//            se.setContentType("application/json");
//            postRequest.setEntity(se);
//
//
//            HttpResponse response = httpClient.execute(postRequest);		//Response 출력
//            if (response.getStatusLine().getStatusCode() == 200) {
//
//                ResponseHandler<String> handler = new BasicResponseHandler();
//                String body = handler.handleResponse(response);
//
//            } else {
//                System.out.println("response is error : " + response.getStatusLine().getStatusCode());
//            }
//        } catch (Exception e){
//            System.err.println(e.toString());
//        }

    }
    public String getYesterday(String sentiment, double percentage){
        StringBuilder sb= new StringBuilder();

        if(sentiment.equals("positive")){
            if(percentage>=99){
                sb.append("어제는 정말 완벽한 하루였어요!,오늘도 어제처럼 완벽하게!");
            }else if(percentage>=95){
                sb.append("어제는 좋은 일이 많으셨군요!,이대로 좋은 일만 계속되기를!");
            }else if(percentage>=90){
                sb.append("어제는 좋은 일이 가득했어요!,오늘도 좋은 일이 많을거에요!");
            }else if(percentage>=80){
                sb.append("오늘도 어제처럼,행복한 하루를 보내시길 바래요!");
            }else if(percentage>=70){
                sb.append("안 좋은 일이 있어도 괜찮아요,오늘은 행복한 일이 더 많이 있을거에요!");
            }else if(percentage>=55){
                sb.append("어제는 감정의 변화가 많으셨네요,오늘은 행복한 감정만 가득할거에요!");
            }
        }else if(sentiment.equals("negative")){
            if(percentage>=99){
                sb.append("어제는 기분이 안 좋은 날이였어요,하지만 오늘은 좋은 날이 될 거에요!");
            }else if(percentage>=95){
                sb.append("어제는 안 좋은 일이 많으셨죠?,하지만 오늘은 좋은 일이 많을거에요!");
            }else if(percentage>=90) {
                sb.append("어제는 속상한 일이 많으셨군요,오늘은 행복한 하루를 보내봐요!");
            }else if(percentage>=80){
                sb.append("어제는 안 좋은 일이 있으셨군요,오늘은 행복한 하루가 되길 기원할게요!");
            }else if(percentage>=70){
                sb.append("안 좋은 일이 있어도 괜찮아요,오늘은 행복한 일이 더 많이 있을거에요!");
            }else if(percentage>=55){
                sb.append("어제는 감정의 변화가 많으셨네요,오늘은 행복한 감정만 가득할거에요!");
            }
        }else{
            String []text = {"피할수 없으면 즐겨라.,- 로버트 엘리엇",
                    "절대 어제를 후회하지 마라.,- L.론허바드",
                    "한번의 실패와 영원한 실패를 혼동하지 마라.,- F.스콧 핏제랄드",
                    "작은 기회로 부터 종종 위대한 업적이 시작된다.,- 데모스테네스",
                    "내 비장의 무기는 아직 손안에 있다 .그것은 희망이다.,- 나폴레옹",
                    "겨울이 오면 봄이 멀지 않으리.,- 셸리",
                    "문제점을 찾지 말고 해결책을 찾으라.,- 헨리포드"};
            int i = (int)((Math.random()*10000)%6);
            sb.append(text[i]);
        }
        return sb.toString();

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