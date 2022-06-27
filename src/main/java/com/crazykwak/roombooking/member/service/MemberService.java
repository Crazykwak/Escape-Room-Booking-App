package com.crazykwak.roombooking.member.service;

import com.crazykwak.roombooking.member.domain.Member;
import com.crazykwak.roombooking.member.dto.MemberUpdateDto;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    Member save(Member user);
    void update(Long userId, MemberUpdateDto updateParam);
    void delete(Long userId);
    Optional<Member> findById(Long id);
    List<Member> findUsers();
    Optional<Member> findByUserId(String userId);
}
