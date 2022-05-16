package com.duong.mycase41.model;

import javax.persistence.*;

@Entity
@Table(name = "appsubject")
public class AppSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public AppSubject() {
    }

    public AppSubject(String name) {
        this.name = name;
    }

    public AppSubject(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
