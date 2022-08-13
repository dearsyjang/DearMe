package com.dearme.demo.domain.group.service;

import com.dearme.demo.domain.group.dto.CreateGroupRequestDto;
import com.dearme.demo.domain.group.dto.CreateGroupResponseDto;
import com.dearme.demo.domain.group.dto.GroupInfoResponseDto;
import com.dearme.demo.domain.group.entity.Group;
import com.dearme.demo.domain.group.exception.GroupDeleteException;
import com.dearme.demo.domain.group.exception.GroupNotFoundExcetion;
import com.dearme.demo.domain.group.exception.UserCreateGroupException;
import com.dearme.demo.domain.group.repository.GroupRepository;
import com.dearme.demo.domain.user.entity.Type;
import com.dearme.demo.domain.user.entity.User;
import com.dearme.demo.domain.user.exception.NoExistCounselorException;
import com.dearme.demo.domain.user.exception.NoExistUserException;
import com.dearme.demo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService{

    private final UserRepository userRepository;

    private final GroupRepository groupRepository;

    @Override
    public CreateGroupResponseDto createGroup(String id, CreateGroupRequestDto dto) {
        User counselor = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistCounselorException();
        });
        if(counselor.getType().equals(Type.USER)){
            throw new UserCreateGroupException();
        }
        Group group = dto.toEntity();
        group.setCounselor(counselor);
        return new CreateGroupResponseDto(groupRepository.save(group).getId());
    }

    @Override
    @Transactional
    public void deleteCounselorGroup(String id, Long groupId) {
        User counselor = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistCounselorException();
        });
        Group group = groupRepository.findById(groupId).orElseThrow(() -> {
            throw new GroupNotFoundExcetion();
        });
        if(counselor.getUserId().equals(group.getCounselor().getUserId())){
            groupRepository.deleteGroupByCounselor_IdAndId(id, groupId);
        }else{
            throw new GroupDeleteException();
        }
    }

    @Override
    public GroupInfoResponseDto getGroupInfo(Long groupId) {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> {
            throw new GroupNotFoundExcetion();
        });
        return GroupInfoResponseDto.of(group);
    }
}
