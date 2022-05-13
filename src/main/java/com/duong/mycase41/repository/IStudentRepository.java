package com.duong.mycase41.repository;

import com.duong.mycase41.model.Classes;
import com.duong.mycase41.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends PagingAndSortingRepository<Student, Long> {

    Iterable<Student> findAllByClasses(Classes classes);

    Page<Student> findAllByFullNameContaining(String name, Pageable pageable);
}
