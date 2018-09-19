package com.groupproject.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerFacade {

    private PlayerService playerService;

    @Autowired
    public PlayerFacade(PlayerService playerService) {
        this.playerService = playerService;
    }

    public void createPlayer(String userUuid) {
        playerService.create(new PlayerCreateDto(userUuid));
    }
}
