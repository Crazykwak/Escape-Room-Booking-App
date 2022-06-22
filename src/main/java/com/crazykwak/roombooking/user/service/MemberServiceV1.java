package com.crazykwak.roombooking.user.service;

import com.crazykwak.roombooking.user.domain.Member;
import com.crazykwak.roombooking.user.repository.MemberRepository;
import com.crazykwak.roombooking.user.repository.MemberUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceV1 implements MemberService {

    private final MemberRepository repository;

    public MemberServiceV1(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public Member save(Member user) {
        return repository.save(user);
    }

    @Override
    public void update(Long userId, MemberUpdateDto updateParam) {
        repository.update(userId, updateParam);
    }

    @Override
    public void delete(Long userId) {
        repository.delete(userId);
    }

    @Override
    public Optional<Member> findById(Long id) {
        Optional<Member> user = repository.findById(id);
        return user;
    }

    @Override
    public List<Member> findUsers() {
        return repository.findAll();
    }
}