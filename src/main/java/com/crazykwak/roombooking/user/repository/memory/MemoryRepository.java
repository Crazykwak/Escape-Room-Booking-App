package com.crazykwak.roombooking.user.repository.memory;

import com.crazykwak.roombooking.user.domain.User;
import com.crazykwak.roombooking.user.repository.UserRepository;
import com.crazykwak.roombooking.user.repository.UserUpdateDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MemoryRepository implements UserRepository {

    private final static Map<Long, User> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public User save(User user) {
        user.setId(sequence++);
        store.put(user.getId(), user);
        return user;
    }

    @Override
    public void update(Long userId, UserUpdateDto updateParam) {
        User user = findById(userId).orElseThrow();
        user.setPassword(updateParam.getPassword());
        user.setLocal(updateParam.getLocal());
        user.setEmail(updateParam.getEmail());
        user.setPhoneNum(updateParam.getPhoneNum());
    }

    @Override
    public void delete(Long userId) {
        store.remove(userId);
    }

    @Override
    public Optional<User> findById(Long userId) {
        User user = store.get(userId);
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> findAll() {
        return  store.values().stream().collect(Collectors.toList());
    }

    @Override
    public void clear() {
        store.clear();
    }
}
