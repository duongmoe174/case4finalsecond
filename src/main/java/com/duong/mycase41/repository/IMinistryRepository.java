package com.duong.mycase41.repository;

import com.duong.mycase41.model.Ministry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMinistryRepository extends JpaRepository<Ministry, Long> {
    Page<Ministry> findAllByFullNameContaining(String fullName, Pageable pageable);
}
