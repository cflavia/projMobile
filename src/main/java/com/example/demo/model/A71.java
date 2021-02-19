package com.example.demo.model;

import com.example.demo.service.Observable;

import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

public class A71 extends Samsung implements Observable {
    private int id;
    private String camera;
    private String capacitate;
    String nume="A71";
    private int oldId;

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

    public String getNume() {
        return nume;
    }

    public int getOldId() {
        return oldId;
    }

    public void setOldId(int oldId) {
        this.oldId = oldId;
    }

    public ArrayList<Observer> getObserverList() {
        return observerList;
    }

    public void setObserverList(ArrayList<Observer> observerList) {
        this.observerList = observerList;
    }

    public List<Accesoriu> getAccesoriu() {
        return accesoriu;
    }

    public void setAccesoriu(List<Accesoriu> accesoriu) {
        this.accesoriu = accesoriu;
    }

    private ArrayList<Observer> observerList=new ArrayList<>();
    private String marca=getMarca();
    private List<Accesoriu> accesoriu =new ArrayList<>();

    public A71(int id, String capacitate, String camera) {
        this.id = id;
        this.camera = camera;
        this.capacitate = capacitate;
    }

    public A71() {

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
        return this.accesoriu;
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
