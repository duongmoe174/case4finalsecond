package com.duong.mycase41.controller;

import com.duong.mycase41.model.AppSubject;
import com.duong.mycase41.model.Classes;
import com.duong.mycase41.repository.ISubjectRepository;
import com.duong.mycase41.service.classes.ClassesService;
import com.duong.mycase41.service.subject.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
    @Autowired
    private ClassesService classesService;
//-----------CLASSES--------------
    @GetMapping("/classes")
    public ResponseEntity<Iterable<Classes>> getAllClasses () {
      return new ResponseEntity<>(classesService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/classes")
    public ResponseEntity<Classes> createClass(@ModelAttribute Classes classes) {
        return new ResponseEntity<>(classesService.save(classes), HttpStatus.CREATED);
    }

    @DeleteMapping("/classes/{id}")
    public ResponseEntity<Classes> deleteClasses (@PathVariable Long id) {
        Optional<Classes> classesOptional = classesService.findById(id);
        if (!classesOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        classesService.remove(id);
        return new ResponseEntity<>(classesOptional.get(), HttpStatus.OK);
    }

    //-----------SUBJECT--------------
    @Autowired
    ISubjectService subjectService;
    @GetMapping("/subject")
    public ResponseEntity<Iterable<AppSubject>> getAllSubject() {
        return new ResponseEntity<>(subjectService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/subject")
    public ResponseEntity<AppSubject> createSubject(@ModelAttribute AppSubject subject) {
        return new ResponseEntity<>(subjectService.save(subject), HttpStatus.CREATED);
    }
}
