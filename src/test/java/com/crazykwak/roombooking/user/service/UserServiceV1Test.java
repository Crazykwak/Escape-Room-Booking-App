package com.crazykwak.roombooking.user.service;

import com.crazykwak.roombooking.user.domain.User;
import com.crazykwak.roombooking.user.domain.UserGrade;
import com.crazykwak.roombooking.user.repository.UserRepository;
import com.crazykwak.roombooking.user.repository.UserUpdateDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static com.crazykwak.roombooking.user.domain.UserGrade.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceV1Test {

    @Autowired
    UserRepository userRepository;

    @AfterEach
    void clearData() {
        userRepository.clear();
    }

    @Test
    void save() {
        User user = new User(0L, "CrazyKwak", "12341234q!", "email@mail.com", "성남", "01033332222", NOOB);
        User save = userRepository.save(user);
        assertThat(user).isEqualTo(user);
    }

    @Test
    void update() {
        User user = new User(0L, "CrazyKwak", "12341234q!", "email@mail.com", "성남", "01033332222", NOOB);
        User save = userRepository.save(user);
        Long id = save.getId();

        UserUpdateDto updateParam = new UserUpdateDto("34735734q!", "k@mail.com", "하남", "01011112222", NOOB);
        userRepository.update(id, updateParam);
        User findUser = userRepository.findById(id).orElseThrow();
        assertThat(findUser.getPhoneNum()).isEqualTo(updateParam.getPhoneNum());
        assertThat(findUser.getPassword()).isEqualTo(updateParam.getPassword());
        assertThat(findUser.getEmail()).isEqualTo(updateParam.getEmail());
        assertThat(findUser.getLocal()).isEqualTo(updateParam.getLocal());
    }

    @Test
    void delete() {
        User user = new User(0L, "CrazyKwak", "12341234q!", "email@mail.com", "성남", "01033332222", NOOB);
        User save = userRepository.save(user);
        Long id = save.getId();

        userRepository.delete(id);
        Optional<User> byId = userRepository.findById(id);

        assertThat(byId).isEmpty();
    }


    @Test
    void findUsers() {
        User userA = new User(0L, "CrazyKwak", "12341234q!", "email@mail.com", "성남", "01033332222", NOOB);
        User userB = new User(1L, "CrazyJaru", "12341234q!", "email@mail.com", "관악산", "01033332222", NOOB);
        userRepository.save(userA);
        userRepository.save(userB);
        List<User> all = userRepository.findAll();

        assertThat(all.size()).isEqualTo(2);

    }
}