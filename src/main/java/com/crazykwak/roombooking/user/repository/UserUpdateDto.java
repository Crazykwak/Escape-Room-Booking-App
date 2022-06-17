package com.crazykwak.roombooking.user.repository;

import com.crazykwak.roombooking.user.domain.UserGrade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {

    private String password;
    private String email;
    private String local;
    private String phoneNum;
    private UserGrade userGrade;

    public UserUpdateDto() {
    }

    public UserUpdateDto(String password, String email, String local, String phoneNum, UserGrade userGrade) {
        this.password = password;
        this.email = email;
        this.local = local;
        this.phoneNum = phoneNum;
        this.userGrade = userGrade;
    }
}
