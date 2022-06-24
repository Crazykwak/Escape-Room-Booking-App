package com.crazykwak.roombooking.member.repository.jpa;

import com.crazykwak.roombooking.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUserId(String userId);
}
