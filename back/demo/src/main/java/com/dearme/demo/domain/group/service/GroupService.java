package com.dearme.demo.domain.group.service;

import com.dearme.demo.domain.group.dto.CreateGroupRequestDto;
import com.dearme.demo.domain.group.dto.CreateGroupResponseDto;
import com.dearme.demo.domain.group.dto.GroupInfoResponseDto;

public interface GroupService {
    CreateGroupResponseDto createGroup(String id, CreateGroupRequestDto dto);

    GroupInfoResponseDto getGroupInfo(Long groupId);
}