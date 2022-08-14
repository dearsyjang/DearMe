package com.dearme.demo.domain.counselingroom.service;

import com.dearme.demo.domain.counseling.entity.Counseling;
import com.dearme.demo.domain.counseling.exception.NoExistCounselingException;
import com.dearme.demo.domain.counseling.repository.CounselingRepository;
import com.dearme.demo.domain.counselingroom.dto.CreateCounselingRoomRequestDto;
import com.dearme.demo.domain.counselingroom.dto.CreateCounselingRoomResponseDto;
import com.dearme.demo.domain.counselingroom.dto.CreateGroupCounselingRoomRequestDto;
import com.dearme.demo.domain.counselingroom.dto.GetSessionTokenResponseDto;
import com.dearme.demo.domain.counselingroom.entity.CounselingRoom;
import com.dearme.demo.domain.counselingroom.exception.CounselingRoomNotCreatedYet;
import com.dearme.demo.domain.counselingroom.repository.CounselingRoomRepository;
import com.dearme.demo.domain.group.entity.Group;
import com.dearme.demo.domain.group.exception.GroupNotFoundExcetion;
import com.dearme.demo.domain.group.repository.GroupRepository;
import com.dearme.demo.domain.user.entity.Type;
import com.dearme.demo.domain.user.entity.User;
import com.dearme.demo.domain.user.exception.NoExistCounselorException;
import com.dearme.demo.domain.user.exception.NoExistUserException;
import com.dearme.demo.domain.user.repository.GroupUserRepository;
import com.dearme.demo.domain.user.repository.UserRepository;
import io.openvidu.java.client.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class CounselingRoomServiceImpl implements CounselingRoomService{

    private final UserRepository userRepository;

    private final CounselingRoomRepository counselingRoomRepository;

    private final CounselingRepository counselingRepository;

    private final GroupRepository groupRepository;

    private final OpenVidu openVidu;

    private Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    @Override
    public CreateCounselingRoomResponseDto createCounselingRoom(String id, CreateCounselingRoomRequestDto dto) throws OpenViduJavaClientException, OpenViduHttpException {
        User counselor = userRepository.findUserByIdAndTypeEquals(id, Type.COUNSELOR).orElseThrow(() -> {
            throw new NoExistCounselorException();
        });
        Counseling counseling = counselingRepository.findCounselingByCounselor_IdAndId(id, dto.getCounselingId()).orElseThrow(() -> {
            throw new NoExistCounselingException();
        });
        String sessionName = UUID.randomUUID().toString();

        ConnectionProperties connectionProperties = new ConnectionProperties.Builder()
                .type(ConnectionType.WEBRTC)
                .role(OpenViduRole.PUBLISHER).build();

        Session session = openVidu.createSession();
        String counselorToken = session.createConnection(connectionProperties).getToken();

        CounselingRoom counselingRoom = CounselingRoom.builder()
                .sessionName(sessionName)
                .counselor(counselor)
                .counselorToken(counselorToken)
                .counseling(counseling)
                .build();
        counselingRoomRepository.save(counselingRoom);

        sessionMap.put(sessionName, session);

        counseling.updateCounselingRoom(counselingRoom);
        counselingRepository.save(counseling);
        return CreateCounselingRoomResponseDto.of(counselingRoom);
    }

    @Override
    public GetSessionTokenResponseDto getSessionToken(String id, Long counselingId) throws OpenViduJavaClientException, OpenViduHttpException {

        Counseling counseling = counselingRepository.findCounselingByUser_IdAndId(id, counselingId).orElseThrow(() -> {
            throw new NoExistCounselingException();
        });

        if(counseling.getCounselingRoom() == null)
            throw new CounselingRoomNotCreatedYet();

        String sessionName = counseling.getCounselingRoom().getSessionName();
        Session session = sessionMap.get(sessionName);

        ConnectionProperties connectionProperties = new ConnectionProperties.Builder()
                .type(ConnectionType.WEBRTC)
                .role(OpenViduRole.SUBSCRIBER).build();

        String token = session.createConnection(connectionProperties).getToken();
        counseling.updateToken(token);

        return GetSessionTokenResponseDto.of(counseling);
    }

    @Override
    public CreateCounselingRoomResponseDto createGroupCounselingRoom(String id, CreateGroupCounselingRoomRequestDto dto) throws OpenViduJavaClientException, OpenViduHttpException {
        User counselor = userRepository.findUserByIdAndTypeEquals(id, Type.COUNSELOR).orElseThrow(() -> {
            throw new NoExistCounselorException();
        });
        Group group = groupRepository.findById(dto.getGroupId()).orElseThrow(() -> {
            throw new GroupNotFoundExcetion();
        });

        String sessionName = UUID.randomUUID().toString();

        ConnectionProperties connectionProperties = new ConnectionProperties.Builder()
                .type(ConnectionType.WEBRTC)
                .role(OpenViduRole.PUBLISHER).build();

        Session session = openVidu.createSession();
        String counselorToken = session.createConnection(connectionProperties).getToken();

        CounselingRoom counselingRoom = CounselingRoom.builder()
                .sessionName(sessionName)
                .counselor(counselor)
                .counselorToken(counselorToken)
                .group(group)
                .build();
        counselingRoomRepository.save(counselingRoom);

        List<Counseling> counselings = counselingRepository.findAllByGroup_Id(counselingRoom.getGroup().getId());
        for(Counseling counseling : counselings){
            counseling.updateCounselingRoom(counselingRoom);
            counselingRepository.save(counseling);
        }

        sessionMap.put(sessionName, session);

        return CreateCounselingRoomResponseDto.of(counselingRoom);
    }
}
