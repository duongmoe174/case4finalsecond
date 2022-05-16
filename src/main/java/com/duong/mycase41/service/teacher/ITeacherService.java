package com.duong.mycase41.service.teacher;

import com.duong.mycase41.model.DTO.formTeacher.IStudentOfTeacher;
import com.duong.mycase41.model.Teacher;
import com.duong.mycase41.service.IGeneralService;

public interface ITeacherService extends IGeneralService<Teacher> {
    Iterable<IStudentOfTeacher> getListStudentByTeacherId(Long id);

    Iterable<IStudentOfTeacher> showAllStudent();
}
