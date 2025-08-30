package com.SpringSecurity.demoSecurity.DAO;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String name;
     private String tech;

    public int getId() {
        return id;
    }
    public Students(){

    }

    public Students(int id, String name, String tech) {
        this.id = id;
        this.name = name;
        this.tech = tech;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public void setId(int id) {
        this.id = id;
    }
}
