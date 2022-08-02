package com.dearme.demo.domain.user.entity;

import com.dearme.demo.domain.base.entitiy.Base;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
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
    private Long value;

    @OneToMany(mappedBy = "counselorProfile", orphanRemoval = true, cascade = CascadeType.ALL)
    @Setter
    private List<Document> documents = new ArrayList<>();

    @OneToMany(mappedBy = "counselorProfile", orphanRemoval = true, cascade = CascadeType.ALL)
    @Setter
    private List<Career> careers = new ArrayList<>();

    @OneToMany(mappedBy = "counselorProfile", orphanRemoval = true, cascade = CascadeType.ALL)
    @Setter
    private List<Certificate> certificates = new ArrayList<>();

    @OneToMany(mappedBy = "counselorProfile", orphanRemoval = true, cascade = CascadeType.ALL)
    @Setter
    private List<Category> categories = new ArrayList<>();

    @Builder
    public CounselorProfile(Long price, String introduce, Long value) {
        this.price = price;
        this.introduce = introduce;
        this.value = value;
    }
}
