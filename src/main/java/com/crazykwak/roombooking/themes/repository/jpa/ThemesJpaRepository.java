package com.crazykwak.roombooking.themes.repository.jpa;

import com.crazykwak.roombooking.themes.domain.Themes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ThemesJpaRepository extends JpaRepository<Themes, Long> {

    Optional<Themes> findByName(String name);
}
