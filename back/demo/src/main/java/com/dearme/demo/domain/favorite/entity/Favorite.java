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
public class Favorite extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorite_id")
    private Long id;

    @ManyToOne
    @JsonManagedReference // 순환참조 방지
    @JoinColumn(name="id")
    private User user;

    @OneToOne
    private User counselor;

    public void setUser(User user){
        user.getFavorites().add(this);
        this.user=user;
    }
    public void setCounselor(User user){
        this.counselor=user;
    }
}
