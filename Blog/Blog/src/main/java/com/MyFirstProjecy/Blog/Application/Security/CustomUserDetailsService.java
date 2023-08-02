package com.MyFirstProjecy.Blog.Application.Security;

import com.MyFirstProjecy.Blog.Application.entities.User;
import com.MyFirstProjecy.Blog.Application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //LOAD USER DETAILS FORM DATABASE
        User user = userRepository.findByEmail(username);

        return null;
    }
}
