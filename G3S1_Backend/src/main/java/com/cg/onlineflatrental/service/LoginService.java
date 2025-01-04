package com.cg.onlineflatrental.service;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental.exception.UserNotFoundException;
import com.cg.onlineflatrental.exception.ValidationException;

@Service
public class LoginService implements ILoginService {

	@Autowired
	UserService service;

	
	@Override
	public boolean login(String userName, String password, String userType) throws LoginException, UserNotFoundException, ValidationException {
		boolean flag = false;

		if (userName == null) {
			flag = false;
		}
		if (service.validateUser(userName, password,userType) != null) {
			flag = false;
		} else {
			flag = true;
		}
		return flag;
	}

}