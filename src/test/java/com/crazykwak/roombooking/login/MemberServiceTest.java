package com.crazykwak.roombooking.login;

import com.crazykwak.roombooking.member.domain.Member;
import com.crazykwak.roombooking.member.dto.LoginDTO;
import com.crazykwak.roombooking.member.repository.MemberRepository;
import com.crazykwak.roombooking.member.service.MemberService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static com.crazykwak.roombooking.member.domain.MemberGrade.NOOB;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    public void before() {
        Member user = new Member("plok", "1234", "email@mail.com", "성남", "01033332222", NOOB);
        LoginDTO loginDto = new LoginDTO(user.getUserId(), user.getPassword());
        user.setPassword(loginDto.getEncPwd());
        memberRepository.save(user);
    }

    @Test
    public void login() {
        LoginDTO dto = new LoginDTO("plok", "1234");
        Member loginMem = memberService.login(dto);
        System.out.println("loginMem = "+loginMem.getId()+" | "+loginMem.getPassword());
    }

}