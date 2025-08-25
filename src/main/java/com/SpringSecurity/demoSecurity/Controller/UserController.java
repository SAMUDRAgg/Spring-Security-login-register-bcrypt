package com.SpringSecurity.demoSecurity.Controller;

import com.SpringSecurity.demoSecurity.DAO.Users;
import com.SpringSecurity.demoSecurity.Service.UserService;
import com.SpringSecurity.demoSecurity.jwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private jwtService jwt;

    @PostMapping("register")
    public Users register(@RequestBody Users users) {
        users.setPassword(encoder.encode(users.getPassword()));
        userService.saveUser(users);
        return users;
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody Users users) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword())
        );

        if (authentication.isAuthenticated()) {
            return jwt.generateToken(users.getUsername());
        } else {
            return ResponseEntity.status(401).body("❌ Invalid username or password");
        }
    }
}
