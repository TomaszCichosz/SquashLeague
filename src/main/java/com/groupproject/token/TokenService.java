package com.groupproject.token;

public interface TokenService {
    String createToken(String login);

    void resetPassword(String token, String password);
}
