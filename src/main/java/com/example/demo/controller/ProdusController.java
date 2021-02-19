package com.example.demo.controller;

import com.example.demo.model.Telefon;
import com.example.demo.net.ImportData;
import com.example.demo.service.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RequestMapping("api/v1/produs")
@RestController
public class ProdusController extends ImportData {
    private final ProdusService produsService;

    @Autowired
    public ProdusController(ProdusService produsService) {
        this.produsService = produsService;
    }

    @PostMapping
    public void addProdus(@Valid @NonNull @RequestBody Telefon produs) throws Exception {
        try {
            postProd(produs.getName(), produs.getMarca(), produs.getCapacitate(), produs.getCamera(), produs.getAccesoriiTel());
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @GetMapping
    public ArrayList<String> getAllProdus() throws Exception {
        try{
            return getProdus();
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @GetMapping(path = "{id}")
    public String getProdusById(@PathVariable("id") int id) throws Exception {
        try {

            return getIdProdus(id);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @DeleteMapping(path = "{id}")
    public void deleteProdusById(@PathVariable("id") int id) throws Exception {
        try {
            deleteIdProdus(id);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @PutMapping(path = "{id}")
    public void updateProdus(@PathVariable("id") int id,@RequestBody Telefon produsUpdate) throws Exception {
        try {
            updateProdus(id, produsUpdate.getName(), produsUpdate.getMarca(), produsUpdate.getCapacitate(), produsUpdate.getCamera(), produsUpdate.getAccesoriiTel());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
