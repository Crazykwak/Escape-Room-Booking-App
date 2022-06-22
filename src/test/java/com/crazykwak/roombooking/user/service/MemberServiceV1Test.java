package com.crazykwak.roombooking.user.service;

import com.crazykwak.roombooking.user.domain.Member;
import com.crazykwak.roombooking.user.repository.MemberRepository;
import com.crazykwak.roombooking.user.repository.MemberUpdateDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.crazykwak.roombooking.user.domain.MemberGrade.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
class MemberServiceV1Test {

    @Autowired
    MemberService service;

    @Test
    void save() {
        Member user = new Member("CrazyKwak", "12341234q!", "email@mail.com", "성남", "01033332222", NOOB);
        Member save = service.save(user);
        Long id = save.getId();
        log.info("sava id = {}", id);
        Member findId = service.findById(id).orElseThrow();
        assertThat(user.getUserId()).isEqualTo(findId.getUserId());
    }

    @Test
    void update() {
        Member user = new Member("CrazyKwak", "12341234q!", "email@mail.com", "성남", "01033332222", NOOB);
        Member save = service.save(user);
        Long id = save.getId();

        MemberUpdateDto updateParam = new MemberUpdateDto("34735734q!", "k@mail.com", "하남", "01011112222", NOOB);
        service.update(id, updateParam);
        Member findUser = service.findById(id).orElseThrow();
        assertThat(findUser.getPhoneNum()).isEqualTo(updateParam.getPhoneNum());
        assertThat(findUser.getPassword()).isEqualTo(updateParam.getPassword());
        assertThat(findUser.getEmail()).isEqualTo(updateParam.getEmail());
        assertThat(findUser.getLocal()).isEqualTo(updateParam.getLocal());
    }

    @Test
    void delete() {
        Member user = new Member("CrazyKwak", "12341234q!", "email@mail.com", "성남", "01033332222", NOOB);
        Member save = service.save(user);
        Long id = save.getId();

        service.delete(id);
        Optional<Member> byId = service.findById(id);

        assertThat(byId).isEmpty();
    }


    @Test
    void findUsers() {
        Member userA = new Member("CrazyKwak", "12341234q!", "email@mail.com", "성남", "01033332222", NOOB);
        Member userB = new Member("CrazyJaru", "12341234q!", "email@mail.com", "관악산", "01033332222", NOOB);
        service.save(userA);
        service.save(userB);
        List<Member> all = service.findUsers();
        assertThat(all.size()).isEqualTo(2);

    }
}