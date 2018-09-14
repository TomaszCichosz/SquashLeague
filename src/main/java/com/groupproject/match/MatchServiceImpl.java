package com.groupproject.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
class MatchServiceImpl implements MatchService{

    private MatchRepository matchRepository;
    private MatchFacade matchFacade;

    @Autowired
    public MatchServiceImpl(MatchRepository matchRepository, MatchFacade matchFacade) {
        this.matchRepository = matchRepository;
        this.matchFacade = matchFacade;
    }

    @Override
    public List<MatchDto> findAll(){
        return matchRepository.findAll().stream()
                .map(MatchDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public MatchDto findOneByUuid(String uuid){
        return new MatchDto(matchRepository.findOneByUuid(uuid));
    }

    @Override
    public MatchDto create(MatchCreateDto dto){
        Match match=new Match(matchFacade.getUserFacade().getUserByUuid(dto.getHostUuid()),
                matchFacade.getUserFacade().getUserByUuid(dto.getGuestUuid()));
        return new MatchDto(matchRepository.save(match));
    }

    @Override
    public void delete(String uuid){
        matchRepository.deleteByUuid(uuid);
    }
}
