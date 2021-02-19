package com.example.demo.model;

public class FirstObserver implements Observer{
    @Override
    public void update(int oldValue, int newValue) {
        System.out.println("FIRST OBSERVER: pret vechie: "+oldValue+"  pret nou: "+newValue);
    }
}
