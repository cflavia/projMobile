package com.example.demo.model;

public class Casti extends Accesoriu {

    private int id;
    private String name;
    private int pret;

    @Override
    public int getPret() {
        return pret;
    }

    @Override
    public void setPret(int pret) {
        this.pret = pret;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String type;

    public Casti(String name, String type, int pret) {
        super();
        this.name=name;
        this.type=type;
        this.pret=pret;
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public void print(){
        System.out.println(getName()+" "+getType()+" "+getPret());
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Casti{" +
                "type='" + type + '\'' +
                "name='" + name + '\'' +
                '}';
    }

}
