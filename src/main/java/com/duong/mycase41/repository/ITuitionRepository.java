package com.duong.mycase41.repository;

import com.duong.mycase41.model.Tuition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITuitionRepository extends JpaRepository<Tuition, Long> {
}
