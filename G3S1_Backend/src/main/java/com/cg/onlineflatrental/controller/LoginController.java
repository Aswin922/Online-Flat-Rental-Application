package com.cg.onlineflatrental.controller;


import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineflatrental.entity.User;
import com.cg.onlineflatrental.exception.UserNotFoundException;
import com.cg.onlineflatrental.exception.ValidationException;
import com.cg.onlineflatrental.service.ILoginService;
import io.swagger.annotations.Api;



@RestController
@RequestMapping(value = "/login")
@CrossOrigin(origins="http://localhost:3000")
@Api(value = "login")
public class LoginController {
    @Autowired
	private ILoginService service;
    
    @GetMapping(value = "/authenticateUser/{username}/{password}/{usertype}")
	public ResponseEntity<User> login(@PathVariable String username, @PathVariable String password, @PathVariable String usertype) throws LoginException, UserNotFoundException, ValidationException {
		ResponseEntity<User> rentity;
		if (service.login(username,password,usertype)) {
			User user = new User(username,password,usertype);
			rentity = new ResponseEntity<User>(user, HttpStatus.ACCEPTED)  ;
		} else {
			rentity = new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
		return rentity;
	}
 
}
