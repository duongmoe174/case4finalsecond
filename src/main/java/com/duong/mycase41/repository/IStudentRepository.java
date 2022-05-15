package com.duong.mycase41.repository;

import com.duong.mycase41.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends PagingAndSortingRepository<Student, Long> {

    Page<Student> findAllByFullNameContaining(String fullName, Pageable pageable);


//    select full_name as 'name', point1, point2, t2.name as 'tuition',ss.name as 'status' from student
//    join transcript t on student.id = t.student_id
//    join tuition t2 on t2.id = student.tuition_id
//    join status_student ss on ss.id = student.status_student_id where full_name like '%p%';
}
