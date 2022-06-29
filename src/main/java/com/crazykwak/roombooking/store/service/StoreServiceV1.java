package com.crazykwak.roombooking.store.service;

import com.crazykwak.roombooking.store.domain.Store;
import com.crazykwak.roombooking.store.dto.StoreSearchCond;
import com.crazykwak.roombooking.store.dto.StoreUpdateDto;
import com.crazykwak.roombooking.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreServiceV1 implements StoreService{

    private final StoreRepository repository;

    @Override
    @Transactional
    public Store save(Store store) {
        return repository.save(store);
    }

    @Override
    @Transactional
    public void update(Long storeId, StoreUpdateDto updateParam) {
        repository.update(storeId, updateParam);
    }

    @Override
    @Transactional
    public void delete(Long storeId) {
        Store store = findById(storeId).orElseThrow();
        repository.delete(store);
    }

    @Override
    public Optional<Store> findById(Long storeId) {
        return repository.findById(storeId);
    }

    @Override
    public Optional<Store> findByStoreName(String storeName) {
        return repository.findByStoreName(storeName);
    }

    @Override
    public List<Store> findAll(StoreSearchCond cond) {
        return repository.findAll(cond);
    }
}
