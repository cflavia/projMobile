package com.example.demo.model;

import com.example.demo.service.Observable;

import java.util.ArrayList;
import java.util.List;

public class Y6S extends Huawei implements Observable {

    private int id;
    private String camera;
    private String capacitate;
    private int oldId;
    private ArrayList<Observer> observerList=new ArrayList<>();
    private String marca=getMarca();
    private List<Accesoriu> accesoriu =new ArrayList<>();

    public Y6S(int id, String capacitate,String  camera) {
        this.id = id;
        this.camera = camera;
        this.capacitate = capacitate;
    }

    public void addAccesorii(Accesoriu accesoriu){
        this.accesoriu.add(accesoriu);
    }

    public void print(){
        System.out.println("Telefon Y6S: ");
        printAccesorii();
    }

    public void setAccesorii(List<Accesoriu> accesoriu) {
        this.accesoriu = accesoriu;
    }

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
