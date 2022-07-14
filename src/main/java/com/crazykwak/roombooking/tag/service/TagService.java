package com.crazykwak.roombooking.tag.service;

import com.crazykwak.roombooking.exception.BusinessException;
import com.crazykwak.roombooking.exception.ExceptionCode;
import com.crazykwak.roombooking.tag.domain.Tag;
import com.crazykwak.roombooking.tag.repository.TagJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TagService {

    private final TagJpaRepository repository;

    @Transactional
    public Tag save(Tag tag) {
        return repository.save(tag);
    }

    public Tag findById(Long tagId) {
        return repository.findById(tagId).orElseThrow(() -> new BusinessException(ExceptionCode.TAG_NOT_FOUND));
    }

    public void delete(Long tagId) {
        Tag find = findById(tagId);
        repository.delete(find);
    }

    public void updateByName(Long tagId, String name) {
        Tag find = findById(tagId);
        find.setTagName(name);
    }
}
