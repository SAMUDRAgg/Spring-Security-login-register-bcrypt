package com.SpringSecurity.demoSecurity.Controller;

import com.SpringSecurity.demoSecurity.DAO.Students;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Students> students = new ArrayList<>(List.of(
            new Students(1, "samudra", "java"),
            new Students(2, "nante", "javascript")
    ));

    @GetMapping("Students")
    List<Students> getAllStudents() {
        return students;
    }

    @PostMapping("addStudents")
    public void addStudents(@RequestBody Students st) {
        students.add(st);
    }

    @GetMapping("csrf")
    public CsrfToken getCsrfToken(HttpServletRequest req) {

        return (CsrfToken) req.getAttribute("_csrf");
    }


}
