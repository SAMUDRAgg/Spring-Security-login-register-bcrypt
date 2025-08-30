package com.SpringSecurity.demoSecurity.Controller;

import com.SpringSecurity.demoSecurity.DAO.Students;
import com.SpringSecurity.demoSecurity.Service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;



    @GetMapping("Students")
    public List<Students> getAllStudents() {
        return studentService.getStudent();
    }

    @PostMapping("addStudents")
    public void addStudents(@RequestBody Students st) {
        studentService.addStudents(st);

    }

    @GetMapping("csrf")
    public CsrfToken getCsrfToken(HttpServletRequest req) {

        return (CsrfToken) req.getAttribute("_csrf");
    }


}
