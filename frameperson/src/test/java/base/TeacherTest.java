package base;

import com.example.frameperson.baseClasses.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {
    Teacher teacher;

    @BeforeEach
    void initialisation()  {
        teacher = new Teacher("Ivanov",
                "1990",
                "89991231212",
                "russian",
                "10:00-11:00");
    }
    @Test
    void setLesson() {
        teacher.setLesson("math");
        Teacher anotherTeacher = new Teacher("Ivanov",
                "1990",
                "89991231212",
                "math",
                "10:00-11:00");
        assertEquals(anotherTeacher, teacher);
    }

    @Test
    void getLesson() {

    }

    @Test
    void setWorkingHours() {
        teacher.setWorkingHours("12:00-13:00");
        Teacher anotherTeacher = new Teacher("Ivanov",
                "1990",
                "89991231212",
                "russian",
                "12:00-13:00");
        assertEquals(anotherTeacher, teacher);
    }

    @Test
    void getWorkingHours() {
    }
}