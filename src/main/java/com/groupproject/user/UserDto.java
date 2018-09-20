package com.groupproject.user;

class UserDto {

    private String uuid;
    private String email;
    private String login;
    private String password;

    public UserDto() {
    }

    public UserDto(User user) {
        this.email = user.getEmail();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.uuid = user.getUuid();
    }

    public String getUuid() {
        return uuid;
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
}
