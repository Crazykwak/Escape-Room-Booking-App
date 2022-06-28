package com.crazykwak.roombooking.member.service;

import com.crazykwak.roombooking.member.domain.Member;
import com.crazykwak.roombooking.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    @Autowired
    private final MemberRepository repository;

    public Member login(String userId, String password) {

        Optional<Member> findMember = repository.findByUserId(userId);

        if(findMember.isPresent()) {
            Member member = findMember.orElseThrow();
            if (member.getPassword().equals(password)) {
                return findMember.orElseThrow();
            }
        }
        return null;
    }
}
