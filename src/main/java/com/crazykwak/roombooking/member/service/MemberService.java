package com.crazykwak.roombooking.member.service;

import com.crazykwak.roombooking.member.domain.Member;
import com.crazykwak.roombooking.member.dto.LoginDTO;
import com.crazykwak.roombooking.member.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
