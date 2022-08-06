package com.dearme.demo.domain.user.dto.counselor;

import com.dearme.demo.domain.board.entity.Board;
import com.dearme.demo.domain.board.entity.Comment;
import com.dearme.demo.domain.review.entity.Review;
import com.dearme.demo.domain.user.dto.user.CounselorProfileInfoDto;
import com.dearme.demo.domain.user.entity.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class CounselorsViewResponseDto {
    private Long userid;

    private String nickName;

    private String pictureUrl;

    private double value;
    private Long reviewcnt;
    private List<Category> categories;

}
