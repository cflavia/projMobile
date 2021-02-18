package com.example.demo.model;


public interface Produs {
        void print();
        void accept(Visitor visitor);
        void setNewValue(int newValue);
        void setNewValue(String newValue);
}
