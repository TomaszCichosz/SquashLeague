package com.groupproject.user;

import com.groupproject.commons.BaseEntity;
import com.groupproject.player.Player;

import javax.persistence.*;

@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String login;
    private String password;
    private String email;

    @OneToOne(mappedBy = "user")
    private Player player;

    public User() {
    }

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User(Long id, String email, String login, String password) {
        this.id = id;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Player getPlayer() {
        return player;
    }
}