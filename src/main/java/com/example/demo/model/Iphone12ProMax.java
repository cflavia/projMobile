package com.example.demo.model;

import com.example.demo.service.Capacitate;
import com.example.demo.service.Observable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Iphone12ProMax extends Iphone12 implements Observable {

    private int id;

    @Override
    public String getMarca() {
        return marca;
    }

    @Override
    public void setMarca(String marca) {
        this.marca = marca;
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
    public String getCapacitate() {
        return capacitate;
    }

    @Override
    public void setCapacitate(String capacitate) {
        this.capacitate = capacitate;
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

    private String camera;
    private String capacitate;
    private String nume;
    private int oldId;
    private ArrayList<Observer> observerList=new ArrayList<>();
    Capacitate c;

    public List<Accesoriu> getAccesoriu() {
        return accesoriu;
    }

    public void setAccesoriu(List<Accesoriu> accesoriu) {
        this.accesoriu = accesoriu;
    }

    public void setCapacitatePos(Capacitate c){
        this.c=c;
    }
    private String marca=getMarca();


    private List<Accesoriu> accesoriu =new ArrayList<>();

    public Iphone12ProMax(int id,String nume,String marca, String capacitate,String camera, List<Accesoriu>accesoriu) {
        this.id = id;
        this.camera = camera;
        this.capacitate = capacitate;
        this.nume=nume;
        this.marca=marca;
        this.accesoriu=accesoriu;
    }

    public void addAccesorii(Accesoriu accesoriu){
        this.accesoriu.add(accesoriu);
    }

    public void print(){
        System.out.println("Telefon Iphone 12 ProMax: ");
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
}
