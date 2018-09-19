package com.groupproject.player;

class PlayerDto {

    private String uuid;
    private int eloRating;
    private int gamesWon;
    private int gamesLost;

    public PlayerDto() {
    }

    public PlayerDto(Player player) {
        uuid = player.getUuid();
        eloRating = player.getEloRating();
        gamesWon = player.getGamesWon();
        gamesLost = player.getGamesLost();
    }

    public String getUuid() {
        return uuid;
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
}
