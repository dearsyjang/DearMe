package com.dearme.demo.domain.counseling.entity;

import com.dearme.demo.domain.counselingdocument.entity.CounselingDocument;
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

    @OneToOne(mappedBy = "counseling")
    @JoinColumn(name = "counseling_document_id")
    private CounselingDocument counselingDocument;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public void updateCounseling(Status status){
        this.status = status;
    }

    public void setCounselingDocument(CounselingDocument counselingDocument) {
        counselingDocument.setCounseling(this);
        this.counselingDocument = counselingDocument;
    }

    @Builder
    public Counseling(User user, Group group, User counselor, Integer year, Integer month, Integer day, Status status){
        this.user = user;
        this.counselor = counselor;
        this.group = group;
        this.year = year;
        this.month = month;
        this.day = day;
        this.status = status;
    }
}
