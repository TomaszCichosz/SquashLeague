package com.groupproject.player;

class MatchInfoDto {

    private String opponentLogin;
    private int yourScore;
    private int opponentScore;

    public MatchInfoDto(String opponentLogin, int yourScore, int opponentScore) {
        this.opponentLogin = opponentLogin;
        this.yourScore = yourScore;
        this.opponentScore = opponentScore;
    }

    public String getOpponentLogin() {
        return opponentLogin;
    }

    public int getYourScore() {
        return yourScore;
    }

    public int getOpponentScore() {
        return opponentScore;
    }
}
