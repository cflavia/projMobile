package com.example.demo.service;

import com.example.demo.model.Iphone11Pro;
import com.example.demo.model.Produs;
import com.example.demo.model.Telefon;

public class ManagerDoc {
    private static ManagerDoc instance;
    private static Telefon produs;

    private ManagerDoc(){};

    public static ManagerDoc getInstance(){
        if(instance==null) {
            instance = new ManagerDoc();
        }
        return instance;
    }

    public static Telefon getMobile(){
        return produs;
    }

    public void setMobile(Telefon m){
        getInstance();
        this.produs =m;
    }
}
