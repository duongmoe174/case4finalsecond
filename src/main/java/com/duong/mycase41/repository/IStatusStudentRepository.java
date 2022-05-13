package com.duong.mycase41.repository;

import com.duong.mycase41.model.StatusStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusStudentRepository extends JpaRepository<StatusStudent, Long> {

}
