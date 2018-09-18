package com.groupproject.elorating;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
class EloRatingService {

    EloRatingService() {
    }

    int getNewRating(int playerRating, int opponentRating, String matchResult) {
        BigDecimal kFactor = new BigDecimal(getKFactor(playerRating));
        Integer ratingDifference = getRatingDifference(playerRating, opponentRating);
        BigDecimal expectedScore = EloRatingConstants.EXPECTED_SCORE_TABLE.get(ratingDifference);
        return playerRating + kFactor
                .multiply(convertMatchResultToScore(matchResult)
                .subtract(expectedScore))
                .setScale(0, BigDecimal.ROUND_HALF_UP)
                .intValueExact();
    }

    private int getKFactor(int playerRating) {
        int KFactor;
        if (playerRating < 2100) {
            KFactor = EloRatingConstants.K_FACTOR_FOR_AMATEUR_PLAYER;
        } else if (playerRating < 2400) {
            KFactor = EloRatingConstants.K_FACTOR_FOR_SEMI_PROFESSIONAL_PLAYER;
        } else {
            KFactor = EloRatingConstants.K_FACTOR_FOR_PROFESSIONAL_PLAYER;
        }
        return KFactor;
    }

    private int getRatingDifference(int playerRating, int opponentRating) {
        int ratingDifference = playerRating - opponentRating;
        int endIndex = EloRatingConstants.RATING_DIFFERENCE_TABLE.length;
        for (int i = 0; i < endIndex; i++) {
            if (EloRatingConstants.RATING_DIFFERENCE_TABLE[i] >= ratingDifference) {
                if (ratingDifference > 0 || ratingDifference == EloRatingConstants.RATING_DIFFERENCE_TABLE[i]) {
                    ratingDifference = EloRatingConstants.RATING_DIFFERENCE_TABLE[i];
                } else {
                    if (ratingDifference < -800) {
                        ratingDifference = -800;
                    } else {
                        ratingDifference = EloRatingConstants.RATING_DIFFERENCE_TABLE[i - 1];
                    }
                }
            }
        }
        return ratingDifference;
    }

    private BigDecimal convertMatchResultToScore(String matchResult) {
        switch (matchResult) {
            case "3:0":
                return BigDecimal.ONE;
            case "3:1":
                return new BigDecimal("0.8");
            case "3:2":
                return new BigDecimal("0.6");
            case "2:3":
                return new BigDecimal("0.4");
            case "1:3":
                return new BigDecimal("0.2");
            case "0:3":
                return BigDecimal.ZERO;
        }
        throw new RuntimeException();
    }
}
