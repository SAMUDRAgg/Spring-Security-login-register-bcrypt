package com.SpringSecurity.demoSecurity.Service;

import com.SpringSecurity.demoSecurity.DAO.Students;
import com.SpringSecurity.demoSecurity.DAO.Users;
import com.SpringSecurity.demoSecurity.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public void addStudents(Students students) {
        studentRepo.save(students);
    }

    public List<Students> getStudent() {
        return studentRepo.findAll();
    }
}
