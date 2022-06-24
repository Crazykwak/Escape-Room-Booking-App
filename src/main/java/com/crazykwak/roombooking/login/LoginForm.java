package com.crazykwak.roombooking.login;

import javax.validation.constraints.NotEmpty;

public class LoginForm {

    @NotEmpty
    private String loginId;
    @NotEmpty
    private String password;

    public String getLoginId() {
        return loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
