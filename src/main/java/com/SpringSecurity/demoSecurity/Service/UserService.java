package com.SpringSecurity.demoSecurity.Service;

import com.SpringSecurity.demoSecurity.DAO.Users;
import com.SpringSecurity.demoSecurity.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    public Users saveUser(Users users){
        return repo.save(users);
    }

}
