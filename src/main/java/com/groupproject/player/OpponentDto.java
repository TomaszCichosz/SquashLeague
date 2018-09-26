package com.groupproject.player;

class OpponentDto {

    private String opponentLogin;
    private int opponentRating;
    private int lostAgainst;
    private int wonAgainst;

    public OpponentDto(String opponentLogin, int opponentRating) {
        this.opponentLogin = opponentLogin;
        this.opponentRating = opponentRating;
        this.lostAgainst = 0;
        this.wonAgainst = 0;
    }

    public String getOpponentLogin() {
        return opponentLogin;
    }

    public int getOpponentRating() {
        return opponentRating;
    }

    public int getLostAgainst() {
        return lostAgainst;
    }

    public int getWonAgainst() {
        return wonAgainst;
    }

    public void addLostAgainst() {
        lostAgainst++;
    }

    public void addWonAgainst() {
        wonAgainst++;
    }
}
