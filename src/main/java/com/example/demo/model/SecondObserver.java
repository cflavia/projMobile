package com.example.demo.model;

public class SecondObserver implements Observer{
    @Override
    public void update(int oldValue, int newValue) {
        System.out.println("SECOND OBSERVER= pret vechi: "+oldValue+"   pret nou: "+newValue);
    }

}
