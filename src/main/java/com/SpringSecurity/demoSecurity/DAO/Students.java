package com.SpringSecurity.demoSecurity.DAO;



public class Students {
     private int id;
     private String name;
     private String tech;

    public int getId() {
        return id;
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
