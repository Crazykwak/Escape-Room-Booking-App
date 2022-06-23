package com.crazykwak.roombooking.login;

import com.crazykwak.roombooking.member.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.crazykwak.roombooking.member.domain.MemberGrade.NOOB;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginServiceTest {

    @Autowired
    LoginService loginService;

    @Test
    void login() {
        Member userA = new Member("plok", "1234", "email@mail.com", "성남", "01033332222", NOOB);

    }

}