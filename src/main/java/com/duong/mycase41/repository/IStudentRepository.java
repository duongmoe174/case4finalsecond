package com.duong.mycase41.repository;

import com.duong.mycase41.model.DTO.IRoleStudent;
import com.duong.mycase41.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends PagingAndSortingRepository<Student, Long> {

    Page<Student> findAllByFullNameContaining(String fullName, Pageable pageable);

    @Query(nativeQuery = true, value = "select full_name as 'name', point1 as 'point1', point2 as 'point2', t2.name as 'tuition',ss.name as 'status' from student\n" +
            "    join transcript t on student.id = t.student_id\n" +
            "    join tuition t2 on t2.id = student.tuition_id\n" +
            "    join status_student ss on ss.id = student.status_student_id where student_id like ?1")

    IRoleStudent getRoleStudent(Long id);

}
