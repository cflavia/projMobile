package com.example.demo.dao;

import com.example.demo.model.Telefon;

import java.util.ArrayList;

public interface ProdusDAO {
    int insertProdus(int id, Telefon produs) throws Exception;
    default int insertProdus(Telefon produs) throws Exception {
        int id= (int) Math.random();
        return insertProdus(id,produs);
    }
    ArrayList<String> selectAllProdus() throws Exception;

    String selectProdusById(int id) throws Exception;

    int deleteProdusById(int id) throws Exception;

    int updateProdusById(int id, Telefon produs) throws Exception;
}
