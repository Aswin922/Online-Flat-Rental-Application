package com.cg.onlineflatrental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental.DTO.UserDTO;
import com.cg.onlineflatrental.entity.User;
import com.cg.onlineflatrental.exception.UserNotFoundException;
import com.cg.onlineflatrental.exception.ValidationException;
import com.cg.onlineflatrental.repository.IUserRepository;


@Service
@Transactional
public class UserService implements IUserService{
	@Autowired
	private IUserRepository userRepository;
	
	
	/** 
	 * @param userId
	 * @return UserDTO
	 * @throws UserNotFoundException
	 */
	@Override
	public UserDTO viewUser(int userId) throws UserNotFoundException {
		Optional<User> optional = userRepository.findById(userId);
		User user = optional.orElseThrow(() -> new UserNotFoundException("Service.USER_NOT_FOUND"));
		UserDTO user1 = new UserDTO();
		user1.setUserId(user.getUserId());
		user1.setUserName(user.getUserName());
		user1.setPassword(user.getPassword());
		user1.setUserType(user.getUserType());
		return user1;
	}
	
	/** 
	 * @return List<UserDTO>
	 * @throws UserNotFoundException
	 */
	@Override
	public List<UserDTO> viewAllUsers() throws UserNotFoundException{
		Iterable<User> users = userRepository.findAll();
		List<UserDTO> usersList = new ArrayList<>();
		users.forEach(user -> {
			UserDTO user1 = new UserDTO();
			user1.setUserId(user.getUserId());
			user1.setUserName(user.getUserName());
			user1.setPassword(user.getPassword());
			user1.setUserType(user.getUserType());
			usersList.add(user1);
		});
		if (usersList.isEmpty())
			throw new UserNotFoundException("Service.USERS_NOT_FOUND");
		return usersList;
	}
	
	/** 
	 * @param userName
	 * @param password
	 * @param userType
	 * @return Boolean
	 * @throws UserNotFoundException
	 * @throws ValidationException
	 */
	@Override
	public Boolean validateUser(String userName,String password,String userType) throws UserNotFoundException,ValidationException {
		Optional<User> optional = userRepository.findByUserName(userName);
		optional.orElseThrow(() -> new UserNotFoundException("Service.USER_NOT_FOUND"));
		Boolean flag=false;
		if(optional.get().getPassword().equals(password) && userType.equals(optional.get().getUserType())) {
			flag=true;
		}
		else {
			throw new ValidationException("Service.INCORRECT_PASSWORD");
		}
		return flag;
	}
	
	/** 
	 * @param user
	 * @return UserDTO
	 * @throws UserNotFoundException
	 */
	@Override
	public UserDTO addUser(UserDTO user) throws UserNotFoundException {
		if(userRepository.existsById(user.getUserId())) {
			throw new UserNotFoundException("Service.USER_ALREADY_EXIST");
		}
		else {
			User user1 = new User();
			user1.setUserId(user.getUserId());
			user1.setUserName(user.getUserName());
			user1.setPassword(user.getPassword());
			user1.setUserType(user.getUserType());
			userRepository.save(user1);
			return user;
		}
		
	}
	
	/** 
	 * @param user
	 * @return UserDTO
	 * @throws UserNotFoundException
	 */
	@Override
	public UserDTO updateUser(UserDTO user) throws UserNotFoundException {
		Optional<User> optional = userRepository.findById(user.getUserId());
		optional.orElseThrow(() -> new UserNotFoundException("Service.USER_NOT_FOUND"));
		User user1=optional.get();
		user1.setUserName(user.getUserName());
		user1.setPassword(user.getPassword());
		user1.setUserType(user.getUserType());
		userRepository.save(user1);
		return user;
	}
	
	
	/** 
	 * @param user
	 * @param newPassword
	 * @return UserDTO
	 * @throws UserNotFoundException
	 */
	@Override
	public UserDTO updatePassword(UserDTO user,String newPassword) throws UserNotFoundException {
		Optional<User> optional = userRepository.findById(user.getUserId());
		optional.orElseThrow(() -> new UserNotFoundException("Service.USER_NOT_FOUND"));
		User user1=optional.get();
		user1.setPassword(newPassword);
		userRepository.save(user1);
		return user;
	}
	
	
	/** 
	 * @param userId
	 * @return UserDTO
	 * @throws UserNotFoundException
	 */
	@Override
	public UserDTO removeUser(Integer userId) throws UserNotFoundException {
		Optional<User> optional = userRepository.findById(userId);
		optional.orElseThrow(() -> new UserNotFoundException("Service.USER_NOT_FOUND"));
        userRepository.deleteById(userId);
        UserDTO user1 = new UserDTO();
		user1.setUserId(optional.get().getUserId());
		user1.setUserName(optional.get().getUserName());
		user1.setPassword(optional.get().getPassword());
		user1.setUserType(optional.get().getUserType());
		return user1;
	}
	
}
