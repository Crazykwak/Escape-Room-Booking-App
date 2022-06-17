package com.crazykwak.roombooking.user.repository;

import com.crazykwak.roombooking.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);
    void update(Long userId, UserUpdateDto updateParam);
    void delete(Long userId);
    Optional<User> findById(Long userId);
    List<User> findAll();
    void clear();

}
