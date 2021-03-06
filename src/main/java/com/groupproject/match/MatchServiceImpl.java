package com.groupproject.match;

import com.groupproject.elorating.EloRatingFacade;
import com.groupproject.game.Game;
import com.groupproject.player.Player;
import com.groupproject.player.PlayerFacade;
import com.groupproject.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
class MatchServiceImpl implements MatchService {

    private MatchRepository matchRepository;
    private MatchFacade matchFacade;
    private UserFacade userFacade;
    private EloRatingFacade eloRatingFacade;
    private PlayerFacade playerFacade;

    @Autowired
    public MatchServiceImpl(MatchRepository matchRepository, MatchFacade matchFacade, UserFacade userFacade, EloRatingFacade eloRatingFacade, PlayerFacade playerFacade) {
        this.matchRepository = matchRepository;
        this.matchFacade = matchFacade;
        this.userFacade = userFacade;
        this.eloRatingFacade = eloRatingFacade;
        this.playerFacade = playerFacade;
    }

    @Override
    public List<MatchDto> findAll() {
        return matchRepository.findAll().stream()
                .map(MatchDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public MatchDto findOneByUuid(String uuid) {
        return new MatchDto(matchRepository.findOneByUuid(uuid));
    }

    @Override
    public MatchDto create(MatchCreateDto dto) {
        Match match = new Match(userFacade.getUserByLogin(dto.getHostLogin()).getPlayer(),
                userFacade.getUserByLogin(dto.getGuestLogin()).getPlayer());
        matchRepository.save(match);

        int numberOfMatches = 5;
        for (int i = 0; i < dto.getHostResult().length; i++) {
            if (dto.getHostResult()[i] == 0 && dto.getGuestResult()[i] == 0) {
                numberOfMatches--;
            }
        }
        int[] hostResult = new int[numberOfMatches];
        int[] guestResult = new int[numberOfMatches];
        for (int i = 0; i < numberOfMatches; i++) {
            hostResult[i] = dto.getHostResult()[i];
            guestResult[i] = dto.getGuestResult()[i];
        }

        Set<Game> games = matchFacade.getGames(match.getUuid(), hostResult, guestResult);
        for (Game game : games) {
            match.addGame(game);
        }
        match = matchRepository.save(match);

        Player host = match.getHost();
        Player guest = match.getGuest();

        String matchScore = convertArrayOfResultsToScore(dto.getHostResult(), dto.getGuestResult());
        int[] ratings = eloRatingFacade.getNewRating(host, guest, matchScore);
        host.setEloRating(ratings[0]);
        guest.setEloRating(ratings[1]);

        if (matchScore.charAt(0) > matchScore.charAt(2)) {
            host.addOneToGamesWon();
            guest.addOneToGamesLost();
        } else {
            host.addOneToGamesLost();
            guest.addOneToGamesWon();
        }

        playerFacade.savePlayer(host);
        playerFacade.savePlayer(guest);

        return new MatchDto(match);
    }

    @Override
    public void delete(String uuid) {
        matchRepository.deleteByUuid(uuid);
    }

    @Override
    public boolean checkIfLoginExists(MatchCreateDto dto) {
        return userFacade.getUserByLogin(dto.getGuestLogin()) != null;
    }

    @Override
    public boolean addingGamesValidation(MatchCreateDto dto) {
        int[] hostResult = dto.getHostResult();
        int[] guestResult = dto.getGuestResult();

        if (hostResult.length != guestResult.length) {
            return false;
        }

        int numberOfGamesNotPlayed = 0;
        int hostWins = 0;
        int guestWins = 0;

        for (int i = 0; i < hostResult.length; i++) {
            if (hostResult[i] < 0 || guestResult[i] < 0) {
                return false;
            }
            if ((hostResult[i] < 11 && guestResult[i] < 11)) {
                if (hostResult[i] == 0 && guestResult[i] == 0) {
                    numberOfGamesNotPlayed++;
                } else {
                    return false;
                }
            }
            if (hostResult[i] == guestResult[i] && (hostResult[i] != 0 && guestResult[i] != 0)) {
                return false;
            }
            if ((hostResult[i] > 11 || guestResult[i] > 11) && Math.abs(hostResult[i] - guestResult[i]) != 2) {
                return false;
            }
            if (hostResult[i] > guestResult[i]) {
                hostWins++;
            } else {
                guestWins++;
            }
            if ((hostWins == 3 || guestWins == 3) && (hostResult[i] != 0 && guestResult[i] != 0)) {
                return false;
            }
        }

        if (numberOfGamesNotPlayed > 2) {
            return false;
        }

        return true;
    }

    private String convertArrayOfResultsToScore(int[] hostResults, int[] guestResults) {
        int hostScore = 0;
        int guestScore = 0;
        for (int i = 0; i < hostResults.length; i++) {
            if (hostResults[i] > guestResults[i]) {
                hostScore++;
            } else {
                guestScore++;
            }
        }
        return String.valueOf(hostScore).concat(":").concat(String.valueOf(guestScore));
    }
}
