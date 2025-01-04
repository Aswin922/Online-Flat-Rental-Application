package com.cg.onlineflatrental.service;

import java.util.List;

import com.cg.onlineflatrental.DTO.UserDTO;
import com.cg.onlineflatrental.exception.UserNotFoundException;
import com.cg.onlineflatrental.exception.ValidationException;

public interface IUserService {
	public UserDTO viewUser(int userId) throws UserNotFoundException;
	public List<UserDTO> viewAllUsers() throws UserNotFoundException;
	public Boolean validateUser(String userName,String password,String userType) throws UserNotFoundException,ValidationException;
	public UserDTO addUser(UserDTO user) throws UserNotFoundException;
	public UserDTO updateUser(UserDTO user) throws UserNotFoundException;
	public UserDTO updatePassword(UserDTO user,String newPassword) throws UserNotFoundException;
	public UserDTO removeUser(Integer userId) throws UserNotFoundException;
}