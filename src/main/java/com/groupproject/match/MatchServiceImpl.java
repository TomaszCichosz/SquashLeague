package com.groupproject.match;

import com.groupproject.elorating.EloRatingFacade;
import com.groupproject.game.Game;
import com.groupproject.player.Player;
import com.groupproject.player.PlayerFacade;
import com.groupproject.user.User;
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
    public MatchServiceImpl(MatchRepository matchRepository, MatchFacade matchFacade, UserFacade userFacade, EloRatingFacade eloRatingFacade) {
        this.matchRepository = matchRepository;
        this.matchFacade = matchFacade;
        this.userFacade = userFacade;
        this.eloRatingFacade = eloRatingFacade;
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

        Set<Game> games = matchFacade.getGames(match.getUuid(), dto.getHostResult(), dto.getGuestResult());
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
