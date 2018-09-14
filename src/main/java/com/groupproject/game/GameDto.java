package com.groupproject.game;

import com.groupproject.match.Match;

class GameDto {

    private String matchUuid;
    private int gameNumber;
    private int hostResult;
    private int guestResult;

    public GameDto() {
    }

    public GameDto(Game game) {
        this.matchUuid = game.getMatch().getUuid();
        this.gameNumber = game.getGameNumber();
        this.hostResult = game.getHostResult();
        this.guestResult = game.getGuestResult();
    }

    public String getMatchUuid() {
        return matchUuid;
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
