package com.crazykwak.roombooking.member.service;

import com.crazykwak.roombooking.member.domain.Member;
import com.crazykwak.roombooking.member.domain.MemberGrade;
import com.crazykwak.roombooking.member.dto.LoginDTO;
import com.crazykwak.roombooking.member.dto.MemberForm;
import com.crazykwak.roombooking.member.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
@Slf4j
public class MemberService {

    @Autowired
    private MemberRepository repository;

    public Member login(LoginDTO dto) {
        Optional<Member> loginResult = repository.login(dto);
        if (loginResult.isEmpty()) {
            return null;
        }

        return loginResult.get();
    }

    public Member join(Member member) {
        String pwd = member.getPassword();
        member.setMemberGrade(MemberGrade.NOOB);

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(pwd.getBytes());
            byte[] bt = md.digest();
            StringBuilder endPwd = new StringBuilder();
            for (byte b : bt) {
                endPwd.append(String.format("%02x", b));
            }
            member.setPassword(endPwd.toString());
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage());
        }

        return repository.save(member);
    }
}
