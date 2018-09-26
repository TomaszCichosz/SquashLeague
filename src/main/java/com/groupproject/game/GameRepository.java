package com.groupproject.game;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface GameRepository extends CrudRepository<Game, Long> {

    List<Game> findAll();

    Game findOneByUuid(String uuid);

    void deleteByUuid(String uuid);
}
