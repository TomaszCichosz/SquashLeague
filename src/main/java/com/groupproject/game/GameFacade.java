package com.groupproject.game;

import com.groupproject.match.MatchFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class GameFacade {
    private MatchFacade matchFacade;
    private GameService gameService;
    private GameRepository gameRepository;

    @Autowired
    public GameFacade(MatchFacade matchFacade, @Lazy GameService gameService, GameRepository gameRepository) {
        this.matchFacade = matchFacade;
        this.gameService = gameService;
        this.gameRepository = gameRepository;
    }

    public MatchFacade getMatchFacade() {
        return matchFacade;
    }

    public Game getGame(String matchUuid, int gameNumber, int hostResult, int guestResult) {
        GameDto gameDto = gameService.create(new GameCreateDto(matchUuid, gameNumber, hostResult, guestResult));
        return gameRepository.findOneByUuid(gameDto.getGameUuid());
    }
}
