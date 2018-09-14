package com.groupproject.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public List<MatchDto> findAllMatches(){
        return matchService.findAll();
    }

    @PostMapping
    public MatchDto create(@RequestBody MatchCreateDto dto){
       return matchService.create(dto);
    }

    @DeleteMapping
    public void deleteUser(@PathVariable String uuid){
        matchService.delete(uuid);
    }
}
