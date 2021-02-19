package com.example.demo.model;

import com.example.demo.service.Observable;
import com.example.demo.service.PhotoLoaderFactory;

import javax.persistence.Id;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Photo extends PhotoLoaderFactory {
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
}
