package com.capg.service;

import java.util.List;

import com.capg.dto.UserDTO;
import com.capg.entity.User;
import com.capg.exception.RentalException;

public interface UserService {
	public User viewUser(int userId) throws RentalException;
	public List<UserDTO> viewAllUsers() throws RentalException;
	public User validateUser(String userName,String password) throws RentalException;
	public User addUser(User user) throws RentalException;
	public User updateUser(User user) throws RentalException;
	public User updatePassword(User user,String newPassword) throws RentalException;
	public User removeUser(User user) throws RentalException;
}
