package com.example.demo.model;

public class FirstObserver implements Observer{
    @Override
    public void update(int oldValue, int newValue) {
        System.out.println("FIRST OBSERVER: old value: "+oldValue+" and new value: "+newValue);
    }

    @Override
    public void update(String oldValue, String newValue) {
        System.out.println("FIRST OBSERVER: old value: "+oldValue+" and new value: "+newValue);
    }
}
