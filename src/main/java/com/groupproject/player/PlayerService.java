package com.groupproject.player;

import com.groupproject.match.Match;

import java.util.List;
import java.util.Map;
import java.util.Set;

interface PlayerService {

    List<PlayerDto> findAll();

    PlayerDto findOneByUuid(String uuid);

    PlayerDto create(PlayerCreateDto playerCreateDto);

    void delete(String uuid);

    Map<String, OpponentDto> getOpponentsDataAsMatchHost(Map<String, OpponentDto> opponentsData, Set<Match> matchesAsHost);

    Map<String, OpponentDto> getOpponentsDataAsMatchGuest(Map<String, OpponentDto> opponentsData, Set<Match> matchesAsGuest);
}
