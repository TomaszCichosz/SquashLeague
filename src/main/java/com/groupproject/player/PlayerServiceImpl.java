package com.groupproject.player;

import com.groupproject.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;
    private UserFacade userFacade;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, UserFacade userFacade) {
        this.playerRepository = playerRepository;
        this.userFacade = userFacade;
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
        Player player = new Player(dto.getEloRating(), dto.getGamesWon(),
                dto.getGamesLost(), userFacade.getUserByUuid(dto.getUserUuid()));
        return new PlayerDto(playerRepository.save(player));
    }

    @Override
    public void delete(String uuid) {
        //TODO playerRepository.findOneByUuid(uuid).setDeleted(true);
    }
}
