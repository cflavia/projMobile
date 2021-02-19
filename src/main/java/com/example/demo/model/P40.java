package com.example.demo.model;

import com.example.demo.service.Observable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class P40 extends Huawei implements Observable {
    private int id;
    private String camera;
    private String capacitate;
    private int old;
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

    public void setOld(int old) {
        this.old = old;
    }

    public void setObserverList(ArrayList<Observer> observerList) {
        this.observerList = observerList;
    }


    public void setAccesoriu(List<Accesoriu> accesoriu) {
        this.accesoriu = accesoriu;
    }

    public P40(int id, String capacitate, String camera, int pret) {
        this.id = id;
        this.camera = camera;
        this.capacitate = capacitate;
        this.pret=pret;
    }

    public P40() {

    }


    public void addAccesorii(Accesoriu accesoriu){
        this.accesoriu.add(accesoriu);
    }
    private int pret;

    @Override
    public String getCamera() {
        return camera;
    }

    @Override
    public String getCapacitate() {
        return capacitate;
    }

    public int getOld() {
        return old;
    }

    public ArrayList<Observer> getObserverList() {
        return observerList;
    }

    @Override
    public String getMarca() {
        return marca;
    }

    @Override
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public List<Accesoriu> getAccesoriu() {
        return accesoriu;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public int getPret() {
        return pret;
    }

    @Override
    public void setPret(int pret) {
        this.pret = pret;
    }

    public void print(){
        System.out.println("Telefon "+this.getNume()+" "+this.getMarca()+" "+this.getCapacitate()+" "+this.getCamera()+" "+this.getPret());
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
        this.old=this.pret;
        this.pret=newValue;
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
            i.update(old,pret);
        }
    }
}
