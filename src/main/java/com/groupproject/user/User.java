package com.groupproject.user;

import com.groupproject.commons.BaseEntity;
import com.groupproject.match.Match;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    @Column(unique = true)
    private String login;
    private String password;
    private Integer ranking;
    private Integer gamesWon;
    private Integer gamesLost;

    @OneToMany(mappedBy = "host")
    private Set<Match> gamesAsHost = new HashSet<>();
    @OneToMany(mappedBy = "guest")
    private Set<Match> gamesAsGuest = new HashSet<>();


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

    public Set<Match> getGamesAsHost() {
        return gamesAsHost;
    }

    public Set<Match> getGamesAsGuest() {
        return gamesAsGuest;
    }
}