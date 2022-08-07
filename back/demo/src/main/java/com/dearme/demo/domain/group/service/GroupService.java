package com.dearme.demo.domain.group.service;

import com.dearme.demo.domain.group.dto.CreateGroupRequestDto;
import com.dearme.demo.domain.group.dto.CreateGroupResponseDto;

public interface GroupService {
    CreateGroupResponseDto createGroup(String id, CreateGroupRequestDto dto);
}
