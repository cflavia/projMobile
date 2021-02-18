package com.example.demo.dao;

import com.example.demo.model.Person;
import com.example.demo.net.ImportData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("postgres")
public class PersonAccess extends ImportData implements PersonDAO {
    private static List<Person> DB=new ArrayList<Person>();
    public int insertPerson(int id, Person person) throws Exception {
        try {
            post(person.getName());
        }catch (Exception e){
            System.out.println(e);
        }
        //DB.add(new Person(id,person.getName()));
        return 0;
    }
    public ArrayList<String> selectAllPeople() throws Exception {
        try {
            return get();
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public ArrayList<String> selectPersonById(int id) throws Exception {
        return getId(id);
       /* return DB.stream().filter(person -> person.getId()==(id))
                .findFirst();*/
    }

    @Override
    public int deletePersonById(int id) throws Exception {
       /* ArrayList<String> pers=selectPersonById(id);
        if(pers.isEmpty())
            return 0;
        DB.remove(pers.get(id));*/
        deleteId(id);
        return 1;
    }

    @Override
    public int updatePersonById(int id, Person person) {
       /* return selectPersonById(id).map(p -> {
           int indexPers=DB.indexOf(p);
           if(indexPers>=0){
               DB.set(indexPers,new Person(id,person.getName()));
               return 1;
           }
           return 0;
        }).orElse(0);*/
        return 0;
    }
}
