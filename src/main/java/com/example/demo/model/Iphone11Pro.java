package com.example.demo.model;

import com.example.demo.service.Capacitate;
import com.example.demo.service.Observable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Iphone11Pro extends Iphone11 implements Observable {
    private int id;

    public Iphone11Pro() {

    }

    @Override
    public String getCamera() {
        return camera;
    }

    @Override
    public void setCamera(String camera) {
        this.camera = camera;
    }

    @Override
    public String getNume() {
        return nume;
    }

    @Override
    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String getCapacitate() {
        return capacitate;
    }

    @Override
    public void setCapacitate(String capacitate) {
        this.capacitate = capacitate;
    }

    @Override
    public int getOldId() {
        return oldId;
    }

    @Override
    public void setOldId(int oldId) {
        this.oldId = oldId;
    }

    @Override
    public ArrayList<Observer> getObserverList() {
        return observerList;
    }

    @Override
    public void setObserverList(ArrayList<Observer> observerList) {
        this.observerList = observerList;
    }

    @Override
    public String getMarca() {
        return marca;
    }

    @Override
    public void setMarca(String marca) {
        this.marca = marca;
    }


    private String camera;
    private String nume;
    private String capacitate;
    private int oldId;
    private ArrayList<Observer> observerList=new ArrayList<>();

    private String marca=getMarca();


    private List<Accesoriu> accesoriu =new ArrayList<>();

    public Iphone11Pro(int id, String capacitate,String camera) {
        this.id = id;
        this.camera = camera;
        this.capacitate = capacitate;
    }

    public void addAccesorii(Accesoriu accesoriu){
        this.accesoriu.add(accesoriu);
    }

    Capacitate c;
    public void setCapacitatePos(Capacitate c){
        this.c=c;
    }
    public void print(){
        System.out.println("Telefon Iphone 11 Pro: ");
        if(c!=null) {
            c.capacitate(this.capacitate);
        }
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

    private void printAccesorii(){
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

    @Override
    public void capacitate(String p) {

    }
}
