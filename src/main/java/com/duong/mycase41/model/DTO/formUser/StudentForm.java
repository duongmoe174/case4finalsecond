package com.duong.mycase41.model.DTO.formUser;

import com.duong.mycase41.model.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public class StudentForm {
    private Long id;
    private String userName;
    private String password;
    private Set<AppRole> roleSet;
    private String fullName;
    private String phoneNumber;
    private MultipartFile avatar;
    private String email;
    private Gender gender;
    private String dateOfBirth;
    private String address;
    private Classes classes;
    private Tuition tuition;
    private StatusStudent statusStudent;

    public StudentForm() {
    }

    public StudentForm(Long id, String userName, String password, Set<AppRole> roleSet, String fullName, String phoneNumber, MultipartFile avatar, String email, Gender gender, String dateOfBirth, String address, Classes classes, Tuition tuition, StatusStudent statusStudent) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.roleSet = roleSet;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.classes = classes;
        this.tuition = tuition;
        this.statusStudent = statusStudent;
    }

    public StudentForm(String userName, String password, Set<AppRole> roleSet, String fullName, String phoneNumber, MultipartFile avatar, String email, Gender gender, String dateOfBirth, String address, Classes classes, Tuition tuition, StatusStudent statusStudent) {
        this.userName = userName;
        this.password = password;
        this.roleSet = roleSet;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.classes = classes;
        this.tuition = tuition;
        this.statusStudent = statusStudent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<AppRole> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<AppRole> roleSet) {
        this.roleSet = roleSet;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Tuition getTuition() {
        return tuition;
    }

    public void setTuition(Tuition tuition) {
        this.tuition = tuition;
    }

    public StatusStudent getStatusStudent() {
        return statusStudent;
    }

    public void setStatusStudent(StatusStudent statusStudent) {
        this.statusStudent = statusStudent;
    }
}
