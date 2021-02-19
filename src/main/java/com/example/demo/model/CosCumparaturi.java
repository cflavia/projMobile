package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class CosCumparaturi {
    private List<Produs> content = new ArrayList<>();
    public void addContent(Produs produs){
        content.add(produs);
    }
    public void print(){
        for(Produs i:content){
            i.print();
        }
    }
    public void accept(Visitor v) {
        v.visit(this);
        for (Produs i:content){
            i.accept(v);
        }
    }
}
