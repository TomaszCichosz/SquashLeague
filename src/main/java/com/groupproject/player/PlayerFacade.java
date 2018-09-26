package com.groupproject.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerFacade {

    private PlayerService playerService;
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerFacade(PlayerService playerService, PlayerRepository playerRepository) {
        this.playerService = playerService;
        this.playerRepository = playerRepository;
    }

    public void createPlayer(String userUuid) {
        playerService.create(new PlayerCreateDto(userUuid));
    }

    public void savePlayer(Player player) {
        playerRepository.save(player);
    }
}
