package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class P40Lite extends P40{
    private int id;
    private String camera;
    private String capacitate;
    private int oldId;
    private ArrayList<Observer> observerList=new ArrayList<>();
    private String marca=getMarca();
    private List<Accesoriu> accesoriu =new ArrayList<>();

    public P40Lite(int id, String capacitate, String camera) {
        super();
        this.id = id;
        this.camera = camera;
        this.capacitate = capacitate;
    }

    public void addAccesorii(Accesoriu accesoriu){
        this.accesoriu.add(accesoriu);
    }

    public void print(){
        System.out.println("Telefon P40Lite: ");
        printAccesorii();
    }

    public void setAccesorii(List<Accesoriu> accesoriu) {
        this.accesoriu = accesoriu;
    }

    @ManyToMany(targetEntity = Accesoriu.class)
    public List<Accesoriu> getAccesorii() {
        return accesoriu;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void printAccesorii(){
        for (Accesoriu i: accesoriu){
            i.print();
        }
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public void setNewValue(int newValue) {
        this.oldId=this.id;
        this.id=newValue;
        notifyObservers();
    }
    public void addObserver(Observer obs) {
        observerList.add(obs);
    }

    public void removeObserver(Observer obs) {
        observerList.remove(obs);
    }


    public void notifyObservers() {
        for(Observer i:observerList){
            i.update(oldId,id);
        }
    }
}
