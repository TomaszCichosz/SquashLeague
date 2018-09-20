package com.groupproject.player;

class PlayerDto {

    private String uuid;
    private String userLogin;
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
        userLogin = player.getUser().getLogin();
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

    public String getUserLogin() {
        return userLogin;
    }
}
