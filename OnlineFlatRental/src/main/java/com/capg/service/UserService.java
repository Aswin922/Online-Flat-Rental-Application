package com.capg.service;

import java.util.List;

import com.capg.dto.UserDTO;
import com.capg.exception.RentalException;

public interface UserService {
	public UserDTO viewUser(int userId) throws RentalException;
	public List<UserDTO> viewAllUsers() throws RentalException;
	public UserDTO validateUser(String userName,String password) throws RentalException;
	public UserDTO addUser(UserDTO user) throws RentalException;
	public UserDTO updateUser(UserDTO user) throws RentalException;
	public UserDTO updatePassword(UserDTO user,String newPassword) throws RentalException;
	public UserDTO removeUser(UserDTO user) throws RentalException;
}
