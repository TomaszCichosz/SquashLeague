package com.groupproject.match;

class MatchDto {

    private String hostLogin;
    private String guestLogin;

    public MatchDto() {
    }

    public MatchDto(Match match) {
        this.hostLogin = match.getHost().getUser().getLogin();
        this.guestLogin = match.getGuest().getUser().getLogin();
    }

    public String getHostLogin() {
        return hostLogin;
    }

    public String getGuestLogin() {
        return guestLogin;
    }
}
