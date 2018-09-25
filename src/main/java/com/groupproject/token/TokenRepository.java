package com.groupproject.token;

import com.groupproject.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
interface TokenRepository extends CrudRepository<Token, Long> {

    Set<Token> findAllByUserIdAndExpiredFalse(long userId);

    Token findOneByToken(String token);

    Token findOneByUserLogin(String login);
}
