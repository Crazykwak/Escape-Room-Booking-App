package com.crazykwak.roombooking.user.repository.jpa;

import com.crazykwak.roombooking.user.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
}
