package com.example.spring_security.controllers;

import com.example.spring_security.models.Student;
import com.example.spring_security.repositories.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    List<Student>list = new ArrayList<>(List.of(
            new Student(1,"Harsh","Java"),
            new Student(2,"modi","Javascript")
    ));

    StudentRepository studentRepository;

    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        return "hello the session is "+request.getSession().getId();
    }

    @GetMapping("/student")
    public List<Student> getStudents(){
        return list;
    }

    @PostMapping("/student")
    public Student insertStudent(@RequestBody Student student){
        studentRepository.save(student);
        return student;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
