package com.groupproject.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
interface UserRepository extends CrudRepository<User, Long> {

    Set<User>findAllByDeletedFalse();

    Set<User> findAll();

    User findOneByUuid(String uuid);

    void deleteByUuid(String uuid);

    User findOneByLogin(String login);

    boolean existsByLogin(String login);
}
