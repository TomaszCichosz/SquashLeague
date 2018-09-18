package com.groupproject.match;

class MatchCreateDto {

    private String hostLogin;
    private String guestLogin;
    private int[] hostResult;
    private int[] guestResult;

    public MatchCreateDto() {
    }

    public MatchCreateDto(String hostLogin, String guestLogin, int[] hostResult, int[] guestResult) {
        this.hostLogin = hostLogin;
        this.guestLogin = guestLogin;
        this.hostResult = hostResult;
        this.guestResult = guestResult;
    }

    public String getHostLogin() {
        return hostLogin;
    }

    public MatchCreateDto setHostLogin(String hostLogin) {
        this.hostLogin = hostLogin;
        return this;
    }

    public String getGuestLogin() {
        return guestLogin;
    }

    public MatchCreateDto setGuestLogin(String guestLogin) {
        this.guestLogin = guestLogin;
        return this;
    }

    public int[] getHostResult() {
        return hostResult;
    }

    public MatchCreateDto setHostResult(int[] hostResult) {
        this.hostResult = hostResult;
        return this;
    }

    public int[] getGuestResult() {
        return guestResult;
    }

    public MatchCreateDto setGuestResult(int[] guestResult) {
        this.guestResult = guestResult;
        return this;
    }
}
