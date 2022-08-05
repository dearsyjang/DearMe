package com.dearme.demo.domain.review.entity;

import com.dearme.demo.domain.base.entitiy.Base;
import com.dearme.demo.domain.user.entity.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Review extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewid;

    @ManyToOne
    @JsonManagedReference // 순환참조 방지
    @JoinColumn(name="id")
    private User user;

    @Column(nullable = false)
    private String counselorid;

    @Column(nullable = false)
    private Long value;

    @Column(nullable = false)
    private String contents;

    public void setUser(User user){
        user.getReviews().add(this);
        this.user=user;
    }
    @Builder
    public Review(String counselorid, Long value, String contents) {
        this.counselorid = counselorid;
        this.value = value;
        this.contents = contents;
    }
}
