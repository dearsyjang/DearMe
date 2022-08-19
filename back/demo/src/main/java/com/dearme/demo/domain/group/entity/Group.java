package com.dearme.demo.domain.group.entity;

import com.dearme.demo.domain.user.entity.GroupUser;
import com.dearme.demo.domain.user.entity.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "counselor_id")
    private User counselor;

    private String title;

    private String contents;

    private Long price;

    private Long day;

    private Long hours;

    @OneToMany(mappedBy = "group", orphanRemoval = true, cascade = CascadeType.ALL)
    List<GroupUser> groupUsers = new ArrayList<>();

    public void setCounselor(User counselor) {
        counselor.getGroups().add(this);
        this.counselor = counselor;
    }

    @Builder
    public Group(String title, String contents, Long price, Long day, Long hours){
        this.title = title;
        this.contents = contents;
        this.price = price;
        this.day=day;
        this.hours=hours;
    }
}
