package com.duong.mycase41.repository;

import com.duong.mycase41.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IGenderRepository extends JpaRepository<Gender, Long> {
}
