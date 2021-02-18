package com.example.demo.service;

import com.example.demo.dao.PersonDAO;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonService {
    private final PersonDAO personDAO;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public int addPerson(Person person) throws Exception {
        return personDAO.insertPerson(person);
    }

    public ArrayList<String> getAllPeople() throws Exception {
        return personDAO.selectAllPeople();
    }

    public ArrayList<String> getPersonById(int id) throws Exception {
        return personDAO.selectPersonById(id);
    }

    public int deletePerson(int id) throws Exception {
        return personDAO.deletePersonById(id);
    }

    public int updatePerson(int id, Person newPerson){
        return personDAO.updatePersonById(id,newPerson);
    }
}
