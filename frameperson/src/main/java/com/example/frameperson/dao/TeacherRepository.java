package com.example.frameperson.dao;

import com.example.frameperson.baseClasses.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
   Teacher findByID(Integer id);
   List<Teacher> findByLesson(String lesson);
}
