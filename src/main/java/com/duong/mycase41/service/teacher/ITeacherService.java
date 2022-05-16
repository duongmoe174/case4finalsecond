package com.duong.mycase41.service.teacher;

import com.duong.mycase41.model.DTO.formTeacher.IClassOfTeacher;
import com.duong.mycase41.model.DTO.formTeacher.IStudentOfTeacher;
import com.duong.mycase41.model.Teacher;
import com.duong.mycase41.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITeacherService extends IGeneralService<Teacher> {
    Page<Teacher> findAll(Pageable pageable);
    Page<Teacher> findAllByFullNameContaining(String fullName, Pageable pageable);

    Iterable<IStudentOfTeacher> getListStudentByTeacherId(Long id);
    Iterable<IStudentOfTeacher> showAllStudent();

    Iterable<IClassOfTeacher> getListClassByTeacherId(Long id);
    Iterable<IClassOfTeacher> showAllClass();
}
