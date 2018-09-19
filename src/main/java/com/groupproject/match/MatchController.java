package com.groupproject.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/matches")
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

    @DeleteMapping("/{uuid}")
    @ResponseBody
    public void deleteUser(@PathVariable String uuid) {
        matchService.delete(uuid);
    }

//    @PostMapping
//    public String create(@ModelAttribute MatchCreateDto dto) {
//        if (!matchService.checkIfLoginExists(dto)) {
//            return "error";
//        }
//        matchService.create(dto);
//        return "add-game";
//    }

    @PostMapping
    @ResponseBody
    public MatchDto create(@RequestBody MatchCreateDto dto) {
        return matchService.create(dto);
    }

}
