package com.duong.mycase41.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "transcript")
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double point1;
    private double point2;
    @OneToOne
    private AppSubject appSubject;
    @ManyToOne
    private Student student;

    public Transcript() {
    }

    public Transcript(Long id, double point1, double point2, AppSubject appSubject, Student student) {
        this.id = id;
        this.point1 = point1;
        this.point2 = point2;
        this.appSubject = appSubject;
        this.student = student;
    }

    public Transcript(double point1, double point2, AppSubject appSubject, Student student) {
        this.point1 = point1;
        this.point2 = point2;
        this.appSubject = appSubject;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPoint1() {
        return point1;
    }

    public void setPoint1(double point1) {
        this.point1 = point1;
    }

    public double getPoint2() {
        return point2;
    }

    public void setPoint2(double point2) {
        this.point2 = point2;
    }

    public AppSubject getAppSubject() {
        return appSubject;
    }

    public void setAppSubject(AppSubject appSubject) {
        this.appSubject = appSubject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
