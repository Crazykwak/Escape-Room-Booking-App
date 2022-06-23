package com.crazykwak.roombooking.login;

import com.crazykwak.roombooking.member.domain.Member;
import com.crazykwak.roombooking.member.repository.jpa.SpringDataJpaMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final SpringDataJpaMemberRepository repository;

    public Member login(String userId, String password) {

        Member findMember = repository.findByUserId(userId);

        if(findMember.getPassword() == password) {
            return findMember;
        } else {
            return null;
        }


    }
}
