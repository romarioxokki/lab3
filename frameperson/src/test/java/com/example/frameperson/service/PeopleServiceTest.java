package com.example.frameperson.service;

import com.example.frameperson.baseClasses.Teacher;
import com.example.frameperson.dao.CachedPeopleDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PeopleServiceTest {
    PeopleService peopleService;
    CachedPeopleDAO dao = new CachedPeopleDAO();
    String name;
    String birthdate;
    String phone;
    String lesson;
    String workingHours;
    Map<String, Object> teacherAttributes;

    @BeforeEach
    void clearService(){
        peopleService = new PeopleService(dao);
        String name = "Ivanov";
        String birthdate = "1990";
        String phone = "89991231212";
        String lesson = "russian";
        String workingHours = "10:00-11:00";
        teacherAttributes = new HashMap<>();
        teacherAttributes.putAll(Map.of("id",
                1,
                "name",
                "Ivanov",
                "birthdate",
                "1992",
                "phone",
                "89991231212",
                "lesson",
                "russian",
                "workingHours",
                "10:00-11:00"));
    }

    @Test
    void createTeacher() throws IOException {
        String name = "Ivanov";
        String birthdate = "1990";
        String phone = "89991231212";
        String lesson = "russian";
        String workingHours = "10:00-11:00";
        peopleService.createTeacher(name,birthdate,phone,lesson,workingHours);
       Teacher anotherTeacher = new Teacher("Ivanov",
                "1990",
                "89991231212",
                "russian",
                "10:00-11:00");

        ObjectMapper objectMapper = new ObjectMapper();
        String s1 = objectMapper.writeValueAsString(anotherTeacher);
        String s2 = objectMapper.writeValueAsString(peopleService.getTeacher(1));


       Teacher teacher = (Teacher) peopleService.getPerson(1);
        assertEquals(s1,s2);

    }


    @Test
    void updatePerson() throws IOException {
        teacherAttributes = new HashMap<>();
        teacherAttributes.putAll(Map.of("id",
                1,
                "name",
                "Ivanov",
                "birthdate",
                "1992",
                "phone",
                "89991231212",
                "lesson",
                "russian",
                "workingHours",
                "10:00-11:00"));
        String name = "Ivanov";
        String birthdate = "1990";
        String phone = "89991231212";
        String lesson = "russian";
        String workingHours = "10:00-11:00";
        peopleService.createTeacher(name,birthdate,phone,lesson,workingHours);
        peopleService.updateTeacher(teacherAttributes);
        Teacher anotherTeacher = new Teacher("Ivanov",
                "1992",
                "89991231212",
                "russian",
                "10:00-11:00");
        assertEquals(anotherTeacher,peopleService.getPerson(1));
    }


}