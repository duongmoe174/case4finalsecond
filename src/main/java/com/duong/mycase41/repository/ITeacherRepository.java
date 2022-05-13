package com.duong.mycase41.repository;

import com.duong.mycase41.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, Long> {
}
