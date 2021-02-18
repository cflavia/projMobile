package com.example.demo.model;

import com.example.demo.net.ImportData;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "produs")
public class Telefon extends ImportData implements Produs {
    @Id
    @Column(name = "id_produs")
    private int id;
    @Column(name = "nume_produs")
    private String name;
    @Column(name = "marca_produs")
    private String marca;
    @Column(name = "capacitate_produs")
    private String capacitate;
    public Telefon(@JsonProperty("id") int id,
                   @JsonProperty("name") String name,
                   @JsonProperty("marca") String marca,
                   @JsonProperty("capacitate") String capacitate,
                   @JsonProperty("camera") String camera,
                   @JsonProperty("continut") String continut,
                   @JsonProperty("accesorii") String accesorii
    ) {
        this.id = id;
        this.name = name;
        this.marca=marca;
        this.camera=camera;
        this.capacitate=capacitate;
        this.continut=continut;
        this.accesorii=accesorii;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCapacitate(String capacitate) {
        this.capacitate = capacitate;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public void setContinut(String continut) {
        this.continut = continut;
    }

    public void setAccesorii(String accesorii) {
        this.accesorii = accesorii;
    }

    @Column(name = "camera_produs")
    private String camera;
    @Column(name = "continut_produs")
    private String continut;
    @Column(name = "accesorii_produs")
    private String accesorii;
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getCapacitate() {
        return capacitate;
    }

    public String getCamera() {
        return camera;
    }

    public String getContinut() {
        return continut;
    }


    public String getMarca() {
        return marca;
    }


    public Telefon() {

    }

    public String getAccesoriiTel() {
        return accesorii;
    }

    @Override
    public void print() {

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
