package com.example.demo.model;


public interface Produs {
        void print();
        int getPret();
        void accept(Visitor visitor);
        void setNewValue(int newValue);
        void setNewValue(String newValue);
}
