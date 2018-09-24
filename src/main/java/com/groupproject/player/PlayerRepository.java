package com.groupproject.player;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
interface PlayerRepository extends CrudRepository<Player, Long> {

    Set<Player> findAll();

    Player findOneByUuid(String uuid);

    void deleteByUuid(String uuid);
}
