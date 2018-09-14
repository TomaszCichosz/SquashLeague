package com.groupproject.match;

import com.groupproject.user.User;

class MatchCreateDto {

    private String hostUuid;
    private String guestUuid;

    public MatchCreateDto() {
    }

    public MatchCreateDto(String hostUuid, String guestUuid) {
        this.hostUuid = hostUuid;
        this.guestUuid = guestUuid;
    }

    public String getHostUuid() {
        return hostUuid;
    }

    public String getGuestUuid() {
        return guestUuid;
    }
}
