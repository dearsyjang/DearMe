package com.dearme.demo.domain.counselingroom.service;

import com.dearme.demo.domain.counseling.entity.Counseling;
import com.dearme.demo.domain.counseling.exception.NoExistCounselingException;
import com.dearme.demo.domain.counseling.repository.CounselingRepository;
import com.dearme.demo.domain.counselingroom.dto.CreateCounselingRoomRequestDto;
import com.dearme.demo.domain.counselingroom.dto.CreateCounselingRoomResponseDto;
import com.dearme.demo.domain.counselingroom.dto.GetSessionTokenResponseDto;
import com.dearme.demo.domain.counselingroom.entity.CounselingRoom;
import com.dearme.demo.domain.counselingroom.repository.CounselingRoomRepository;
import com.dearme.demo.domain.user.entity.Type;
import com.dearme.demo.domain.user.entity.User;
import com.dearme.demo.domain.user.exception.NoExistCounselorException;
import com.dearme.demo.domain.user.exception.NoExistUserException;
import com.dearme.demo.domain.user.repository.UserRepository;
import io.openvidu.java.client.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CounselingRoomServiceImpl implements CounselingRoomService{

    private final UserRepository userRepository;

    private final CounselingRoomRepository counselingRoomRepository;

    private final CounselingRepository counselingRepository;

    private final OpenVidu openVidu;

    @Override
    public CreateCounselingRoomResponseDto createCounselingRoom(String id, CreateCounselingRoomRequestDto dto) throws OpenViduJavaClientException, OpenViduHttpException {
        User counselor = userRepository.findUserByIdAndTypeEquals(id, Type.COUNSELOR).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        Counseling counseling = counselingRepository.findCounselingByCounselor_IdAndId(id, dto.getCounselingId()).orElseThrow(() -> {
            throw new NoExistCounselorException();
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
                .build();
        counselingRoomRepository.save(counselingRoom);

        String userToken = session.createConnection(connectionProperties).getToken();

        counseling.updateCounselingRoom(counselingRoom, userToken);
        counselingRepository.save(counseling);
        return CreateCounselingRoomResponseDto.of(counselingRoom);
    }

    @Override
    public GetSessionTokenResponseDto getSessionToken(String id, Long counselingId) {
        Counseling counseling = counselingRepository.findCounselingByUser_IdAndId(id, counselingId).orElseThrow(() -> {
            throw new NoExistCounselingException();
        });
        return GetSessionTokenResponseDto.of(counseling);
    }
}
