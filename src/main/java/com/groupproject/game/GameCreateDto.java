package com.groupproject.game;

public class GameCreateDto {

    private Match match;
    private int gameNumber;
    private int hostResult;
    private int guestResult;

    public GameCreateDto() {
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
