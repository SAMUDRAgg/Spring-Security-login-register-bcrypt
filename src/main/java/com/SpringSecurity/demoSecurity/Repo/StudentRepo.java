package com.SpringSecurity.demoSecurity.Repo;

import com.SpringSecurity.demoSecurity.DAO.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Students,Integer> {

}
