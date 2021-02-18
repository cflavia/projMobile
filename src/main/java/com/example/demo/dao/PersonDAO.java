package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.ArrayList;

public interface PersonDAO {
    int insertPerson(int id, Person person) throws Exception;
    default int insertPerson(Person person) throws Exception {
        int id= (int) Math.random();
        return insertPerson(id,person);
    }
    ArrayList<String> selectAllPeople() throws Exception;

    ArrayList<String> selectPersonById(int id) throws Exception;

    int deletePersonById(int id) throws Exception;

    int updatePersonById(int id, Person person);
}
