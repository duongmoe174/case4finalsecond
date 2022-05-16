package com.duong.mycase41.repository;

import com.duong.mycase41.model.Classes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassesRepository extends PagingAndSortingRepository<Classes, Long> {
    Page<Classes> findAllByNameContaining(String fullName, Pageable pageable);
}
