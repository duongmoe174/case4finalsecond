package com.duong.mycase41.repository;


import com.duong.mycase41.model.AppSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubjectRepository extends JpaRepository<AppSubject, Long> {
}
