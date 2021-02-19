package com.example.demo.dao;

import com.example.demo.model.Telefon;
import com.example.demo.net.ImportData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("produsMag")
public class ProdusAccess extends ImportData implements ProdusDAO {
    public int insertProdus(int id, Telefon produs) {
        try {
            postProd(produs.getName(),produs.getMarca(),produs.getCapacitate(), produs.getCamera(), produs.getAccesoriiTel());
        }catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }
    public ArrayList<String> selectAllProdus() throws Exception {
        try {
            return getProdus();
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public String selectProdusById(int id) throws Exception {
        return getIdProdus(id);
    }

    @Override
    public int deleteProdusById(int id) throws Exception {
        deleteIdProdus(id);
        return 1;
    }

    @Override
    public int updateProdusById(int id, Telefon produs) throws Exception {
       updateProdus(id,produs.getName(),produs.getMarca(),produs.getCapacitate(), produs.getCamera(), produs.getAccesoriiTel());
        return 0;
    }
}
