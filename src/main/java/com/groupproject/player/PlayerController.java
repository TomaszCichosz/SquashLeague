package com.groupproject.player;

import com.groupproject.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/matches")
    public String getPlayersMatches(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLogin = authentication.getName();
        Player player = userFacade.getUserByLogin(userLogin).getPlayer();
        List<MatchInfoDto> matchesData = new ArrayList<>();

        matchesData = playerService.getMatchesDataAsHost(matchesData, player.getMatchesAsHost());
        matchesData = playerService.getMatchesDataAsGuest(matchesData, player.getMatchesAsGuest());

        model.addAttribute("matchesDataList", matchesData);
        return "matches";
    }

    @GetMapping("/opponents")
    public String getPlayersOpponents(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLogin = authentication.getName();
        Player player = userFacade.getUserByLogin(userLogin).getPlayer();
        Map<String, OpponentDto> opponentsData = new HashMap<>();

        opponentsData = playerService.getOpponentsDataAsMatchGuest(opponentsData, player.getMatchesAsGuest());
        opponentsData = playerService.getOpponentsDataAsMatchHost(opponentsData, player.getMatchesAsHost());

        model.addAttribute("opponentsDataMap", opponentsData);
        model.addAttribute("playerRating", player.getEloRating());
        return "opponents";
    }
}
