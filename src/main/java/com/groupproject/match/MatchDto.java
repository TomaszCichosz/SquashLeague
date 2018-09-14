package com.groupproject.match;

import com.groupproject.user.User;

class MatchDto {

    private String hostUuid;
    private String guestUuid;

    public MatchDto() {
    }

    public MatchDto(Match match) {
        this.hostUuid = match.getHost().getUuid();
        this.guestUuid = match.getGuest().getUuid();
    }

    public String getHostUuid() {
        return hostUuid;
    }

    public String getGuestUuid() {
        return guestUuid;
    }
}
