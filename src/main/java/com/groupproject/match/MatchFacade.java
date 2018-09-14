package com.groupproject.match;

import com.groupproject.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MatchFacade {
    private UserFacade userFacade;
    private MatchRepository matchRepository;

    @Autowired
    public MatchFacade(UserFacade userFacade, MatchRepository matchRepository) {
        this.userFacade = userFacade;
        this.matchRepository = matchRepository;
    }

    public UserFacade getUserFacade() {
        return userFacade;
    }

    public Match getMatchByUuid(String uuid){
        return matchRepository.findOneByUuid(uuid);
    }
}
