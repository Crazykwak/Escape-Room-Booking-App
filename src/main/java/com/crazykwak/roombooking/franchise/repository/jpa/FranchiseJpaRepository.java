package com.crazykwak.roombooking.franchise.repository.jpa;

import com.crazykwak.roombooking.franchise.domain.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FranchiseJpaRepository extends JpaRepository<Franchise, Long> {
    Optional<Franchise> findByName(String name);
}
