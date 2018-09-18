package com.groupproject.elorating;

import com.groupproject.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EloRatingFacade {

    private EloRatingService eloRatingService;

    @Autowired
    public EloRatingFacade(EloRatingService eloRatingService) {
        this.eloRatingService = eloRatingService;
    }


    public int[] getNewRating(User host, User guest, String matchScore) {
        StringBuilder sb = new StringBuilder();

        return new int[]{eloRatingService.getNewRating(host.getRanking(), guest.getRanking(), matchScore),
                eloRatingService.getNewRating(guest.getRanking(), host.getRanking(),
                        sb.append(matchScore).reverse().toString())};
    }
}
