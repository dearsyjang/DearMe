package com.dearme.demo.domain.counselingdocument.entity;

import com.dearme.demo.domain.counseling.entity.Counseling;
import com.dearme.demo.domain.counseling.entity.Type;
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

    private String contents;

    private Boolean isOpen;

    @OneToOne
    @JoinColumn(name = "counseling_id")
    private Counseling counseling;

    public void setCounseling(Counseling counseling){
        this.counseling = counseling;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setCounselor(User counselor){
        this.counselor = counselor;
    }

    @Builder
    public CounselingDocument(Integer year, Integer month, Integer day, String contents, Boolean isOpen){
        this.year = year;
        this.month = month;
        this.day = day;
        this.contents = contents;
        this.isOpen = isOpen;
    }

    public Counseling toCounselingEntity(){
        return Counseling.builder()
                .user(this.user)
                .counselor(this.counselor)
                .year(this.year)
                .month(this.month)
                .day(this.day)
                .type(Type.UNACCEPTED)
                .build();
    }
}
