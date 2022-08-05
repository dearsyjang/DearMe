package com.dearme.demo.domain.videodiary.controller;

import io.openvidu.java.client.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/video-diaries")
@RequiredArgsConstructor
public class VideoServiceController {

    private final Logger log = LoggerFactory.getLogger(VideoServiceController.class);

    private final OpenVidu openVidu;

    private Map<String, Session> mapSessions = new ConcurrentHashMap<>();
    private Map<String, Map<String, OpenViduRole>> mapSessionNamesTokens = new ConcurrentHashMap<>();

    @GetMapping("/{sessionName}")
    public String test(HttpServletRequest request, @PathVariable(value = "sessionName") String sessionName){
        OpenViduRole role = OpenViduRole.PUBLISHER;
        String data = "{\"serverData\": \"" + (String) request.getAttribute("id") + "\"}";
        ConnectionProperties connectionProperties = new ConnectionProperties.Builder().type(ConnectionType.WEBRTC)
                .data(data).role(role).build();

        if(this.mapSessions.get(sessionName) != null){
            log.debug("{} is already Exist", sessionName);
            try {
                String token = this.mapSessions.get(sessionName).createConnection(connectionProperties).getToken();
                this.mapSessionNamesTokens.get(sessionName).put(token, role);
                log.debug("token : {} ", token);
                return token;
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }


        try {
            log.debug("sessionName : {} ", sessionName);
            Session session = openVidu.createSession();
            String token = session.createConnection(connectionProperties).getToken();
            log.debug("token : {} ", token);
            this.mapSessions.put(sessionName, session);
            this.mapSessionNamesTokens.put(sessionName, new ConcurrentHashMap<>());
            this.mapSessionNamesTokens.get(sessionName).put(token, role);
            return token;
        } catch (OpenViduJavaClientException e) {
            log.error("{}", e.getMessage());
        } catch (OpenViduHttpException e) {
            log.error("{}", e.getMessage());
        }
        return null;
    }
}
