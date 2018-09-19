package com.groupproject.user;

class UserCreateDto {

    private String email;
    private String login;
    private String password;

    public UserCreateDto() {
    }

    public String getEmail() {
        return email;
    }

    public UserCreateDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public UserCreateDto setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserCreateDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
