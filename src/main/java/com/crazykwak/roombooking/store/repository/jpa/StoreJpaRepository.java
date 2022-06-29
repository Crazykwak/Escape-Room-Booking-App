package com.crazykwak.roombooking.store.repository.jpa;

import com.crazykwak.roombooking.store.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreJpaRepository extends JpaRepository<Store, Long> {
    Optional<Store> findByStoreName(String StoreName);
}
