package com.groupproject.player;

import java.util.List;

interface PlayerService {

    List<PlayerDto> findAll();

    PlayerDto findOneByUuid(String uuid);

    PlayerDto create(PlayerCreateDto playerCreateDto);

    void delete(String uuid);
}
