package com.example.demo.model;

public abstract class Samsung extends Telefon implements Produs {
    String marca="Samsung";
    public String getMarca(){
        return marca;
    }
    public void SO(){System.out.println("SO: Android");}
}
