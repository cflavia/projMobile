package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Accesoriu extends Object {
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Accesoriu(String name){
        this.name=name;
    }

    public Accesoriu() {

    }

    public void print(){
        System.out.println("Accesoriul: "+this.name);
    }


    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }
}
