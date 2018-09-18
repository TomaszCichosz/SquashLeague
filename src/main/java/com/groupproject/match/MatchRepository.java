package com.groupproject.match;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
interface MatchRepository extends CrudRepository<Match, Long> {

    Set<Match> findAll();

    Match findOneByUuid(String uuid);

    void deleteByUuid(String uuid);
}
