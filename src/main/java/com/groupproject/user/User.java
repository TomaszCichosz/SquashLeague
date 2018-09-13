package com.groupproject.user;

import com.groupproject.commons.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    @Column(unique = true, nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
    private Integer ranking;
    private Integer gamesWon;
    private Integer gamesLost;

    //TODO create associations
    //@OneToMany(mappedBy = "host")
    //private Set<Match> gamesAsHost;
    //@OneToMany(mappedBy = "guest")
    //private Set<Match> gamesAsGuest;


    public User() {
    }

    public User(String name, String surname, String email, String login, String password, Integer startingRanking) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.login = login;
        this.password = password;
        this.ranking = startingRanking;
        this.gamesWon = 0;
        this.gamesLost = 0;
    }

    public User(Long id, String name, String surname, String email, String login, String password, Integer ranking, Integer gamesWon, Integer gamesLost) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.login = login;
        this.password = password;
        this.ranking = ranking;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
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

    public Integer getRanking() {
        return ranking;
    }

    public Integer getGamesWon() {
        return gamesWon;
    }

    public Integer getGamesLost() {
        return gamesLost;
    }
}