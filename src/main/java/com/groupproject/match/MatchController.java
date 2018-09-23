package com.groupproject.match;

import org.springframework.beans.factory.annotation.Autowired;
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
        //TODO get id hosta and add to dto
        model.addAttribute("dto", dto);
        return "addmatchTest";
    }

    @PostMapping
    public String create(@ModelAttribute("dto") MatchCreateDto dto) {
        if (!matchService.checkIfLoginExists(dto)) {
            return "error";
        }
        matchService.create(dto);
        return "addmatchTest";
    }

    //TODO GET MATCH by uuid
}
