package com.example.demo.model;

import com.example.demo.service.Capacitate;

public abstract class Iphone extends Telefon implements Produs, Capacitate {
    String marca="iPHONE";
    public String getMarca(){
        return marca;
    }
    public void getSO(){System.out.println("SO: IoS");}

}

