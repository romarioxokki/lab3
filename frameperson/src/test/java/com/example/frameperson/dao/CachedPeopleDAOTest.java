package com.example.frameperson.dao;

import com.example.frameperson.baseClasses.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CachedPeopleDAOTest {
     CachedPeopleDAO dao = new CachedPeopleDAO();
     Teacher   teacher = new Teacher("Ivanov",
             "1990",
             "89991231212",
             "russian",
             "10:00-11:00");
    Map<String, Object> teacherAttributes;
    @BeforeEach
    void clear() {
        dao = new CachedPeopleDAO();
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
    void saveTeacher() {
        dao.saveTeacher(teacher);
        Teacher anotherTeacher = new Teacher("Ivanov",
                "1990",
                "89991231212",
                "russian",
                "10:00-11:00");
        assertEquals(dao.findById(1),anotherTeacher);
    }


    @Test
    void updateTeacher() {
        dao.saveTeacher(teacher);
        Teacher anotherTeacher = new Teacher("Ivanov",
                "1992",
                "89991231212",
                "russian",
                "10:00-11:00");
        dao.updateTeacher(teacherAttributes);
        assertEquals(anotherTeacher,teacher);

    }


}