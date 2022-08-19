package com.dearme.demo.domain.user.dto.etc;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserGroupListResponseDto {
    List<UserGroupResponseDto> groups;
}
