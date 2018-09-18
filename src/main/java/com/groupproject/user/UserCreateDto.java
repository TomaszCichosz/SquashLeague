package com.groupproject.user;

class UserCreateDto {

    private String name;
    private String surname;
    private String email;
    private String login;
    private String password;
    private Integer startingRanking;

    public UserCreateDto() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Integer getStartingRanking() {
        return startingRanking;
    }

    public UserCreateDto setName(String name) {
        this.name = name;
        return this;
    }

    public UserCreateDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public UserCreateDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserCreateDto setLogin(String login) {
        this.login = login;
        return this;
    }

    public UserCreateDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserCreateDto setStartingRanking(Integer startingRanking) {
        this.startingRanking = startingRanking;
        return this;
    }
}
