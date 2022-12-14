package com.dearme.demo.domain.counseling.entity;

import com.dearme.demo.domain.counselingdocument.entity.CounselingDocument;
import com.dearme.demo.domain.counselingroom.entity.CounselingRoom;
import com.dearme.demo.domain.group.entity.Group;
import com.dearme.demo.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Counseling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "counseling_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "counselor_id")
    private User counselor;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    private Integer year;

    private Integer month;

    private Integer day;

    private Integer hours;

    @OneToOne(mappedBy = "counseling", cascade = CascadeType.ALL)
    @JoinColumn(name = "counseling_document_id")
    private CounselingDocument counselingDocument;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "counseling_room_id")
    private CounselingRoom counselingRoom;

    private String token;

    public void updateToken(String token){
        this.token = token;
    }

    public void updateCounselingRoom(CounselingRoom counselingRoom){
        counselingRoom.getCounselings().add(this);
        this.counselingRoom = counselingRoom;
    }

    public void updateCounseling(Status status){
        this.status = status;
    }

    public void setCounselingDocument(CounselingDocument counselingDocument) {
        counselingDocument.setCounseling(this);
        this.counselingDocument = counselingDocument;
    }

    @Builder
    public Counseling(User user, Group group, User counselor, Integer year, Integer month, Integer day, Integer hours, Status status){
        this.user = user;
        this.counselor = counselor;
        this.group = group;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hours=hours;
        this.status = status;
    }
}
