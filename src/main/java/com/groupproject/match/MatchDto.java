package com.groupproject.match;

class MatchDto {

    private String hostLogin;
    private String guestLogin;

    public MatchDto() {
    }

    public MatchDto(Match match) {
        this.hostLogin = match.getHost().getLogin();
        this.guestLogin = match.getGuest().getLogin();
    }

    public String getHostLogin() {
        return hostLogin;
    }

    public String getGuestLogin() {
        return guestLogin;
    }
}
