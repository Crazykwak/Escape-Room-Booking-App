package com.crazykwak.roombooking.member.dto;

import com.crazykwak.roombooking.member.domain.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberFormToMember(MemberForm memberForm);
}
