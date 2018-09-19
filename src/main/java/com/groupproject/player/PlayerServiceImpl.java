package com.groupproject.player;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    @Override
    public List<PlayerDto> findAll() {
        return null;
    }

    @Override
    public PlayerDto findOneByUuid(String uuid) {
        return null;
    }

    @Override
    public PlayerDto create(PlayerCreateDto playerCreateDto) {
        return null;
    }

    @Override
    public void delete(String uuid) {

    }
}
