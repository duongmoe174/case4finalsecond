package com.duong.mycase41.controller;

import com.duong.mycase41.model.Classes;
import com.duong.mycase41.model.DTO.formUser.StudentForm;
import com.duong.mycase41.model.Student;
import com.duong.mycase41.model.Transcript;
import com.duong.mycase41.model.Tuition;
import com.duong.mycase41.service.classes.IClassesService;
import com.duong.mycase41.service.student.IStudentService;
import com.duong.mycase41.service.transcript.ITranscriptService;
import com.duong.mycase41.service.tuition.ITuitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class AdminStudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private ITuitionService tuitionService;

    @Autowired
    private ITranscriptService transcriptService;

    @Autowired
    private IClassesService classesService;

    @Autowired
    Environment env;

    @ModelAttribute("classes")
    private Iterable<Classes>classes(){
        return classesService.findAll();
    }

    @ModelAttribute("tuition")
    private Iterable<Tuition>tuitions(){
        return tuitionService.findAll();
    }

    @ModelAttribute("transcript")
    private Iterable<Transcript>transcripts(){
        return transcriptService.findAll();
    }


    @GetMapping
    public ResponseEntity<Page<Student>> showListStudent(@RequestParam(name = "q") Optional<String> q, @PageableDefault(value = 3) Pageable pageable){
        Page<Student> students;
        if (!q.isPresent()) {
            students = studentService.findAll(pageable);
        } else {
            students = studentService.findAllByFullNameContaining(q.get(), pageable);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);

    }

    @GetMapping("/tuition")
    public ResponseEntity<Iterable<Tuition>> showStatusTuition(){
        return new ResponseEntity<>(tuitionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/transcript")
    public ResponseEntity<Iterable<Transcript>> showStudentTranscript(){
        return new ResponseEntity<>(transcriptService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/class")
    public ResponseEntity<Iterable<Classes>> showClassStudent(){
        return new ResponseEntity<>(classesService.findAll(), HttpStatus.OK);
    }



    @DeleteMapping("delete/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
        Optional<Student> studentOptional = studentService.findById(id);
        if (!studentOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.remove(id);
        return new ResponseEntity<>(studentOptional.get(), HttpStatus.NO_CONTENT);
    }


}

