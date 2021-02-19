package com.example.demo.model;

public class Casti extends Accesoriu {

    private int id;
    private String name;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String type;

    public Casti(String name, String type) {
        super();
        this.name=name;
        this.type=type;
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public void print(){
        System.out.println(getName()+" "+getType());
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
