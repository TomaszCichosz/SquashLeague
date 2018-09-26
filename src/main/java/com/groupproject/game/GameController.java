package com.groupproject.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/games")
class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    @ResponseBody
    public List<GameDto> findAllGames(){
        return gameService.findAll();
    }

    @PostMapping
    @ResponseBody
    public GameDto createGame(@RequestBody GameCreateDto createDto){
        return gameService.create(createDto);
    }
}
