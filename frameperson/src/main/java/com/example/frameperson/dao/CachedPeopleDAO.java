package com.example.frameperson.dao;

import com.example.frameperson.baseClasses.Person;
import com.example.frameperson.baseClasses.Student;
import com.example.frameperson.baseClasses.Teacher;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Component
public class CachedPeopleDAO  {
    private Map<Integer, Object> cachedPeople = new HashMap<>();



    public void savePerson(Person person) throws IOException {
        cachedPeople.put(person.getId(),person);

    }
    public void saveTeacher(Teacher teacher){
        cachedPeople.put(teacher.getId(),teacher);
    }
    public void saveStudent(Student student){
        cachedPeople.put(student.getId(),student);
    }


    public void updatePerson(Map params) throws IOException {
        Person person = (Person)findById((Integer) params.get("id"));
        delete((Integer) params.get("id"));

        person.setBirthdate((String) params.get("birthdate"));
        person.setName((String) params.get("name"));
        person.setPhone((String) params.get("phone"));
        savePerson(person);

    }
    public void updateTeacher(Map params)  {
        Teacher teacher = (Teacher)findById((Integer) params.get("id"));
        delete((Integer) params.get("id"));
        teacher.setBirthdate((String) params.get("birthdate"));
        teacher.setName((String) params.get("name"));
        teacher.setPhone((String) params.get("phone"));
        teacher.setLesson((String) params.get("lesson"));
        teacher.setWorkingHours((String) params.get("workingHours"));
        saveTeacher(teacher);


    }


    public void delete(int id) {
        cachedPeople.remove(id);
    }


    public Object findById(int id)  {
        return  cachedPeople.get(id);
    }
}