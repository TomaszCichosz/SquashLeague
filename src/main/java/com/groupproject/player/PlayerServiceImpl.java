package com.groupproject.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<PlayerDto> findAll() {
        return playerRepository.findAll().stream().map(PlayerDto::new).collect(Collectors.toList());
    }

    @Override
    public PlayerDto findOneByUuid(String uuid) {
        return new PlayerDto(playerRepository.findOneByUuid(uuid));
    }

    @Override
    public PlayerDto create(PlayerCreateDto dto) {
        return null;
    }

    @Override
    public void delete(String uuid) {
        //TODO playerRepository.findOneByUuid(uuid).setDeleted(true);
    }
}
