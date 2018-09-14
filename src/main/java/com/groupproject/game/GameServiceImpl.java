package com.groupproject.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
class GameServiceImpl implements GameService {

    private GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<GameDto> findAll() {
        return this.gameRepository.findAll().stream().map(GameDto::new).collect(Collectors.toList());
    }

    @Override
    public GameDto findOneByUuid(String uuid) {
        return new GameDto(gameRepository.findOneByUuid(uuid));
    }

    @Override
    public GameDto create(GameCreateDto dto) {
        Game game = new Game(dto.getMatch(), dto.getGameNumber(), dto.getHostResult(), dto.getGuestResult());
        return new GameDto(gameRepository.save(game));
    }

    @Override
    public void delete(String uuid) {
        gameRepository.deleteByUuid(uuid);
    }
}
