package com.groupproject.token;

class ResetPasswordDto {

    private String token;
    private String password;
    private String repeatPassword;

    public ResetPasswordDto() {
    }

    public ResetPasswordDto(String token, String password, String repeatPassword) {
        this.token = token;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    public String getToken() {
        return token;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }
}
