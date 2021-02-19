package com.example.demo.model;

import com.example.demo.service.Observable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public abstract class Accesoriu implements Produs {
    private String name;
    private int id;
    private int pret;

    public void setPret(int pret) {
        this.pret = pret;
    }

    public int getPret(){
        return pret;
    };
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Accesoriu(String name, int pret){
        this.name=name;
        this.pret=pret;
    }

    public Accesoriu() {

    }

    public void print(){
        System.out.println("Accesoriul: "+this.name);
    }

    @Override
    public void accept(Visitor visitor) {
    }

    @Override
    public void setNewValue(int newValue) {
    }

    @Override
    public void setNewValue(String newValue) {

    }


    public void setId(int id) {
        this.id = id;
    }
    @Id
    public int getId() {
        return id;
    }

}
