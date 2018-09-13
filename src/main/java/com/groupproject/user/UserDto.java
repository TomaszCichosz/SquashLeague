package com.groupproject.user;

class UserDto {

    private String name;
    private String surname;
    private String email;
    private String login;
    private String password;
    private Integer ranking;
    private Integer gamesWon;
    private Integer gamesLost;

    public UserDto() {
    }

    public UserDto(User user) {
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.ranking = user.getRanking();
        this.gamesWon = user.getGamesWon();
        this.gamesLost = user.getGamesLost();
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

    public Integer getRanking() {
        return ranking;
    }

    public Integer getGamesWon() {
        return gamesWon;
    }

    public Integer getGamesLost() {
        return gamesLost;
    }
}
