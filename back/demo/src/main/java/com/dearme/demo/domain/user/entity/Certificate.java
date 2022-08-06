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
public class Certificate extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contents;

    @ManyToOne
    @JsonManagedReference // 순환참조 방지
    @JoinColumn(name = "counselor_id")
    private CounselorProfile counselorProfile;

    public void setCounselorProfile(CounselorProfile counselorProfile){
        counselorProfile.getCertificates().add(this);
        this.counselorProfile = counselorProfile;
    }

    public void updateCertificate(String contents){
        this.contents = contents;
    }

    @Builder
    public Certificate(String contents){
        this.contents = contents;
    }
}
