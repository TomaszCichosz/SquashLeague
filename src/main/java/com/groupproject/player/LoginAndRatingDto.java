package com.groupproject.player;

public class LoginAndRatingDto implements Comparable<LoginAndRatingDto> {

    private String playerLogin;
    private int playerRating;

    public LoginAndRatingDto(String playerLogin, int playerRating) {
        this.playerLogin = playerLogin;
        this.playerRating = playerRating;
    }

    @Override
    public int compareTo(LoginAndRatingDto o) {
        if (getPlayerRating() > o.getPlayerRating()) {
            return -1;
        } else if (getPlayerRating() < o.getPlayerRating()) {
            return 1;
        } else {
            return 0;
        }
    }

    public String getPlayerLogin() {
        return playerLogin;
    }

    public int getPlayerRating() {
        return playerRating;
    }
}
