package com.duong.mycase41.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private AppUser appUser;
    private String fullName;
    private String phoneNumber;
    private String avatar;
    private String email;
    @ManyToOne
    private Gender gender;
    private String dateOfBirth;
    private String address;
    @ManyToOne
    private Classes classes;
    @ManyToOne
    private Tuition tuition;
    @ManyToOne
    private StatusStudent statusStudent;

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
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

    public Student(AppUser appUser, String fullName, String phoneNumber, String avatar, String email, Gender gender, String dateOfBirth, String address, Classes classes, Tuition tuition, StatusStudent statusStudent) {
        this.appUser = appUser;
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

    public Student(Long id, AppUser appUser, String fullName, String phoneNumber, String avatar, String email, Gender gender, String dateOfBirth, String address, Classes classes, Tuition tuition, StatusStudent statusStudent) {
        this.id = id;
        this.appUser = appUser;
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
}