package com.duong.mycase41.controller;

import com.duong.mycase41.model.*;
import com.duong.mycase41.model.DTO.formUser.TeacherForm;
import com.duong.mycase41.service.approle.IAppRoleService;
import com.duong.mycase41.service.appuser.IAppUserService;
import com.duong.mycase41.service.classes.ClassesService;
import com.duong.mycase41.service.gender.IGenderService;
import com.duong.mycase41.service.subject.ISubjectService;
import com.duong.mycase41.service.teacher.ITeacherService;
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

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminTeacherController {
    @Autowired
    private IAppRoleService appRoleService;
    @Autowired
    private IGenderService genderService;
    @Autowired
    private Environment environment;
    @Autowired
    private ClassesService classesService;

    @Autowired
    private IAppUserService appUserService;
    //-----------GENDER--------------
    @GetMapping("/genders")
    public ResponseEntity<Iterable<Gender>> getAllGender() {
        return new ResponseEntity<>(genderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/genders/{id}")
    public ResponseEntity<Gender> getGenderById (@PathVariable Long id) {
        Optional<Gender> genderOptional = genderService.findById(id);
        if (!genderOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(genderOptional.get(), HttpStatus.OK);
    }
    //-----------ROLE--------------
    @GetMapping("/roles")
    public ResponseEntity<Iterable<AppRole>> getAllRole() {
        return new ResponseEntity<>(appRoleService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/roles/{id}")
    public ResponseEntity<AppRole> getRoleById (@PathVariable Long id) {
        Optional<AppRole> roleOptional = appRoleService.findById(id);
        if (!roleOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(roleOptional.get(), HttpStatus.OK);
    }
//-----------CLASSES--------------
    @GetMapping("/classes")
    public ResponseEntity<Page<Classes>> getAllClasses(@RequestParam(name = "c") Optional<String> c, @PageableDefault(value = 3) Pageable pageable) {
        Page<Classes> classes;
        if (!c.isPresent()) {
            classes = classesService.findAll(pageable);
        } else {
            classes = classesService.findAllByNameContaining(c.get(), pageable);
        }
        return new ResponseEntity<>(classes, HttpStatus.OK);

    }
    @GetMapping("/classesSelect")
    public ResponseEntity<Iterable<Classes>> getAllSelectClass () {
        return new ResponseEntity<>(classesService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/classes")
    public ResponseEntity<Classes> createClass(@RequestBody Classes classes) {
        return new ResponseEntity<>(classesService.save(classes), HttpStatus.CREATED);
    }

    @GetMapping("/classes/{id}")
    public ResponseEntity<Classes> getClassById (@PathVariable Long id) {
        Optional<Classes> classesOptional = classesService.findById(id);
        if (!classesOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(classesOptional.get(), HttpStatus.OK);
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
    @PostMapping("/classes/edit/{id}")
    public ResponseEntity<Classes> editClasses(@PathVariable Long id, @RequestBody Classes classes) {
        Optional<Classes> classesOptional = classesService.findById(id);
        if (!classesOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        String name = classes.getName();
        Classes newClass = new Classes(name);
        newClass.setId(id);
        classesService.save(newClass);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //-----------SUBJECT--------------
    @Autowired
    ISubjectService subjectService;
    @GetMapping("/subject")
    public ResponseEntity<Iterable<AppSubject>> getAllSubject() {
        return new ResponseEntity<>(subjectService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<AppSubject> getSubjectById (@PathVariable Long id) {
        Optional<AppSubject> subjectOptional = subjectService.findById(id);
        if (!subjectOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(subjectOptional.get(), HttpStatus.OK);
    }
    @PostMapping("/subject")
    public ResponseEntity<AppSubject> createSubject(@RequestBody AppSubject subject) {
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
    @PostMapping("/subject/edit/{id}")
    public ResponseEntity<AppSubject> editSubject(@PathVariable Long id, @RequestBody AppSubject appSubject) {
        Optional<AppSubject> subjectOptional = subjectService.findById(id);
        if (!subjectOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        String name = appSubject.getName();
        AppSubject newSubject = new AppSubject(name);
        newSubject.setId(id);
        subjectService.save(newSubject);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //-----------TEACHER--------------
    @Autowired
    private ITeacherService teacherService;
    @GetMapping("/teachers")
    public ResponseEntity<Page<Teacher>> getAllTeacher(@RequestParam(name = "t") Optional<String> t, @PageableDefault(value = 8) Pageable pageable) {
        Page<Teacher> teachers;
        if (!t.isPresent()) {
            teachers = teacherService.findAll(pageable);
        } else {
            teachers = teacherService.findAllByFullNameContaining(t.get(), pageable);
        }
        return new ResponseEntity<>(teachers, HttpStatus.OK);

    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
        Optional<Teacher> teacherOptional = teacherService.findById(id);
        if (!teacherOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teacherOptional.get(), HttpStatus.OK);
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
        Set<Classes> classes = teacherForm.getClasses();
        try {
            FileCopyUtils.copy(teacherForm.getAvatar().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        AppUser appUser = new AppUser(userName, password, roleSet);
        appUserService.save(appUser);
        Teacher teacher = new Teacher(appUser, fullName, phoneNumber, fileName ,email, gender, dateOfBirth, address, classes);
        teacherService.save(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    @DeleteMapping("/teachers/{id}")
    public ResponseEntity<Teacher> deleteTeacher (@PathVariable Long id) {
        Optional<Teacher> teacherOptional = teacherService.findById(id);
        if (!teacherOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        teacherService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("teachers/edit/{id}")
    public ResponseEntity<Teacher> editTeacher (@PathVariable Long id, @ModelAttribute TeacherForm teacherForm) {
        Optional<Teacher> teacherOptional = teacherService.findById(id);
        if (!teacherOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
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
            Set<Classes> classes = teacherForm.getClasses();
            try {
                FileCopyUtils.copy(teacherForm.getAvatar().getBytes(), new File(fileUpload + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            AppUser appUser = new AppUser(userName, password, roleSet);
            appUserService.save(appUser);
            Teacher teacher = new Teacher(appUser, fullName, phoneNumber, fileName ,email, gender, dateOfBirth, address, classes);
            teacher.setId(id);
            teacherService.save(teacher);
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        }
    }
}
