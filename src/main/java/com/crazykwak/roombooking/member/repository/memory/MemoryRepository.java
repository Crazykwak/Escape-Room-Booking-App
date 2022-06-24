package com.crazykwak.roombooking.member.repository.memory;

import com.crazykwak.roombooking.member.domain.Member;
import com.crazykwak.roombooking.member.repository.MemberRepository;
import com.crazykwak.roombooking.member.repository.MemberUpdateDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

//@Repository
public class MemoryRepository implements MemberRepository {

    private final static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member user) {
        user.setId(sequence++);
        store.put(user.getId(), user);
        return user;
    }

    @Override
    public void update(Long userId, MemberUpdateDto updateParam) {
        Member user = findById(userId).orElseThrow();
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
    public Optional<Member> findById(Long userId) {
        Member user = store.get(userId);
        return Optional.ofNullable(user);
    }

    @Override
    public List<Member> findAll() {
        return  store.values().stream().collect(Collectors.toList());
    }

    @Override
    public void clear() {
        store.clear();
    }

    @Override
    public Optional<Member> findByUserId(String userId) {
        return null;
    }
}
