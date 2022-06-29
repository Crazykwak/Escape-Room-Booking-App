package com.crazykwak.roombooking.store.repository;

import com.crazykwak.roombooking.store.domain.Store;
import com.crazykwak.roombooking.store.dto.StoreSearchCond;
import com.crazykwak.roombooking.store.dto.StoreUpdateDto;

import java.util.List;
import java.util.Optional;

public interface StoreRepository {

    Store save(Store store);

    void update(Long storeId, StoreUpdateDto updateParam);

    void delete(Store store);

    Optional<Store> findById(Long storeId);

    Optional<Store> findByStoreName(String storeName);

    List<Store> findAll(StoreSearchCond cond);

}
