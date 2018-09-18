package com.groupproject.game;

class GameCreateDto {

    private String matchUuid;
    private int gameNumber;
    private int hostResult;
    private int guestResult;

    public GameCreateDto() {
    }

    public GameCreateDto(String matchUuid, int gameNumber, int hostResult, int guestResult) {
        this.matchUuid = matchUuid;
        this.gameNumber = gameNumber;
        this.hostResult = hostResult;
        this.guestResult = guestResult;
    }

    public String getMatchUuid() {
        return matchUuid;
    }

    public GameCreateDto setMatchUuid(String matchUuid) {
        this.matchUuid = matchUuid;
        return this;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public GameCreateDto setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
        return this;
    }

    public int getHostResult() {
        return hostResult;
    }

    public GameCreateDto setHostResult(int hostResult) {
        this.hostResult = hostResult;
        return this;
    }

    public int getGuestResult() {
        return guestResult;
    }

    public GameCreateDto setGuestResult(int guestResult) {
        this.guestResult = guestResult;
        return this;
    }
}
