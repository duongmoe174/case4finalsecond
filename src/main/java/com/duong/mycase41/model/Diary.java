package com.duong.mycase41.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "diary")
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Classes classes;
    @ManyToOne
    private Teacher teacher;
    private LocalDate localDate;
    private String content;

    public Diary(Long id, Classes classes, Teacher teacher, LocalDate localDate, String content) {
        this.id = id;
        this.classes = classes;
        this.teacher = teacher;
        this.localDate = localDate;
        this.content = content;
    }

    public Diary() {
    }

    public Diary(Classes classes, Teacher teacher, LocalDate localDate, String content) {
        this.classes = classes;
        this.teacher = teacher;
        this.localDate = localDate;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
