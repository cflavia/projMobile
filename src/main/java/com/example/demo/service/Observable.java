package com.example.demo.service;

import com.example.demo.model.Observer;

public interface Observable {

    void addObserver(Observer obs);
    void removeObserver(Observer obs);
    void notifyObservers();

}
