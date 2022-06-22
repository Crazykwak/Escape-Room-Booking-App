package com.crazykwak.roombooking.user.repository.jpa;

import com.crazykwak.roombooking.user.domain.Member;
import com.crazykwak.roombooking.user.repository.MemberRepository;
import com.crazykwak.roombooking.user.repository.MemberUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
@Transactional
public class SpringDataJpaMemberRepository implements MemberRepository {

    private final MemberJpaRepository repository;

    @Override
    public Member save(Member user) {
        return repository.save(user);
    }

    @Override
    public void update(Long userId, MemberUpdateDto updateParam) {
        Member user = repository.findById(userId).orElseThrow();
        user.setPassword(updateParam.getPassword());
        user.setPhoneNum(updateParam.getPhoneNum());
        user.setEmail(updateParam.getEmail());
        user.setLocal(updateParam.getLocal());
    }

    @Override
    public void delete(Long userId) {
        Member user = repository.findById(userId).orElseThrow();
        repository.delete(user);
    }

    @Override
    public Optional<Member> findById(Long userId) {
        return repository.findById(userId);
    }

    @Override
    public List<Member> findAll() {
        return repository.findAll();
    }

    @Override
    public void clear() {

    }
}
