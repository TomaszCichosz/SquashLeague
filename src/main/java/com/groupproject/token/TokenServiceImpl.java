package com.groupproject.token;

import com.groupproject.user.User;
import com.groupproject.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
@Transactional
class TokenServiceImpl implements TokenService {

    private TokenRepository tokenRepository;
    private UserFacade userFacade;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public TokenServiceImpl(TokenRepository tokenRepository, UserFacade userFacade, PasswordEncoder passwordEncoder) {
        this.tokenRepository = tokenRepository;
        this.userFacade = userFacade;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String createToken(String login) {
        User user = userFacade.getUserByLogin(login);
        if (user != null) {
            Token token = new Token(UUID.randomUUID().toString(), false, user);
            token = tokenRepository.save(token);
            return token.getToken();
        }
        return UUID.randomUUID().toString();
    }

    @Override
    public void resetPassword(String token, String password) {
        Token token1 = tokenRepository.findOneByToken(token);
        if (token1 == null) {
            return;
        }
        token1.getUser().setPassword(passwordEncoder.encode(password));
        token1.setExpired(true);
        tokenRepository.save(token1);
        Set<Token> tokens = tokenRepository.findAllByUserIdAndExpiredFalse(token1.getUser().getId());
        tokens.forEach(t -> t.setExpired(true));
        tokenRepository.save(tokens);
    }


}
