package com.example.frameperson.service;

import com.example.frameperson.baseClasses.Person;
import com.example.frameperson.baseClasses.Student;
import com.example.frameperson.baseClasses.StudySubject;
import com.example.frameperson.baseClasses.Teacher;
import com.example.frameperson.dao.CachedPeopleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Component
public class PeopleService {
    private  CachedPeopleDAO serviceDao;

    @Autowired
    public PeopleService(CachedPeopleDAO serviceDao) {
        this.serviceDao = serviceDao;
    }

    public void createPerson(String name, String birthdate, String phone) throws IOException {
        Person person = new Person(name,birthdate,phone);
        serviceDao.savePerson(person);
    }
    public void createTeacher(String name, String birthdate, String phone, String lesson, String workingHours) throws IOException {
        Teacher teacher = new Teacher(name,birthdate,phone,lesson,workingHours);
        serviceDao.saveTeacher(teacher);

    }
    public  void createStudent(String name, String birthdate, String phone, StudySubject[] studySubject, Map averageMark) throws IOException {
        Student student = new Student(name,birthdate,phone,studySubject,averageMark);
        serviceDao.saveStudent(student);
    }

    public Teacher getTeacher(int id){
        Teacher teacher = (Teacher) serviceDao.findById(id);
        return teacher;

    }

    public Object getPerson(int id) throws IOException {
        Object person = serviceDao.findById(id);
        return person;
    }
    public  void updatePerson(Map<String, Object> params ) throws IOException {
        serviceDao.updatePerson(params);
    }
    public void updateTeacher(Map<String, Object> params ) throws IOException {
        serviceDao.updateTeacher(params);
    }


    public void delete(int id) {
        serviceDao.delete(id);
    }



}
