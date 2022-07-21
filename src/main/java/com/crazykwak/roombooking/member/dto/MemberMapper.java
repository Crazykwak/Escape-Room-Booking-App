package com.crazykwak.roombooking.member.dto;

import com.crazykwak.roombooking.member.domain.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    //아직 안씀
    Member memberFormToMember(MemberForm memberForm);
}
