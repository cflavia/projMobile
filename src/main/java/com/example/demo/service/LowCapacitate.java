package com.example.demo.service;

public class LowCapacitate implements Capacitate {

    @Override
    public void capacitate(String p) {
        System.out.println("Capacitate <- "+p+ " low");
    }
}
