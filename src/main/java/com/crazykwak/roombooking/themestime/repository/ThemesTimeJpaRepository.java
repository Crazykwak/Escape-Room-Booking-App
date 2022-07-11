package com.crazykwak.roombooking.themestime.repository;

import com.crazykwak.roombooking.themestime.domain.ThemesTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemesTimeJpaRepository extends JpaRepository<ThemesTime, Long> {
}
