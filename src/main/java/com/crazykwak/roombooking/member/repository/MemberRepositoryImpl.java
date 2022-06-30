package com.crazykwak.roombooking.member.repository;

import com.crazykwak.roombooking.member.domain.Member;
import com.crazykwak.roombooking.member.dto.LoginDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.Optional;

import static com.crazykwak.roombooking.member.domain.QMember.member;

public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public MemberRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Optional<Member> login(LoginDTO dto) {
        return Optional.ofNullable(queryFactory
                .selectFrom(member)
                .where(member.userId.eq(dto.getId()), member.password.eq(dto.getEncPwd()))
                .fetchOne());
    }
}
