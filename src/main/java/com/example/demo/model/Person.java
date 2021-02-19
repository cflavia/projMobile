package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id_pers")
    private int id;
    @Column(name = "name_pers")
    private String name;

    public Person(@JsonProperty("id") int id,
                  @JsonProperty("name") String name
                  ) {
        this.id = id;
        this.name = name;
    }

    public Person() {

    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void cumpara(List<Produs> produs){
        for(Produs i:produs)
            i.print();
    }
}
