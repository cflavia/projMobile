package com.example.demo.model;

public class Incarcator extends Accesoriu {

    private String name;
    private String type;

    public Incarcator(String name, String type) {
        super();
        this.name=name;
        this.type=type;
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
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
        return "Incarcator{" +
                "type='" + type + '\'' +
                "name='" + name + '\'' +
                '}';
    }
    public void print(){
        System.out.println(getName()+" "+getType());
    }

}
