package com.example.demo.model;

import com.example.demo.service.Observable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class P40 extends Huawei implements Observable {
    private int id;
    private String camera;
    private String capacitate;
    private int oldId;
    private ArrayList<Observer> observerList=new ArrayList<>();
    private String marca=getMarca();
    private List<Accesoriu> accesoriu =new ArrayList<>();

    public String getNume() {
        return nume;
    }

    String nume="P40";

    @Override
    public void setCamera(String camera) {
        this.camera = camera;
    }

    @Override
    public void setCapacitate(String capacitate) {
        this.capacitate = capacitate;
    }

    public void setOldId(int oldId) {
        this.oldId = oldId;
    }

    public void setObserverList(ArrayList<Observer> observerList) {
        this.observerList = observerList;
    }


    public void setAccesoriu(List<Accesoriu> accesoriu) {
        this.accesoriu = accesoriu;
    }

    public P40(int id, String capacitate, String camera) {
        this.id = id;
        this.camera = camera;
        this.capacitate = capacitate;
    }

    public P40() {

    }


    public void addAccesorii(Accesoriu accesoriu){
        this.accesoriu.add(accesoriu);
    }

    public void print(){
        System.out.println("Telefon "+this.getNume()+" "+this.getMarca()+" "+this.getCapacitate()+" "+this.getCamera());
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
