package com.crazykwak.roombooking.tag.repository;

import com.crazykwak.roombooking.tag.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagJpaRepository extends JpaRepository<Tag, Long> {
}
