package com.groupproject.token;

interface TokenService {
    String createToken(String login);

    void resetPassword(String token, String password);
}
