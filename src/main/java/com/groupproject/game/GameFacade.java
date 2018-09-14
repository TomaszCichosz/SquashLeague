package com.groupproject.game;

import com.groupproject.match.MatchFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameFacade {
    private MatchFacade matchFacade;

    @Autowired
    public GameFacade(MatchFacade matchFacade) {
        this.matchFacade = matchFacade;
    }

    public MatchFacade getMatchFacade() {
        return matchFacade;
    }
}
