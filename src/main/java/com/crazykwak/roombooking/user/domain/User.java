package com.crazykwak.roombooking.user.domain;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class User {

    private Long id;
    private String userId;
    private String password;
    private String email;
    private String local;
    private String phoneNum;
    private UserGrade userGrade;

    public User() {
    }

    public User(Long id, String userId, String password, String email, String local, String phoneNum, UserGrade userGrade) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.local = local;
        this.phoneNum = phoneNum;
        this.userGrade = userGrade;
    }
}
