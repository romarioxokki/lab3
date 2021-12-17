package base;

import com.example.frameperson.baseClasses.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Teacher teacher;

    @BeforeEach
    void initialisation() {
        teacher = new Teacher("Ivanov",
                "1990",
                "89991231212",
                "russian",
                "10:00-11:00");
    }

    @Test
    void setName() {
        teacher.setName("Max");
        Teacher anotherTeacher = new Teacher("Max",
                "1990",
                "89991231212",
                "russian",
                "10:00-11:00");
        assertEquals(anotherTeacher, teacher);
    }


    @Test
    void setBirthdate() {
        teacher.setBirthdate("1991");
        Teacher anotherTeacher = new Teacher("Ivanov",
                "1991",
                "89991231212",
                "russian",
                "10:00-11:00");
        assertEquals(anotherTeacher, teacher);

    }


    @Test
    void setPhone() {
        teacher.setPhone("123");
        Teacher anotherTeacher = new Teacher("Ivanov",
                "1990",
                "123",
                "russian",
                "10:00-11:00");
        assertEquals(anotherTeacher, teacher);
    }




}