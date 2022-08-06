package com.dearme.demo.domain.group.entity;

import com.dearme.demo.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "counselor_id")
    private User counselor;

    private String title;

    private String contents;

    private Long price;

    public void setCounselor(User counselor) {
        counselor.getGroups().add(this);
        this.counselor = counselor;
    }

    @Builder
    public Group(String title, String contents, Long price){
        this.title = title;
        this.contents = contents;
        this.price = price;
    }
}
