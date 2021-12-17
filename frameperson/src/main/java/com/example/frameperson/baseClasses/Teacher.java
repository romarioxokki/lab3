package com.example.frameperson.baseClasses;

import javax.persistence.Entity;

@Entity
public class Teacher extends Person {
    private String lesson;
    private String workingHours;

    public Teacher(String name, String birthdate, String phone, String lesson, String workingHours) {
        super(name, birthdate, phone);
        this.lesson = lesson;
        this.workingHours = workingHours;


    }
    private Teacher(){
        super(null, null, null);
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getLesson() {
        return lesson;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    @Override
    public boolean equals(Object teacher){
        if (teacher == null) return false;
        if (teacher.getClass() == Teacher.class) {
            Teacher otherTeacher = (Teacher) teacher;
            return this.name.equals(otherTeacher.name)
                    && this.birthdate.equals(otherTeacher.birthdate)
                    && this.phone.equals(otherTeacher.phone)
                    && this.lesson.equals(otherTeacher.lesson)
                    && this.workingHours.equals(otherTeacher.workingHours);
        }
        return false;
    }
}
