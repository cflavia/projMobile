package com.example.demo.model;

import com.example.demo.service.Observable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class S20 extends Samsung implements Observable {
    private int id;
    private float camera;
    private float capacitate;
    private int oldId;
    private ArrayList<Observer> observerList=new ArrayList<>();
    private String marca=getMarca();
    private List<Produs> content = new ArrayList<>();
    private List<Accesoriu> accesoriu =new ArrayList<>();

    public S20(int id, float camera, float capacitate) {
        this.id = id;
        this.camera = camera;
        this.capacitate = capacitate;
    }
    public void addContent(Produs produs){
        content.add(produs);
    }

    public void addAccesorii(Accesoriu accesoriu){
        this.accesoriu.add(accesoriu);
    }

    public void print(){
        System.out.println("Telefon S20: ");
        printAccesorii();
        for(Produs i:content){
            i.print();
        }
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

    public void printAndroid() {

    }

    public void accept(Visitor v) {
        v.visit(this);
        for (Produs i:content){
            i.accept(v);
        }
    }

    public void setNewValue(int newValue) {
        this.oldId=this.id;
        this.id=newValue;
        notifyObservers();
    }

    @Override
    public void setNewValue(String newValue) {

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
