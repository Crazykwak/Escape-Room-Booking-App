package com.crazykwak.roombooking.member.repository;

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
    private MemberGrade memberGrade;

    public MemberUpdateDto() {
    }

    public MemberUpdateDto(String password, String email, String local, String phoneNum, MemberGrade memberGrade) {
        this.password = password;
        this.email = email;
        this.local = local;
        this.phoneNum = phoneNum;
        this.memberGrade = memberGrade;
    }
}
