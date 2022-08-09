package com.dearme.demo.domain.group.service;

import com.dearme.demo.domain.group.dto.CreateGroupRequestDto;
import com.dearme.demo.domain.group.dto.CreateGroupResponseDto;
import com.dearme.demo.domain.group.entity.Group;
import com.dearme.demo.domain.group.exception.UserCreateGroupException;
import com.dearme.demo.domain.group.repository.GroupRepository;
import com.dearme.demo.domain.user.entity.Type;
import com.dearme.demo.domain.user.entity.User;
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
            throw new NoExistUserException();
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
        groupRepository.deleteGroupByCounselor_IdAndId(id, groupId);
    }
}
