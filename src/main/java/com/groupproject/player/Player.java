package com.groupproject.player;

import com.groupproject.commons.BaseEntity;
import com.groupproject.match.Match;
import com.groupproject.user.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Player extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    private int eloRating;
    private int gamesWon;
    private int gamesLost;

    @OneToOne(mappedBy = "player")
    private User user;
    @OneToMany(mappedBy = "host", cascade = CascadeType.REMOVE)
    private Set<Match> gamesAsHost = new HashSet<>();
    @OneToMany(mappedBy = "guest", cascade = CascadeType.REMOVE)
    private Set<Match> gamesAsGuest = new HashSet<>();

    public Player() {
    }

    public Player(int eloRating, int gamesWon, int gamesLost) {
        this.eloRating = eloRating;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
    }

    public Player(Long id, int eloRating, int gamesWon, int gamesLost) {
        this.eloRating = eloRating;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
    }

    public Long getId() {
        return id;
    }

    public int getEloRating() {
        return eloRating;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public User getUser() {
        return user;
    }

    public Set<Match> getGamesAsHost() {
        return gamesAsHost;
    }

    public Set<Match> getGamesAsGuest() {
        return gamesAsGuest;
    }

    public void addOneToGamesWon() {
        gamesWon++;
    }

    public void addOneToGamesLost() {
        gamesLost++;
    }

    public void addGameAsHost(Match match) {
        gamesAsHost.add(match);
    }

    public void addGameAsGuest(Match match) {
        gamesAsGuest.add(match);
    }

    public Player setEloRating(int eloRating) {
        this.eloRating = eloRating;
        return this;
    }
}
