package com.assesment.backend.bankservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.backend.bankservice.repository.UserRepository;
import com.assesment.backend.bankservice.service.MyUserDetailsService;
import com.assesment.backend.bankservice.model.User;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")
public class UserController {
    	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MyUserDetailsService service;
    
    @PostMapping("/login")
    public User loginUser (@RequestBody User user) throws Exception {
        User userobj=null;
        //userobj=service.fetchByEmailIdAndPassword(user.getUsername(), user.getPassword());
        if (user.getUsername() != null && user.getPassword() != null) 
		{
            userobj=service.fetchByEmailIdAndPassword(user.getUsername(), user.getPassword()); 
        }
        if(userobj == null){
			throw new Exception("Bad Credentials");
		}
        return userobj;
    }
}

