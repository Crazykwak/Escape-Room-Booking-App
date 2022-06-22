package com.crazykwak.roombooking.user.repository;

import com.crazykwak.roombooking.user.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member user);
    void update(Long userId, MemberUpdateDto updateParam);
    void delete(Long userId);
    Optional<Member> findById(Long userId);
    List<Member> findAll();
    void clear();

}
