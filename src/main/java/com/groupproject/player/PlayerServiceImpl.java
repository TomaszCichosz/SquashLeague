package com.groupproject.player;

import com.groupproject.game.Game;
import com.groupproject.match.Match;
import com.groupproject.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
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
        playerRepository.findOneByUuid(uuid).setDeleted(true);
    }

    @Override
    public Map<String, OpponentDto> getOpponentsDataAsMatchHost(Map<String, OpponentDto> opponentsData, Set<Match> matchesAsHost) {
        for (Match match : matchesAsHost) {
            OpponentDto opponentDto;
            if (!opponentsData.containsKey(match.getHost().getUser().getLogin())) {
                opponentDto = new OpponentDto(match.getHost().getUser().getLogin(), match.getHost().getEloRating());
            } else {
                opponentDto = opponentsData.get(match.getHost().getUser().getLogin());
            }
            int guestPoints = 0;
            int hostPoints = 0;
            for (Game game : match.getGames()) {
                if (game.getGuestResult() > game.getHostResult()) {
                    guestPoints++;
                } else {
                    hostPoints++;
                }
            }
            if (guestPoints > hostPoints) {
                opponentDto.addLostAgainst();
            } else {
                opponentDto.addWonAgainst();
            }
            opponentsData.put(opponentDto.getOpponentLogin(), opponentDto);
        }
        return opponentsData;
    }

    @Override
    public Map<String, OpponentDto> getOpponentsDataAsMatchGuest(Map<String, OpponentDto> opponentsData, Set<Match> matchesAsGuest) {
        for (Match match : matchesAsGuest) {
            OpponentDto opponentDto;
            if (!opponentsData.containsKey(match.getHost().getUser().getLogin())) {
                opponentDto = new OpponentDto(match.getHost().getUser().getLogin(), match.getHost().getEloRating());
            } else {
                opponentDto = opponentsData.get(match.getHost().getUser().getLogin());
            }
            int guestPoints = 0;
            int hostPoints = 0;
            for (Game game : match.getGames()) {
                if (game.getGuestResult() > game.getHostResult()) {
                    guestPoints++;
                } else {
                    hostPoints++;
                }
            }
            if (guestPoints > hostPoints) {
                opponentDto.addWonAgainst();
            } else {
                opponentDto.addLostAgainst();
            }
            opponentsData.put(opponentDto.getOpponentLogin(), opponentDto);
        }
        return opponentsData;
    }
}
