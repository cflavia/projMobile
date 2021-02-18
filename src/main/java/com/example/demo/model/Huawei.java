package com.example.demo.model;

public abstract class Huawei extends Telefon implements Produs {
    String marca="Huawei";
    public String getMarca(){
        return marca;
    }
    public void SO(){System.out.println("SO: Android");}
}

