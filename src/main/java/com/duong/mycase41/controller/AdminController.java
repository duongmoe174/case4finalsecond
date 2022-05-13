package com.duong.mycase41.controller;

import com.duong.mycase41.model.*;
import com.duong.mycase41.model.DTO.formUser.TeacherForm;
import com.duong.mycase41.service.appuser.IAppUserService;
import com.duong.mycase41.service.classes.ClassesService;
import com.duong.mycase41.service.gender.IGenderService;
import com.duong.mycase41.service.subject.ISubjectService;
import com.duong.mycase41.service.teacher.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
    @Autowired
    private IGenderService genderService;
    @Autowired
    private Environment environment;
    @Autowired
    private ClassesService classesService;

    @Autowired
    private IAppUserService appUserService;
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

    @DeleteMapping("/subject/{id}")
    public ResponseEntity<AppSubject> deleteSubject(@PathVariable Long id) {
        Optional<AppSubject> subjectOptional = subjectService.findById(id);
        if (!subjectOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        subjectService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //-----------TEACHER--------------
    @Autowired
    private ITeacherService teacherService;
    @GetMapping("/teachers")
    public ResponseEntity<Iterable<Teacher>> getAllStudent() {
        return new ResponseEntity<>(teacherService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/teachers")
    public ResponseEntity<Teacher> createTeacher(@ModelAttribute TeacherForm teacherForm) {
        MultipartFile file = teacherForm.getAvatar();
        String fileName = file.getOriginalFilename();
        String fileUpload = environment.getProperty("upload.path").toString();
        String userName = teacherForm.getUserName();
        String password = teacherForm.getPassword();
        Set<AppRole> roleSet = teacherForm.getRoleSet();
        String fullName = teacherForm.getFullName();
        String phoneNumber = teacherForm.getPhoneNumber();
        String email = teacherForm.getEmail();
        Gender gender = teacherForm.getGender();
        String dateOfBirth = teacherForm.getDateOfBirth();
        String address = teacherForm.getAddress();
    }
}
