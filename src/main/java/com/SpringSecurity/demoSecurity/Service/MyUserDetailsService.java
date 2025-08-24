package com.SpringSecurity.demoSecurity.Service;

import com.SpringSecurity.demoSecurity.DAO.UserPrincipal;
import com.SpringSecurity.demoSecurity.DAO.Users;
import com.SpringSecurity.demoSecurity.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users=repo.findByUsername(username);
        if(users==null){
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPrincipal(users);
    }
}
