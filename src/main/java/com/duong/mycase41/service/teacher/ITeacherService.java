package com.duong.mycase41.service.teacher;

import com.duong.mycase41.model.Teacher;
import com.duong.mycase41.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITeacherService extends IGeneralService<Teacher> {
    Page<Teacher> findAll(Pageable pageable);
    Page<Teacher> findAllByFullNameContaining(String fullName, Pageable pageable);
}
