package com.groupproject.game;

import java.util.List;

interface GameService {

        List<GameDto> findAll();

        GameDto findOneByUuid(String uuid);

        GameDto create(GameCreateDto userCreateDto);

        void delete(String uuid);


}
