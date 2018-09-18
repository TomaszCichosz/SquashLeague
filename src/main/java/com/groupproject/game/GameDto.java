package com.groupproject.game;

class GameDto {

    private String matchUuid;
    private String gameUuid;
    private int gameNumber;
    private int hostResult;
    private int guestResult;

    public GameDto() {
    }

    public GameDto(Game game) {
        this.matchUuid = game.getMatch().getUuid();
        this.gameUuid = game.getUuid();
        this.gameNumber = game.getGameNumber();
        this.hostResult = game.getHostResult();
        this.guestResult = game.getGuestResult();
    }

    public String getMatchUuid() {
        return matchUuid;
    }

    public String getGameUuid() {
        return gameUuid;
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
