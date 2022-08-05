package com.dearme.demo.domain.user.dto.counselor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CounselorViewResponseDto {
    private Long userid;

    private String nickName;

    private String pictureUrl;

    private double value;
    private Long reviewcnt;


}
