package com.groupproject.match;

import java.util.List;

interface MatchService {
    List<MatchDto> findAll();

    MatchDto findOneByUuid(String uuid);

    MatchDto create(MatchCreateDto dto);

    void delete(String uuid);
}
