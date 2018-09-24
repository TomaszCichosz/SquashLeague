package com.groupproject.player;

import com.groupproject.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.*;

@Controller
@RequestMapping("/players")
class PlayerController {

    private PlayerService playerService;
    private UserFacade userFacade;

    @Autowired
    public PlayerController(PlayerService playerService, UserFacade userFacade) {
        this.playerService = playerService;
        this.userFacade = userFacade;
    }

    @GetMapping
    public List<PlayerDto> findAllPlayers() {
        return playerService.findAll();
    }

    @GetMapping("/ranking")
    public String getRankingView(Model model) {
        List<LoginAndRatingDto> loginsAndRatings = new ArrayList<>();
        for (PlayerDto playerDto : playerService.findAll()) {
            loginsAndRatings.add(new LoginAndRatingDto(
                    playerDto.getUserLogin(), playerDto.getEloRating()));
        }
        Collections.sort(loginsAndRatings);
        model.addAttribute("loginsAndRatings", loginsAndRatings);
        return "ranking";
    }

    @GetMapping("/opponents")
    public String getPlayersOpponents(Model model, Principal principal) {
        String userLogin = principal.getName();
        Player player = userFacade.getUserByLogin(userLogin).getPlayer();
        Map<String, OpponentDto> opponentsData = new HashMap<>();

        opponentsData = playerService.getOpponentsDataAsMatchGuest(opponentsData, player.getMatchesAsGuest());
        opponentsData = playerService.getOpponentsDataAsMatchHost(opponentsData, player.getMatchesAsHost());

        model.addAttribute("opponentsDataMap", opponentsData);
        model.addAttribute("playerRating", player.getEloRating());
        return "opponents";
    }
}
