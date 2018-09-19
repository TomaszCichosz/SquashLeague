package com.groupproject.elorating;

import com.groupproject.player.Player;
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


    public int[] getNewRating(Player host, Player guest, String matchScore) {
        StringBuilder sb = new StringBuilder();

        return new int[]{eloRatingService.getNewRating(host.getEloRating(), guest.getEloRating(), matchScore),
                eloRatingService.getNewRating(guest.getEloRating(), host.getEloRating(),
                        sb.append(matchScore).reverse().toString())};
    }
}
