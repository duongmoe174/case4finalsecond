package com.duong.mycase41.service.student;

import com.duong.mycase41.model.Classes;
import com.duong.mycase41.model.Student;
import com.duong.mycase41.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService extends IGeneralService<Student> {

    Iterable<Student> findAllByClasses(Classes classes);

    Page<Student> findAll(Pageable pageable);

    Page<Student> findAllByFullNameContaining(String name, Pageable pageable);
}
