package com.groupproject.match;

import com.groupproject.user.User;

class MatchCreateDto {

    private User host;
    private User guest;

    public MatchCreateDto() {
    }

    public MatchCreateDto(User host, User guest) {
        this.host = host;
        this.guest = guest;
    }

    public User getHost() {
        return host;
    }

    public User getGuest() {
        return guest;
    }
}
