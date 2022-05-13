package com.duong.mycase41.repository;

import com.duong.mycase41.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassesRepository extends JpaRepository<Classes, Long> {
}
