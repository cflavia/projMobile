package com.example.demo.model;

import com.example.demo.service.Observable;
import com.example.demo.service.PhotoLoaderFactory;

import javax.persistence.Id;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Photo extends PhotoLoaderFactory implements Observable {
    private String photo;
    private String oldPhoto;
    private ArrayList<Observer> observerList=new ArrayList<>();

    public Photo(String photo){
        this.photo=photo;
       try {
            TimeUnit.SECONDS.sleep(2);
            PhotoLoaderFactory.create(photo);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }


    public void print(){
        System.out.println("Photo: "+this.photo);
    }

    public void setNewValue(String newValue) {
        oldPhoto=photo;
        this.photo=newValue;
    }

    @Override
    public void addObserver(Observer obs) {
        observerList.add(obs);
        notifyObservers();
    }

    @Override
    public void removeObserver(Observer obs) {
        observerList.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for(Observer i:observerList){
            i.update(oldPhoto,photo);
        }
    }
}
