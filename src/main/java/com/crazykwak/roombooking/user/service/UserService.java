package com.crazykwak.roombooking.user.service;

import com.crazykwak.roombooking.user.domain.User;
import com.crazykwak.roombooking.user.repository.UserUpdateDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);
    void update(Long userId, UserUpdateDto updateParam);
    void delete(Long userId);
    Optional<User> findById(Long id);
    List<User> findUsers();
}
