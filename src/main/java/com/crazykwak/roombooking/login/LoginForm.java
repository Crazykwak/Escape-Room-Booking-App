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
}
