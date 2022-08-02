package com.crazykwak.roombooking.member.repository;

import com.crazykwak.roombooking.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    Member findByUsername(String username);

    Member findByUserId(String userId);
}
