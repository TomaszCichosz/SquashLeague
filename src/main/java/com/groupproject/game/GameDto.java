package com.groupproject.game;

import com.groupproject.match.Match;

public class GameDto {

    private Match match;
    private int gameNumber;
    private int hostResult;
    private int guestResult;

    public GameDto() {
    }

    public GameDto(Game game) {
        this.match = game.getMatch();
        this.gameNumber = game.getGameNumber();
        this.hostResult = game.getHostResult();
        this.guestResult = game.getGuestResult();
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
