package com.crazykwak.roombooking.member.service;

import com.crazykwak.roombooking.member.domain.Member;
import com.crazykwak.roombooking.member.domain.MemberGrade;
import com.crazykwak.roombooking.member.dto.LoginDTO;
import com.crazykwak.roombooking.member.dto.MemberForm;
import com.crazykwak.roombooking.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Member login(LoginDTO dto) {
        Optional<Member> loginResult = repository.login(dto);
        if (loginResult.isEmpty()) {
            return null;
        }

        return loginResult.get();
    }

    public Member join(Member member) {
        String pwd = member.getPassword();
        member.setMemberGrade(MemberGrade.ROLE_NOOB);
        String encode = bCryptPasswordEncoder.encode(pwd);
        member.setPassword(encode);
        return repository.save(member);
    }
}
