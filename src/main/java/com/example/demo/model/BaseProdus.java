package com.example.demo.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseProdus implements Produs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Override
    public void print() {

    }

    @Override
    public int getPret() {
        return 0;
    }

    @Override
    public void accept(Visitor visitor) {

    }

    @Override
    public void setNewValue(int newValue) {

    }

    @Override
    public void setNewValue(String newValue) {

    }
}
