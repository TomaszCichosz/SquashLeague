package com.groupproject.match;

import com.groupproject.user.User;

public class MatchDto {

    private User host;
    private User guest;

    public MatchDto() {
    }

    public MatchDto(Match match) {
        this.host = match.getHost();
        this.guest = match.getGuest();
    }

    public User getHost() {
        return host;
    }

    public User getGuest() {
        return guest;
    }
}
