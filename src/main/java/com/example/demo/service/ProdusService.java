package com.example.demo.service;

import com.example.demo.dao.ProdusDAO;
import com.example.demo.model.Telefon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProdusService {
    private final ProdusDAO produsDAO;

    @Autowired
    public ProdusService(@Qualifier("produsMag") ProdusDAO produsDAO) {
        this.produsDAO = produsDAO;
    }


    public int addProdus(Telefon produs) throws Exception {
        return produsDAO.insertProdus(produs);
    }

    public ArrayList<String> getAllProdus() throws Exception {
        return produsDAO.selectAllProdus();
    }

    public String getProdusById(int id) throws Exception {
        return produsDAO.selectProdusById(id);
    }

    public int deleteProdus(int id) throws Exception {
        return produsDAO.deleteProdusById(id);
    }

    public int updateProdus(int id, Telefon newProdus) throws Exception {
        return produsDAO.updateProdusById(id,newProdus);
    }
}
