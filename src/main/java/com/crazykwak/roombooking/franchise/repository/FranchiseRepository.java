package com.crazykwak.roombooking.franchise.repository;

import com.crazykwak.roombooking.franchise.domain.Franchise;
import com.crazykwak.roombooking.franchise.dto.FranchiseUpdateDto;
import com.crazykwak.roombooking.store.domain.Store;
import com.crazykwak.roombooking.store.dto.StoreSearchCond;
import com.crazykwak.roombooking.store.dto.StoreUpdateDto;

import java.util.List;
import java.util.Optional;

public interface FranchiseRepository {

    Franchise save(Franchise franchise);

    void update(Long franchiseId, FranchiseUpdateDto updateParam);

    void delete(Franchise franchise);

    Optional<Franchise> findById(Long storeId);

    Optional<Franchise> findByName(String name);

    List<Franchise> findAll();
}
