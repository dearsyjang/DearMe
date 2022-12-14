package com.dearme.demo.domain.counselingdocument.entity;

import com.dearme.demo.domain.counseling.entity.Counseling;
import com.dearme.demo.domain.counseling.entity.Status;
import com.dearme.demo.domain.group.entity.Group;
import com.dearme.demo.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CounselingDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "counseling_document_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "counselor_id")
    private User counselor;

    private Integer year;

    private Integer month;

    private Integer day;

    private Integer hours;

    private String contents;

    private Boolean isOpen;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "counseling_id")
    private Counseling counseling;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public void setGroup(Group group){
        this.group = group;
    }

    public void setCounseling(Counseling counseling){
        this.counseling = counseling;
    }

    public void setUser(User user){
        user.getUserCounselingDocuments().add(this);
        this.user = user;
    }

    public void setCounselor(User counselor){
        counselor.getUserCounselingDocuments().add(this);
        this.counselor = counselor;
    }

    @Builder
    public CounselingDocument(Integer year, Integer month, Integer day, Integer hours, String contents, Boolean isOpen){
        this.year = year;
        this.month = month;
        this.day = day;
        this.hours=hours;
        this.contents = contents;
        this.isOpen = isOpen;
    }

    public Counseling toCounselingEntity(){
        return Counseling.builder()
                .user(this.user)
                .group(null)
                .counselor(this.counselor)
                .year(this.year)
                .month(this.month)
                .day(this.day)
                .hours(this.hours)
                .status(Status.UNACCEPTED)
                .build();
    }

    public Counseling toGroupCounselingEntity(){
        return Counseling.builder()
                .user(this.user)
                .counselor(this.counselor)
                .group(this.group)
                .status(Status.UNACCEPTED)
                .build();
    }
}
