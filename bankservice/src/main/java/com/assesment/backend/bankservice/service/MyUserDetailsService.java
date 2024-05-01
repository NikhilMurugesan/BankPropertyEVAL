package com.assesment.backend.bankservice.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assesment.backend.bankservice.model.User;
import com.assesment.backend.bankservice.repository.UserRepository;

@Service
public class MyUserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public MyUserDetailsService() {
    }

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User fetchByEmailIdAndPassword(String username,String password)
    {   

        return userRepository.findByUsernameAndPassword(username,password);

    }
   
}