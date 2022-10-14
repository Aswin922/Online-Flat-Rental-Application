package com.capg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.capg.dto.UserDTO;
import com.capg.entity.User;
import com.capg.exception.RentalException;
import com.capg.repository.UserRepository;



public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User viewUser(int userId) throws RentalException {
		Optional<User> optional = userRepository.findById(userId);
		User user = optional.orElseThrow(() -> new RentalException("Service.CUSTOMER_NOT_FOUND"));
		User user1 = new User();
		user1.setUserId(user.getUserId());
		user1.setUserName(user.getUserName());
		user1.setPassword(user.getPassword());
		user1.setUserType(user.getUserType());
		return user1;
	}
	@Override
	public List<UserDTO> viewAllUsers() throws RentalException{
		Iterable<User> users = userRepository.findAll();
		List<UserDTO> usersList = new ArrayList<>();
		users.forEach(customer -> {
			UserDTO cust = new UserDTO();
			cust.setUserId(customer.getUserId());
			cust.setUserName(customer.getUserName());
			cust.setPassword(customer.getPassword());
			cust.setUserType(customer.getUserType());
			usersList.add(cust);
		});
		if (usersList.isEmpty())
			throw new RentalException("Service.USERS_NOT_FOUND");
		return usersList;
	}
	@Override
	public User validateUser(String userName,String password) {
		User user = new User();
		return user;
	}
	@Override
	public User addUser(User user) {
//		UserDTO userDTO = new UserDTO();
//		userDTO.setUserId(user.getUserId());
//		userDTO.setUserName(user.getUserName());
//		userDTO.setPassword(user.getPassword());
//		userDTO.setUserType(user.getUserType());
		User user1=userRepository.save(user);
		return user1;
	}
	@Override
	public User updateUser(User user) {
		return user;
	}
	@Override
	public User updatePassword(User user,String newPassword) {
		return user;
	}
	@Override
	public User removeUser(User user) throws RentalException {
		Optional<User> user1 = userRepository.findById(user.getUserId());
		user1.orElseThrow(() -> new RentalException("Service.USER_NOT_FOUND"));
		userRepository.deleteById(user.getUserId());
		return user;
	}
}
