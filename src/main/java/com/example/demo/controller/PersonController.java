package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.net.ImportData;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RequestMapping("api/v1/person")
@RestController
public class PersonController extends ImportData {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Person person) throws Exception {
        try {
            post(person.getName());
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @GetMapping
    public ArrayList<String> getAllPeople() throws Exception {
        try{
            return get();
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @GetMapping(path = "{id}")
    public ArrayList<String> getPersonById(@PathVariable("id") int id) throws Exception {
        try {

            return getId(id);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") int id) throws Exception {
        try {
            deleteId(id);
            personService.deletePerson(id);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") int id,@RequestBody Person personUpdate) throws Exception {
        try {
            update(id, personUpdate.getName());
           // personService.updatePerson(id,personUpdate);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
