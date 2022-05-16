package com.duong.mycase41.controller;

import com.duong.mycase41.model.*;
import com.duong.mycase41.model.DTO.formUser.MinistryForm;
import com.duong.mycase41.service.appuser.IAppUserService;
import com.duong.mycase41.service.gender.IGenderService;
import com.duong.mycase41.service.ministry.IMinistryService;
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
@RequestMapping("/ministry")
@CrossOrigin("*")
public class AdminMinistryController {

    @Autowired
    private IGenderService genderService;

    @Autowired
    private IMinistryService ministryService;

    @Autowired
    private Environment environment;

    @Autowired
    private IAppUserService appUserService;

    @ModelAttribute("genders")
    private Iterable<Gender> genders(){
        return genderService.findAll();
    }

    @GetMapping("/genders")
    private ResponseEntity<Iterable<Gender>> showAllGender(){
        return new ResponseEntity<>(genderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/ministries")
    public ResponseEntity<Page<Ministry>> getAllMinistry(@RequestParam(name = "q")Optional<String> q, @PageableDefault(value = 3)Pageable pageable){
        Page<Ministry> ministries;
        if (!q.isPresent()){
            ministries = ministryService.findAll(pageable);
        }else{
            ministries = ministryService.findAllByFullNameContaining(q.get(), pageable);
        }
        return new ResponseEntity<>(ministries, HttpStatus.OK);
    }

    @PostMapping("/ministries")
    public ResponseEntity<Ministry> createMinistry (@ModelAttribute MinistryForm ministryForm){
        MultipartFile file = ministryForm.getAvatar();
        String fileName = file.getOriginalFilename();
        String fileUpload = environment.getProperty("upload.path").toString();
        String userName = ministryForm.getUserName();
        String password = ministryForm.getPassword();
        Set<AppRole> roleSet = ministryForm.getRoleSet();
        String fullName = ministryForm.getFullName();
        String phoneNumber = ministryForm.getPhoneNumber();
        String email = ministryForm.getEmail();
        Gender gender = ministryForm.getGender();
        String dateOfBirth = ministryForm.getDateOfBirth();
        String address = ministryForm.getAddress();
        try {
            FileCopyUtils.copy(ministryForm.getAvatar().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        AppUser appUser = new AppUser(userName, password, roleSet);
        appUserService.save(appUser);
        Ministry ministry = new Ministry(appUser, fullName, phoneNumber, fileName ,email, gender, dateOfBirth, address);
        ministryService.save(ministry);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/ministries/{id}")
    public ResponseEntity<Ministry> deleteMinistry(@PathVariable Long id){
        Optional<Ministry> ministryOptional = ministryService.findById(id);
        if (!ministryOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ministryService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("ministries/edit/{id}")
    public ResponseEntity<Ministry> editMinistry (@PathVariable Long id, @ModelAttribute MinistryForm ministryForm){
        Optional<Ministry> ministryOptional = ministryService.findById(id);
        if (!ministryOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            MultipartFile file = ministryForm.getAvatar();
            String fileName = file.getOriginalFilename();
            String fileUpLoad = environment.getProperty("upload.path").toString();
            String userName = ministryForm.getUserName();
            String password = ministryForm.getPassword();
            Set<AppRole> roleSet = ministryForm.getRoleSet();
            String fullName = ministryForm.getFullName();
            String phoneNumber = ministryForm.getPhoneNumber();
            String email = ministryForm.getEmail();
            Gender gender = ministryForm.getGender();
            String dateOfBirth = ministryForm.getDateOfBirth();
            String address = ministryForm.getAddress();
            try {
                FileCopyUtils.copy(ministryForm.getAvatar().getBytes(), new File(fileUpLoad+fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            AppUser appUser = new AppUser(userName, password, roleSet);
            appUserService.save(appUser);
            Ministry ministry = new Ministry(appUser, fullName, phoneNumber, fileName, email, gender, dateOfBirth, address);
            ministry.setId(id);
            ministryService.save(ministry);
            return new ResponseEntity<>(ministry, HttpStatus.OK);
        }
    }

    @GetMapping("/ministries/{id}")
    public ResponseEntity<Ministry> getClassById (@PathVariable Long id) {
        Optional<Ministry> ministryOptional = ministryService.findById(id);
        if (!ministryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ministryOptional.get(), HttpStatus.OK);
    }
}
