package com.crazykwak.roombooking.member.repository.jpa;

import com.crazykwak.roombooking.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    public Member findByUserId(String userId);
}
