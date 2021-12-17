package com.example.frameperson.dao;

import com.example.frameperson.baseClasses.Teacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args){

        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        TeacherRepository repository = context.getBean(TeacherRepository.class);

        repository.save(new Teacher("Ivanov",
                "1990",
                "89991231212",
                "russian",
                "10:00-11:00"));
        repository.save(new Teacher("Smirnov",
                "1990",
                "89991231212",
                "russian",
                "10:00-11:00"));
        Iterable<Teacher> teachers = repository.findAll();
        System.out.println("Teachers found with findAll():");
        System.out.println("-------------------------------");
        for (Teacher customer : teachers) {
            System.out.println(teachers);
        }
        System.out.println();

        Teacher teacher = repository.findByID(1);
        System.out.println("Customer found with findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(teacher);
        System.out.println();

        List<Teacher> russians = repository.findByLesson("russian");
        System.out.println("Customer found with findByLesson('russian'):");
        System.out.println("--------------------------------------------");
        for (Teacher russian : russians) {
            System.out.println(russian);
        }

        context.close();



    }
}
