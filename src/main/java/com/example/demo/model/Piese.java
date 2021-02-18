package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Piese {
    private List<Telefon> content = new ArrayList<>();

    public List<Telefon> getContent() {
        return content;
    }

    public void setContent(List<Telefon> content) {
        this.content = content;
    }
    public void addContent(Telefon produs){
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
