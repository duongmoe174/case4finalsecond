package com.duong.mycase41.service.teacher;

import com.duong.mycase41.model.DTO.formTeacher.IClassOfTeacher;
import com.duong.mycase41.model.DTO.formTeacher.IStudentOfTeacher;
import com.duong.mycase41.model.Teacher;
import com.duong.mycase41.repository.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService implements ITeacherService{
    @Autowired
    private ITeacherRepository teacherRepository;

    @Override
    public Iterable<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> findById(Long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void remove(Long id) {
        teacherRepository.deleteById(id);
    }
    @Override
    public Page<Teacher> findAll(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }

    @Override
    public Page<Teacher> findAllByFullNameContaining(String fullName, Pageable pageable) {
        return teacherRepository.findAllByFullNameContaining(fullName, pageable);
    }

    @Override
    public Iterable<IStudentOfTeacher> getListStudentByTeacherId(Long id) {
        return teacherRepository.getListStudentByTeacherId(id);
    }

    @Override
    public Iterable<IStudentOfTeacher> showAllStudent() {
        return teacherRepository.showAllStudent();
    }

    @Override
    public Iterable<IClassOfTeacher> getListClassByTeacherId(Long id) {
        return teacherRepository.getListClassByTeacherId(id);
    }

    @Override
    public Iterable<IClassOfTeacher> showAllClass() {
        return teacherRepository.showAllClass();
    }


}
