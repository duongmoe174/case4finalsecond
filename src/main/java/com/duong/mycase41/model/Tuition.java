package com.duong.mycase41.model;

import javax.persistence.*;

@Entity
@Table(name = "tuition")
public class Tuition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Tuition() {
    }

    public Tuition(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Tuition(String name) {
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
