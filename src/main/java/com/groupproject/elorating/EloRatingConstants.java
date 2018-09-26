package com.groupproject.elorating;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

class EloRatingConstants {

    static final int K_FACTOR_FOR_AMATEUR_PLAYER = 32;
    static final int K_FACTOR_FOR_SEMI_PROFESSIONAL_PLAYER = 24;
    static final int K_FACTOR_FOR_PROFESSIONAL_PLAYER = 16;

    static final Map<Integer, BigDecimal> EXPECTED_SCORE_TABLE;
    static final int[] RATING_DIFFERENCE_TABLE = {-800, -677, -589, -538, -501, -470, -444, -422, -401, -383, -366, -351, -336, -322, -309, -296,
            -284, -273, -262, -251, -240, -230, -220, -211, -202, -193, -184, -175, -166, -158, -149, -141, -133, -125, -117, -110, -102,
            -95, -87, -80, -72, -65, -57, -50, -43, -36, -29, -21, -14, -7, 0, 7, 14, 21, 29, 36, 43, 50, 57, 65, 72, 80, 87, 95, 102, 110, 117,
            125, 133, 141, 149, 158, 166, 175, 184, 193, 202, 211, 220, 230, 240, 251, 262, 273, 284, 296, 309, 322, 336, 351, 366, 383, 401,
            422, 444, 470, 501, 538, 589, 677, 800};

    static {
        Map<Integer, BigDecimal> tempMap = new HashMap<>();
        int index = 0;
        BigDecimal i = BigDecimal.ZERO;

        while (i.compareTo(BigDecimal.ONE) < 1) {
            tempMap.put(RATING_DIFFERENCE_TABLE[index], i);
            i = i.add(new BigDecimal("0.01"));
            index++;
        }

        EXPECTED_SCORE_TABLE = tempMap;
    }
}
