package com.example.demo.model;

public class SecondObserver implements Observer{
    @Override
    public void update(int oldValue, int newValue) {
        System.out.println("SECOND OBSERVER= old value: "+oldValue+" and new value: "+newValue);
    }

    @Override
    public void update(String oldValue, String newValue) {

    }
}
