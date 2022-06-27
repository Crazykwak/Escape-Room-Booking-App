package com.crazykwak.roombooking.member.dto;

import com.crazykwak.roombooking.member.domain.MemberGrade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberUpdateDto {

    private String password;
    private String email;
    private String local;
    private String phoneNum;

    public MemberUpdateDto() {
    }

    public MemberUpdateDto(String password, String email, String local, String phoneNum, MemberGrade memberGrade) {
        this.password = password;
        this.email = email;
        this.local = local;
        this.phoneNum = phoneNum;
    }
}
