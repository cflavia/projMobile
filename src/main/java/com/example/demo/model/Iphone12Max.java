package com.example.demo.model;

import com.example.demo.service.Capacitate;
import com.example.demo.service.Observable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Iphone12Max extends Iphone12 implements Observable {

    private int id;

    private String camera;
    private String nume="Iphone12Max";
    private String capacitate;
    private int old;
    private ArrayList<Observer> observerList=new ArrayList<>();
    private int pret;
    @Override
    public String getCamera() {
        return camera;
    }

    @Override
    public void setCamera(String camera) {
        this.camera = camera;
    }

    @Override
    public int getPret() {
        return pret;
    }

    @Override
    public void setPret(int pret) {
        this.pret = pret;
    }

    @Override
    public String getNume() {
        return nume;
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
    public int getOld() {
        return old;
    }

    @Override
    public void setOld(int old) {
        this.old = old;
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


    private String marca=getMarca();

    private List<Accesoriu> accesoriu =new ArrayList<>();

    public List<Accesoriu> getAccesoriu() {
        return accesoriu;
    }

    public void setAccesoriu(List<Accesoriu> accesoriu) {
        this.accesoriu = accesoriu;
    }

    public Iphone12Max(int id, String capacitate, String camera, int pret) {
        this.id = id;
        this.camera = camera;
        this.capacitate = capacitate;
        this.pret=pret;
    }
    Capacitate c;
    public void setCapacitatePos(Capacitate c){
        this.c=c;
    }
    public void addAccesorii(Accesoriu accesoriu){
        this.accesoriu.add(accesoriu);
    }

    public void print(){
        System.out.println("Telefon "+this.getNume()+" "+this.getMarca()+" "+this.getCapacitate()+" "+this.getCamera()+" "+this.getPret());
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
