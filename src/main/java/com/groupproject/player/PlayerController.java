package com.groupproject.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<PlayerDto> findAllPlayers() {
        return playerService.findAll();
    }

    @GetMapping("/players/ranking")
    public String getRankingView(Model model) {
        List<LoginAndRatingDto> loginsAndRatings = new ArrayList<>();
        for (PlayerDto playerDto : playerService.findAll()) {
            loginsAndRatings.add(new LoginAndRatingDto(
                    playerDto.getUserLogin(), playerDto.getEloRating()));
        }
        model.addAttribute("loginsAndRatings", loginsAndRatings);
        return "ranking";
    }
}
