package com.SpringSecurity.demoSecurity.Controller;


import com.SpringSecurity.demoSecurity.DAO.Users;
import com.SpringSecurity.demoSecurity.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public Users register(@RequestBody Users users) {
        users.setPassword(encoder.encode(users.getPassword()));
        userService.saveUser(users);
        return users;
    }

}
