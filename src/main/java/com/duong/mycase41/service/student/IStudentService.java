package com.duong.mycase41.service.student;

import com.duong.mycase41.model.DTO.IRoleStudent;
import com.duong.mycase41.model.Student;
import com.duong.mycase41.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService extends IGeneralService<Student> {

    Page<Student> findAll(Pageable pageable);

    Page<Student> findAllByFullNameContaining(String fullName, Pageable pageable);

    IRoleStudent getRoleStudent(Long id);
}
