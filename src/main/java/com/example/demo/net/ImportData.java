package com.example.demo.net;

import java.sql.*;
import java.util.ArrayList;

public class ImportData {


    public ImportData() {

    }

    public static void main(String[] args) throws Exception{
        connect();
        createTablePerson();
    }
    public static Connection connect()throws Exception{
        try {
            String jdbcURL = "jdbc:mysql://localhost:3306/magazin";
            String username = "root";
            String password = "0000";
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            if (connection != null) {
                System.out.println("Successfully connected to MySQL database test");
                return connection;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public static void createTablePerson()throws Exception{
        try {
            Connection connection=connect();
            PreparedStatement create=connection.prepareStatement("CREATE TABLE IF NOT EXISTS Person(id_pers int NOT NULL PRIMARY KEY AUTO_INCREMENT, name_pers varchar(60))");
            create.executeUpdate();
            System.out.println("Table PERSON");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void createTableProdus()throws Exception{
        try {
            Connection connection=connect();
            PreparedStatement create=connection.prepareStatement("CREATE TABLE IF NOT EXISTS Produs(id_prod int NOT NULL PRIMARY KEY AUTO_INCREMENT, nume_prod varchar(60), marca_prod varchar(60), capacitate_produs varchar(20), camera_prod varchar(20), accesorii_produs varchar(200))");
            create.executeUpdate();
            System.out.println("Table PRODUS");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void post(String var)throws Exception{
        try{
            if(var!=null) {
                Connection connection = connect();
                PreparedStatement posted = connection.prepareStatement("INSERT INTO person (name_pers) VALUES ('" + var + "')");
                posted.executeUpdate();
                System.out.println("Insert pers: "+var);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void postProd(String var1,String var2, String var3, String var4, String var5)throws Exception{
        try{
            if(var1!=null&&var2!=null&&var3!=null&&var4!=null&&var5!=null) {
                Connection connection = connect();
                PreparedStatement posted = connection.prepareStatement("INSERT INTO magazin.produs ( magazin.produs.nume_produs, magazin.produs.marca_produs, magazin.produs.capacitate_produs, magazin.produs.camera_produs, magazin.produs.accesorii_produs) VALUES ('" + var1 + "','" + var2 + "','" + var3 + "','" + var4 + "','" + var5 + "')");
                posted.executeUpdate();
                System.out.println("Insert prod: "+var1);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static ArrayList<String> get()throws Exception{
        try {
            Connection connection=connect();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM person");
            ResultSet resultSet = statement.executeQuery();
            ArrayList<String> arrayList=new ArrayList<String>();
            while (resultSet.next()){
                System.out.println(resultSet.getString("id_pers")+" "+resultSet.getString("name_pers"));
                arrayList.add(resultSet.getString("id_pers")+" "+resultSet.getString("name_pers"));
            }
            return arrayList;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<String> getProdus()throws Exception{
        try {
            Connection connection=connect();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM magazin.produs");
            ResultSet resultSet = statement.executeQuery();
            ArrayList<String> arrayList=new ArrayList<String>();
            while (resultSet.next()){
                System.out.println(resultSet.getString("id_produs")+" "+resultSet.getString("nume_produs")+" "+resultSet.getString("marca_produs")+" "+resultSet.getString("capacitate_produs")+" "+resultSet.getString("camera_produs")+" "+resultSet.getString("accesorii_produs"));
                arrayList.add(resultSet.getString("id_produs")+" "+resultSet.getString("nume_produs")+" "+resultSet.getString("marca_produs")+" "+resultSet.getString("capacitate_produs")+" "+resultSet.getString("camera_produs")+" "+resultSet.getString("accesorii_produs"));
            }
            return arrayList;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public static ArrayList<String> getId(int id)throws Exception{
        try {
            Connection connection=connect();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM person");
            ResultSet resultSet = statement.executeQuery();
            ArrayList<String> arrayList=new ArrayList<String>();
            while (resultSet.next()){
                if(resultSet.getString("id_pers").compareTo(String.valueOf(id))==0){
                System.out.println(id+" "+resultSet.getString("name_pers"));
                arrayList.add(id+" "+resultSet.getString("name_pers"));}
            }
            return arrayList;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public static String getIdProdus(int id)throws Exception{
        try {
            Connection connection=connect();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM magazin.produs");
            ResultSet resultSet = statement.executeQuery();
            String arrayList=new String();
            while (resultSet.next()){
                if(resultSet.getString("id_produs").compareTo(String.valueOf(id))==0) {
                    System.out.println(resultSet.getString("id_produs") + " " + resultSet.getString("nume_produs") + " " + resultSet.getString("marca_produs") + " " + resultSet.getString("capacitate_produs") + " " + resultSet.getString("camera_produs") +  " " + resultSet.getString("accesorii_produs"));
                    arrayList=resultSet.getString("id_produs") + " " + resultSet.getString("nume_produs") + " " + resultSet.getString("marca_produs") + " " + resultSet.getString("capacitate_produs") + " " + resultSet.getString("camera_produs") + " " +  " " + resultSet.getString("accesorii_produs");
                }
                }
            return arrayList;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public static int deleteId(int id)throws Exception{
        try {
            Connection connection=connect();
            String SQL = "DELETE FROM magazin.person WHERE magazin.person.id_pers = '"+id+"' ";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.executeUpdate();
            System.out.println("Delete person: "+id);
            return 1;
        }catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }
    public static int deleteIdProdus(int id)throws Exception{
        try {
            Connection connection=connect();
            String SQL = "DELETE FROM magazin.produs WHERE magazin.produs.id_produs = '"+id+"' ";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.executeUpdate();
            System.out.println("Delete produs: "+id);
            return 1;
        }catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }
    public static int update(int id,String npers)throws Exception{
        try {
            if(npers!=null) {
            Connection connection=connect();
            String SQL = "UPDATE magazin.person SET magazin.person.name_pers= '"+ npers+"'  WHERE magazin.person.id_pers = '"+id+"' ";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.executeUpdate();
            System.out.println("Update person: " + id +" "+npers);
            return 1;}
        }catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }
    public static int updateProdus(int id,String v1,String v2, String v3, String v4, String v5)throws Exception{
        try {
            if(v1!=null&&v2!=null&&v3!=null&&v4!=null&&v5!=null) {
                Connection connection=connect();
                String SQL = "UPDATE magazin.person SET magazin.produs.id_produs=magazin.produs.id_produs, magazin.produs.nume_produs= '"+ v1+"', magazin.produs.marca_produs= '"+ v2+"',magazin.produs.capacitate_produs= '"+ v3+"', magazin.produs.camera_produs= '"+ v4+"', magazin.produs.accesorii_produs= '"+ v5+"' WHERE magazin.produs.id_produs = '"+Integer.valueOf(id)+"' ";
                PreparedStatement statement = connection.prepareStatement(SQL);
                statement.executeUpdate();
                System.out.println("Update produs: " + id +" "+v1+" "+v2+" "+v3+" "+v4+" "+v5);
                return 1;}
        }catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }

}
