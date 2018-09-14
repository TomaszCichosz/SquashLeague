package com.groupproject.game;

import com.groupproject.commons.BaseEntity;
import com.groupproject.match.Match;

import javax.persistence.*;

@Entity
public class Game extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Match match;
    private int gameNumber;
    private int hostResult;
    private int guestResult;


    public Game() {
    }

    public Game(Match match, int gameNumber, int hostResult, int guestResult) {
        this.match = match;
        this.gameNumber = gameNumber;
        this.hostResult = hostResult;
        this.guestResult = guestResult;
    }

    public Game(Long id, Match match, int gameNumber, int hostResult, int guestResult) {
        this.id = id;
        this.match = match;
        this.gameNumber = gameNumber;
        this.hostResult = hostResult;
        this.guestResult = guestResult;
    }

    public Long getId() {
        return id;
    }

    public Match getMatch() {
        return match;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public int getHostResult() {
        return hostResult;
    }

    public int getGuestResult() {
        return guestResult;
    }
}
