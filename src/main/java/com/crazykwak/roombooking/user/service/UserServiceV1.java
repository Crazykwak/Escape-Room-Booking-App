package com.crazykwak.roombooking.user.service;

import com.crazykwak.roombooking.user.domain.User;
import com.crazykwak.roombooking.user.repository.UserRepository;
import com.crazykwak.roombooking.user.repository.UserUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceV1 implements UserService{

    private final UserRepository userRepository;

    public UserServiceV1(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void update(Long userId, UserUpdateDto updateParam) {
        userRepository.update(userId, updateParam);
    }

    @Override
    public void delete(Long userId) {
        userRepository.delete(userId);
    }

    @Override
    public Optional<User> findById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> findUsers() {
        return userRepository.findAll();
    }
}
