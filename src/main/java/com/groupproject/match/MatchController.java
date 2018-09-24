package com.groupproject.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/matches")
class MatchController {

    private MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    @ResponseBody
    public List<MatchDto> findAllMatches() {
        return matchService.findAll();
    }

    @GetMapping("/add")
    public String addMatchForm(Model model) {
        MatchCreateDto dto = new MatchCreateDto();
        dto.setHostLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        System.out.println(dto);
        model.addAttribute("dto", dto);
        return "addmatchform";
    }

    @PostMapping
    public String create(@ModelAttribute("dto") MatchCreateDto dto, Model model) {
        if (!matchService.checkIfLoginExists(dto)) {
            dto.setGuestLogin("USER NOT FOUND");
            model.addAttribute("error", "Opponent not found");
            return "addmatchform";
        }
        if (!true){ //TODO
            model.addAttribute("error", "Wrong score");
            return "addmatchform";
        }
//        dto.setHostLogin(SecurityContextHolder.getContext().getAuthentication().getName()); // uncomment when logged in
        System.out.println("Added to database " + dto.toString());
        matchService.create(dto);
        model.addAttribute("added", "Match added to database");
        return "addmatchform";
    }

    //TODO GET MATCH by uuid
}
