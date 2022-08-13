package com.dearme.demo.domain.user.entity;

import com.dearme.demo.domain.base.entitiy.Base;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Category extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    private String contents;

    @ManyToOne
    @JoinColumn(name = "counselor_id")
    private CounselorProfile counselorProfile;

    public void setCounselorProfile(CounselorProfile counselorProfile){
        counselorProfile.getCategories().add(this);
        this.counselorProfile = counselorProfile;
    }

    public void updateCategory(String contents){
        this.contents = contents;
    }

    @Builder
    public Category(String contents){
        this.contents = contents;
    }
}
