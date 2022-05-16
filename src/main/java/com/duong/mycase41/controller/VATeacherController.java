package com.duong.mycase41.controller;

import com.duong.mycase41.model.DTO.formTeacher.IClassOfTeacher;
import com.duong.mycase41.model.DTO.formTeacher.IStudentOfTeacher;
import com.duong.mycase41.model.Teacher;
import com.duong.mycase41.service.teacher.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@CrossOrigin("*")
public class VATeacherController {
    @Autowired
    private ITeacherService teacherService;

    @ModelAttribute("teacher")
    private Iterable<Teacher> teachers(){
        return teacherService.findAll();
    }

    @GetMapping("/list-student/{id}")
    public ResponseEntity<Iterable<IStudentOfTeacher>> getListStudentByTeacherId(@PathVariable Long id){
        Iterable<IStudentOfTeacher> getStudent = teacherService.getListStudentByTeacherId(id);
        return new ResponseEntity<>(getStudent, HttpStatus.OK);
    }

    @GetMapping("/list-student")
    public ResponseEntity<Iterable<IStudentOfTeacher>> showAllStudent(){
        Iterable<IStudentOfTeacher> listStudent = teacherService.showAllStudent();
        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Teacher>> getTeacher(){
        Iterable<Teacher> listTeacher = teacherService.findAll();
        return new ResponseEntity<>(listTeacher, HttpStatus.OK);
    }

    @GetMapping("/list-class/{id}")
    public ResponseEntity<Iterable<IClassOfTeacher>> getListClassByTeacherId(@PathVariable Long id){
        Iterable<IClassOfTeacher> getClass = teacherService.getListClassByTeacherId(id);
        return new ResponseEntity<>(getClass, HttpStatus.OK);
    }

    @GetMapping("/list-class")
    public ResponseEntity<Iterable<IClassOfTeacher>> showAllClass(){
        Iterable<IClassOfTeacher> listClass = teacherService.showAllClass();
        return new ResponseEntity<>(listClass, HttpStatus.OK);
    }
}
