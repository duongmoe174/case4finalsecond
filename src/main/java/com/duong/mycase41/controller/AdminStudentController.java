package com.duong.mycase41.controller;

import com.duong.mycase41.model.*;
import com.duong.mycase41.model.DTO.formUser.StudentForm;
import com.duong.mycase41.service.appuser.IAppUserService;
import com.duong.mycase41.service.classes.IClassesService;
import com.duong.mycase41.service.gender.IGenderService;
import com.duong.mycase41.service.statusstudent.IStatusService;
import com.duong.mycase41.service.student.IStudentService;
import com.duong.mycase41.service.transcript.ITranscriptService;
import com.duong.mycase41.service.tuition.ITuitionService;
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
@RequestMapping("/students")
@CrossOrigin("*")
public class AdminStudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IAppUserService appUserService;

    @ModelAttribute("appUsers")
    private Iterable<AppUser> appUsers(){
        return appUserService.findAll();
    }

    @Autowired
    private IClassesService classesService;

    @ModelAttribute("classes")
    private Iterable<Classes> classes(){
        return classesService.findAll();
    }

    @Autowired
    private IGenderService genderService;

    @ModelAttribute("genders")
    private Iterable<Gender> genders(){
        return genderService.findAll();
    }

    @Autowired
    private ITuitionService tuitionService;

    @ModelAttribute("tuitions")
    private Iterable<Tuition> tuitions(){
        return tuitionService.findAll();
    }

    @Autowired
    private ITranscriptService transcriptService;

    @ModelAttribute("transcripts")
    private Iterable<Transcript> transcripts(){
        return transcriptService.findAll();
    }

    @Autowired
    private IStatusService statusService;

    @ModelAttribute("statuses")
    private Iterable<StatusStudent> statusStudent(){
        return statusService.findAll();
    }

    @Autowired
    private Environment env;

    @GetMapping("/genders")
    private ResponseEntity<Iterable<Gender>> showAllGender(){
        return new ResponseEntity<>(genderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/status")
    private ResponseEntity<Iterable<StatusStudent>> showAllStatus(){
        return new ResponseEntity<>(statusService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/tuitions")
    private ResponseEntity<Iterable<Tuition>> showAllTuition(){
        return new ResponseEntity<>(tuitionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/classes")
    private ResponseEntity<Iterable<Classes>> showAllClass(){
        return new ResponseEntity<>(classesService.findAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Student>> showAllStudent(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@ModelAttribute StudentForm studentForm){
        MultipartFile file = studentForm.getAvatar();
        String fileName = file.getOriginalFilename();
        String fileUpload = env.getProperty("upload.path").toString();
        String userName = studentForm.getUserName();
        String password = studentForm.getPassword();
        Set<AppRole> roleSet = studentForm.getRoleSet();
        String code = studentForm.getCode();
        String fullName = studentForm.getFullName();
        String phoneNumber = studentForm.getPhoneNumber();
        String email = studentForm.getEmail();
        Gender gender = studentForm.getGender();
        String dateOfBirth = studentForm.getDateOfBirth();
        String address = studentForm.getAddress();
        Classes classes = studentForm.getClasses();
        Tuition tuition = studentForm.getTuition();
        StatusStudent statusStudent = studentForm.getStatusStudent();
        try {
            FileCopyUtils.copy(studentForm.getAvatar().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        AppUser appUser = new AppUser(userName, password, roleSet);
        appUserService.save(appUser);
        Student student = new Student(appUser,code,fullName,phoneNumber,fileName,email,gender,dateOfBirth,address,classes,tuition,statusStudent);
        studentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
        Optional<Student> studentOptional = studentService.findById(id);
        if (!studentOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.remove(id);
        return new ResponseEntity<>(studentOptional.get(), HttpStatus.NO_CONTENT);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Student> editStudent(@PathVariable Long id,@ModelAttribute StudentForm studentForm){
        Optional<Student> studentOptional = studentService.findById(id);
        if (!studentOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            MultipartFile file = studentForm.getAvatar();
            String fileName = file.getOriginalFilename();
            String fileUpload = env.getProperty("upload.path").toString();
            String userName = studentForm.getUserName();
            String password = studentForm.getPassword();
            Set<AppRole> roleSet = studentForm.getRoleSet();
            String code = studentForm.getCode();
            String fullName = studentForm.getFullName();
            String phoneNumber = studentForm.getPhoneNumber();
            String email = studentForm.getEmail();
            Gender gender = studentForm.getGender();
            String dateOfBirth = studentForm.getDateOfBirth();
            String address = studentForm.getAddress();
            Classes classes = studentForm.getClasses();
            Tuition tuition = studentForm.getTuition();
            StatusStudent statusStudent = studentForm.getStatusStudent();
            try {
                FileCopyUtils.copy(studentForm.getAvatar().getBytes(), new File(fileUpload + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            AppUser appUser = new AppUser(userName, password, roleSet);
            appUserService.save(appUser);
            Student student = new Student(appUser,code,fullName,phoneNumber,fileName,email,gender,dateOfBirth,address,classes,tuition,statusStudent);
            student.setId(id);
            studentService.save(student);
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable Long id){
        Student student = studentService.findById(id).get();
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}