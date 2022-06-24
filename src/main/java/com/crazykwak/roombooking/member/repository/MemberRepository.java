package com.crazykwak.roombooking.member.repository;

import com.crazykwak.roombooking.member.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member user);
    void update(Long userId, MemberUpdateDto updateParam);
    void delete(Long userId);
    Optional<Member> findById(Long userId);
    List<Member> findAll();
    void clear();
    Optional<Member> findByUserId(String userId);

}
