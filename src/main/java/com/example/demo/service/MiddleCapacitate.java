package com.example.demo.service;

public class MiddleCapacitate implements Capacitate {

    @Override
    public void capacitate(String p) {
        System.out.println("Capacitate <-> "+p+ " middle");
    }
}
