package com.duong.mycase41.controller;

import com.duong.mycase41.model.Student;
import com.duong.mycase41.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class AdminStudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping
    public ResponseEntity<Iterable<Student>> showAllStudent(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }
}
