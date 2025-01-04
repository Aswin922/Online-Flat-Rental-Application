package com.cg.onlineflatrental.service;

import javax.security.auth.login.LoginException;

import com.cg.onlineflatrental.exception.UserNotFoundException;
import com.cg.onlineflatrental.exception.ValidationException;

public interface ILoginService {

	boolean login(String userName, String password, String userType)throws LoginException, UserNotFoundException, ValidationException;

}
