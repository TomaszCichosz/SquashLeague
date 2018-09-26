package com.groupproject.token;

import com.groupproject.commons.BaseEntity;
import com.groupproject.user.User;

import javax.persistence.*;

@Entity
public class Token extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    private boolean expired;
    @ManyToOne
    private User user;

    public Token() {
    }

    public Token(String token, boolean expired, User user) {
        this.token = token;
        this.expired = expired;
        this.user = user;
    }

    public Token(Long id,String token, boolean expired, User user) {
        this.id=id;
        this.token = token;
        this.expired = expired;
        this.user = user;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public Long getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public boolean isExpired() {
        return expired;
    }

    public User getUser() {
        return user;
    }


}
