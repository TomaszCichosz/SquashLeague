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
}
