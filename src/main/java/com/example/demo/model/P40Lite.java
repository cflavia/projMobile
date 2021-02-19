package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class P40Lite extends P40{
    private int id;
    private String camera;
    private String capacitate;
    private int old;
    private ArrayList<Observer> observerList=new ArrayList<>();
    private String marca=getMarca();
    private List<Accesoriu> accesoriu =new ArrayList<>();

    @Override
    public String getNume() {
        return nume;
    }

    private String nume="P40Lite";

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

    public int getOld() {
        return old;
    }

    @Override
    public void setOld(int old) {
        this.old = old;
    }

    public ArrayList<Observer> getObserverList() {
        return observerList;
    }

    @Override
    public void setObserverList(ArrayList<Observer> observerList) {
        this.observerList = observerList;
    }

    public List<Accesoriu> getAccesoriu() {
        return accesoriu;
    }

    @Override
    public void setAccesoriu(List<Accesoriu> accesoriu) {
        this.accesoriu = accesoriu;
    }

    public P40Lite(int id, String capacitate, String camera, int pret) {
        super();
        this.id = id;
        this.camera = camera;
        this.capacitate = capacitate;
        this.pret=pret;
    }

    public void addAccesorii(Accesoriu accesoriu){
        this.accesoriu.add(accesoriu);
    }
    private int pret;

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
