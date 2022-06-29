package com.crazykwak.roombooking.store.repository.jpa;

import com.crazykwak.roombooking.store.domain.Store;
import com.crazykwak.roombooking.store.dto.StoreSearchCond;
import com.crazykwak.roombooking.store.dto.StoreUpdateDto;
import com.crazykwak.roombooking.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SpringDataJpaStoreRepository implements StoreRepository {

    private final StoreJpaRepository repository;

    @Override
    public Store save(Store store) {
        return repository.save(store);
    }

    @Override
    public void update(Long storeId, StoreUpdateDto updateParam) {
        Store findStore = repository.findById(storeId).orElseThrow();

        if(updateParam.getName() != null) {
            findStore.setStoreName(updateParam.getName());
        }
        if(updateParam.getTel() != null) {
            findStore.setTel(updateParam.getTel());
        }
        if(updateParam.getAddress() != null) {
            findStore.setAddress(updateParam.getAddress());
        }
        if(updateParam.getInfo() != null) {
            findStore.setInfo(updateParam.getInfo());
        }
    }

    @Override
    public void delete(Store store) {
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
        return repository.findAll();
    }
}
