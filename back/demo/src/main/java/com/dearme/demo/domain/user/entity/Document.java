package com.dearme.demo.domain.user.entity;

import com.dearme.demo.domain.base.entitiy.Base;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Document extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonManagedReference // 순환참조 방지
    @JoinColumn(name = "counselor_id")
    private CounselorProfile counselorProfile;

    public void setCounselorProfile(CounselorProfile counselorProfile){
        counselorProfile.getDocuments().add(this);
        this.setCounselorProfile(counselorProfile);
    }

    private String realFileName;
    private String fileName;

    public void updateFileName(String fileName){
        this.fileName = fileName;
    }
}
