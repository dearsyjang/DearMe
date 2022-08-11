package com.dearme.demo.domain.group.dto;

import lombok.Data;

@Data
public class UpdateGroupRequestDto {
    private Long groupId;
    private String title;
    private String contents;
    private Long price;
}
