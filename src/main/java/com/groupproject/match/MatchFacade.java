package com.groupproject.match;

import com.groupproject.game.Game;
import com.groupproject.game.GameFacade;
import com.groupproject.user.User;
import com.groupproject.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class MatchFacade {
    private UserFacade userFacade;
    private MatchRepository matchRepository;
    private GameFacade gameFacade;

    @Autowired
    public MatchFacade(UserFacade userFacade, MatchRepository matchRepository, @Lazy GameFacade gameFacade) {
        this.userFacade = userFacade;
        this.matchRepository = matchRepository;
        this.gameFacade = gameFacade;
    }

    public Match getMatchByUuid(String uuid) {
        return matchRepository.findOneByUuid(uuid);
    }

    public Set<Game> getGames(String matchUuid, int[] hostResult, int[] guestResult) {
        Set<Game> games = new HashSet<>();
        int gameNumber = 1;
        for (int i = 0; i < hostResult.length; i++) {
            games.add(gameFacade.getGame(matchUuid, gameNumber, hostResult[i], guestResult[i]));
            gameNumber++;
        }
        return games;
    }

    public User getUserByLogin(String login) {
        return userFacade.getUserByLogin(login);
    }

    public void saveUser(User user) {
        userFacade.saveUser(user);
    }
}
