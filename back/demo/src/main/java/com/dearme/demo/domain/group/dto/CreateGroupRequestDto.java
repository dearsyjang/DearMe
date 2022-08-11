package com.dearme.demo.domain.group.dto;

import com.dearme.demo.domain.group.entity.Group;
import lombok.Data;

@Data
public class CreateGroupRequestDto {
    private String title;
    private String contents;
    private Long price;

    public Group toEntity(){
        return Group.builder().title(this.title).contents(this.contents).price(this.price).build();
    }
}
