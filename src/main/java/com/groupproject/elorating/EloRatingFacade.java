package com.groupproject.elorating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EloRatingFacade {

    private EloRatingService eloRatingService;

    @Autowired
    public EloRatingFacade(EloRatingService eloRatingService) {
        this.eloRatingService = eloRatingService;
    }
}
