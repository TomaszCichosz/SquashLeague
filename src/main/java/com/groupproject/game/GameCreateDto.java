package com.groupproject.game;

import com.groupproject.match.Match;

class GameCreateDto {

    private String matchUuid;
    private int gameNumber;
    private int hostResult;
    private int guestResult;

    public GameCreateDto() {
    }

    public String  getMatchUuid() {
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
