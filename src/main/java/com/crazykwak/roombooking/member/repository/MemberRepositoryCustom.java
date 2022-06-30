package com.crazykwak.roombooking.member.repository;

import com.crazykwak.roombooking.member.domain.Member;
import com.crazykwak.roombooking.member.dto.LoginDTO;

import java.util.Optional;

public interface MemberRepositoryCustom {

    /**
     * 로그인 아이디, 암호화 된 패스워드로 사용자 데이터 1건 select.
     * @param dto 로그인 아이디, 암호화 된 패스워드를 포함한 DTO.
     * @return 한 개의 Member 데이터 또는 null.
     */
    Optional<Member> login(LoginDTO dto);
}
