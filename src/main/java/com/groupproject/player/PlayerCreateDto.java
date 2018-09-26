package com.groupproject.player;

class PlayerCreateDto {

    private String userUuid;
    private int eloRating;
    private int gamesWon;
    private int gamesLost;

    public PlayerCreateDto() {
    }

    public PlayerCreateDto(String userUuid) {
        this.userUuid = userUuid;
        this.eloRating = 1000;
        this.gamesWon = 0;
        this.gamesLost = 0;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public PlayerCreateDto setUserUuid(String userUuid) {
        this.userUuid = userUuid;
        return this;
    }

    public int getEloRating() {
        return eloRating;
    }

    public PlayerCreateDto setEloRating(int eloRating) {
        this.eloRating = eloRating;
        return this;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public PlayerCreateDto setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
        return this;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public PlayerCreateDto setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
        return this;
    }
}
