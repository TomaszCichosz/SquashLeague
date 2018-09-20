package com.groupproject.player;

public class LoginAndRatingDto {

    private String playerLogin;
    private int playerRating;

    public LoginAndRatingDto(String playerLogin, int playerRating) {
        this.playerLogin = playerLogin;
        this.playerRating = playerRating;
    }

    public String getPlayerLogin() {
        return playerLogin;
    }

    public int getPlayerRating() {
        return playerRating;
    }
}
