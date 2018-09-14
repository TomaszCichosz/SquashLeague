package com.groupproject.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/games")
class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameDto> findAllGames(){
        return gameService.findAll();
    }

    @PostMapping
    public GameDto createGame(@RequestBody GameCreateDto createDto){
        return gameService.create(createDto);
    }

    @DeleteMapping("/{uuid}")
    public void deleteGame(@PathVariable String uuid){
        gameService.delete(uuid);
    }



}
