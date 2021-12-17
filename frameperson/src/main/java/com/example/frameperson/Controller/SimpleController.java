package com.example.frameperson.Controller;



import com.example.frameperson.baseClasses.Person;
import com.example.frameperson.baseClasses.Teacher;
import com.example.frameperson.service.PeopleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping
public class SimpleController {

    private final PeopleService peopleService;
    private final ObjectMapper objectMapper;

    @Autowired
    public SimpleController(PeopleService peopleService) {
        this.peopleService = peopleService;
        this.objectMapper = new ObjectMapper();
    }

    @PutMapping("/person")
    @ResponseBody
    public String createPerson(@RequestParam String name, @RequestParam String birthdate, @RequestParam String phone ) throws IOException {
        peopleService.createPerson(name,birthdate,phone);
        Person person = new Person(name, birthdate, phone);
        String ans = objectMapper.writeValueAsString(person);
        return ans;
    }

    @PutMapping("/teacher")
    @ResponseBody
    public String createTeacher(@RequestParam String name, @RequestParam String birthdate, @RequestParam String phone, @RequestParam String lesson, @RequestParam String workingHours) throws IOException {
         peopleService.createTeacher(name,birthdate,phone,lesson,workingHours);
         Teacher teacher = new Teacher(name, birthdate, phone,lesson,workingHours);
         return objectMapper.writeValueAsString(teacher);
    }
    @GetMapping("/get")
    @ResponseBody
    public String getPersonById(@RequestParam int id) throws IOException {
        String person = objectMapper.writeValueAsString(peopleService.getPerson(id));
        return person;
    }
    @GetMapping("/gett")
    @ResponseBody
    public String getTeacherById(@RequestParam int id) throws JsonProcessingException {
        String teacher = objectMapper.writeValueAsString(peopleService.getTeacher(id));
        return teacher;

    }

    @PostMapping("/update")
    @ResponseBody
    public String updatePerson(@RequestParam int id,@RequestParam String name,@RequestParam String birthdate, @RequestParam String phone,@RequestParam String lesson, @RequestParam String workingHours) throws IOException {
        Map<String, Object> params = null;
        params.put("id",id);
        params.put("name",name);
        params.put("birthdate",birthdate);
        params.put("phone",phone);
        params.put("lesson",lesson);
        params.put("workingHours",workingHours);
        peopleService.updateTeacher(params);
        return objectMapper.writeValueAsString(peopleService.getPerson(id));
    }
    @PostMapping("/updatet")
    @ResponseBody
    public String updateTeacher(@RequestParam int id,@RequestParam String name,@RequestParam String birthdate, @RequestParam String phone) throws IOException {
        Map<String, Object> params = null;
        params.put("id",id);
        params.put("name",name);
        params.put("birthdate",birthdate);
        params.put("phone",phone);
        peopleService.updatePerson(params);
        return objectMapper.writeValueAsString(peopleService.getPerson(id));
    }
    @DeleteMapping("/delete")
    public void deletePerson(@RequestParam int id) throws IOException {
        peopleService.delete(id);
    }
}