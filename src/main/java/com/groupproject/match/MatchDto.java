package com.groupproject.match;

import com.groupproject.user.User;

public class MatchDto {

    private User host;
    private User guest;
    //TODO
    //private List<String>gameResults;

    public MatchDto() {
    }

    public MatchDto(Match match) {
        this.host = match.getHost();
        this.guest = match.getGuest();
//        this.gameResults=match.getGames()
//                .stream()
//                .map(Game::getResult)
//                .collect(Collectors.toList());
    }

    public User getHost() {
        return host;
    }

    public User getGuest() {
        return guest;
    }
}
