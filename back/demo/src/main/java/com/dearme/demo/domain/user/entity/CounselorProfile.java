package com.dearme.demo.domain.user.entity;

import com.dearme.demo.domain.base.entitiy.Base;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class CounselorProfile extends Base {
    @Id
    @Column(name = "couselor_id")
    private Long counselorId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "counselor_id")
    @Setter
    private User counselor;

    @Column(nullable = false)
    @Setter
    private Long price;

    @Column(nullable = false)
    @Setter
    private String introduce;

    @Setter
    private Long reviewValue;

    @Setter
    private Long reviewCnt;

    @OneToMany(mappedBy = "counselorProfile", orphanRemoval = true, cascade = CascadeType.ALL)
    @Setter
    private List<Document> documents = new ArrayList<>();

    @OneToMany(mappedBy = "counselorProfile", orphanRemoval = true, cascade = CascadeType.ALL)
    @Setter
    private List<Career> careers = new ArrayList<>();

    @OneToMany(mappedBy = "counselorProfile", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Setter
    private List<Certificate> certificates = new ArrayList<>();

    @OneToMany(mappedBy = "counselorProfile", orphanRemoval = true, cascade = CascadeType.ALL)
    @Setter
    private List<Category> categories = new ArrayList<>();

    public void updateReviewValue(Long value, int num){
        this.reviewValue += value;
        this.reviewCnt +=num;
    }

    public void updateCounselorProfile(Long price, String introduce){
        this.price = price;
        this.introduce = introduce;
    }

    @Builder
    public CounselorProfile(Long price, String introduce, Long value, Long reviewCnt) {
        this.price = price;
        this.introduce = introduce;
        this.reviewValue = value;
        this.reviewCnt=reviewCnt;
    }
}
