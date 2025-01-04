package com.cg.onlineflatrental.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.onlineflatrental.DTO.UserDTO;
import com.cg.onlineflatrental.entity.User;
import com.cg.onlineflatrental.exception.UserNotFoundException;
import com.cg.onlineflatrental.exception.ValidationException;
import com.cg.onlineflatrental.repository.IUserRepository;

@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@MockBean
	private IUserRepository userRepository;

	private static final Logger logger = LogManager.getLogger(UserService.class);

	UserDTO u1,u2,u3,u4;
	User ue1,ue2,ue3,ue4;
	
	Optional<User> u01,u02;

	
	@BeforeEach
	public void init() {
		u1 = new UserDTO(1, "Rohit", "Rohit@1234", "tenant");
		u2 = new UserDTO(2, "Aadi", "5A6916", "tenant");
		u3 = new UserDTO(3, "Shyam", "7B5819", "landlord");
		u4 = new UserDTO(4, "Seema", "56S312", "admin");

		
		u01 = Optional.of(ue1);
		u02 = Optional.of(ue2);
	}

	
	
	/** 
	 * @throws UserNotFoundException
	 */
	// addUser() Tests:
	@Test
	public void testAddUser() throws UserNotFoundException {
		when(userRepository.save(ue1)).thenReturn(ue1);
		assertEquals(u1.getUserId(), userService.addUser(u1).getUserId());
		assertEquals(u1.getUserName(), userService.addUser(u1).getUserName());
		assertEquals(u1.getPassword(), userService.addUser(u1).getPassword());
		assertEquals(u1.getUserType(), userService.addUser(u1).getUserType());

	}

	
	/** 
	 * @throws UserNotFoundException
	 */
	@Test
	public void testAddUser1() throws UserNotFoundException {
		when(userRepository.existsById(u1.getUserId())).thenReturn(true);

		UserNotFoundException exception=assertThrows(UserNotFoundException.class,()->userService.addUser(u1));
		assertEquals("Service.USER_ALREADY_EXIST", exception.getMessage());
	}


	
	/** 
	 * @throws UserNotFoundException
	 */
	// updateUser() Tests:
	@Test
	public void testUpdateUser() throws UserNotFoundException {
		when(userRepository.findById(u2.getUserId())).thenReturn(u02);
		when(userRepository.save(ue2)).thenReturn(ue2);
		assertEquals(u2.getUserId(), userService.updateUser(u2).getUserId());
		assertEquals(u2.getUserName(), userService.updateUser(u2).getUserName());
		assertEquals(u2.getPassword(), userService.updateUser(u2).getPassword());
		assertEquals(u2.getUserType(), userService.updateUser(u2).getUserType());
	}
	
	
	/** 
	 * @throws UserNotFoundException
	 */
	@Test
	public void testUpdateUser1() throws UserNotFoundException {
		when(userRepository.findById(u1.getUserId())).thenReturn(Optional.empty());
		
		UserNotFoundException exception=assertThrows(UserNotFoundException.class,()->userService.updateUser(u1));
		assertEquals("Service.USER_NOT_FOUND", exception.getMessage());
	}

	
	
	/** 
	 * @throws UserNotFoundException
	 */
	// updatePassword() Tests:
	@Test
	public void testUpdatePassword() throws UserNotFoundException {
		when(userRepository.findById(u2.getUserId())).thenReturn(u02);
		when(userRepository.save(ue2)).thenReturn(ue2);

		assertEquals(u2.getUserName(), userService.updatePassword(u2,u2.getPassword()).getUserName());
		assertEquals(u2.getPassword(), userService.updatePassword(u2,u2.getPassword()).getPassword());
	}
	
	
	/** 
	 * @throws UserNotFoundException
	 */
	@Test
	public void testUpdatePassword1() throws UserNotFoundException {
		when(userRepository.findById(u2.getUserId())).thenReturn(Optional.empty());
		
		UserNotFoundException exception=assertThrows(UserNotFoundException.class,()->userService.updatePassword(u2,u2.getPassword()));
		assertEquals("Service.USER_NOT_FOUND", exception.getMessage());
	}
	
	
	
	/** 
	 * @throws UserNotFoundException
	 */
	// removeUser() Tests:
	@Test
	public void testRemoveUser() throws UserNotFoundException {
		
		when(userRepository.findById(u1.getUserId())).thenReturn(u01);
		userService.removeUser(u1.getUserId());
		verify(userRepository).deleteById(u1.getUserId());
	}
	
	
	/** 
	 * @throws UserNotFoundException
	 */
	@Test
	public void testRemoveUser1() throws UserNotFoundException {
		when(userRepository.findById(u1.getUserId())).thenReturn(Optional.empty());
		
		UserNotFoundException exception=assertThrows(UserNotFoundException.class,()->userService.removeUser(u1.getUserId()));
		assertEquals("Service.USER_NOT_FOUND", exception.getMessage());
	}

	
	
	/** 
	 * @throws UserNotFoundException
	 */
	// viewUser() Tests:
	@Test
	public void testViewUser() throws UserNotFoundException {
		when(userRepository.findById(u2.getUserId())).thenReturn(u02);
		
		assertEquals(u2.getUserId(), userService.viewUser(u2.getUserId()).getUserId());
		assertEquals(u2.getUserName(),userService.viewUser(u2.getUserId()).getUserName());
		assertEquals(u2.getPassword(), userService.viewUser(u2.getUserId()).getPassword());
		assertEquals(u2.getUserType(), userService.viewUser(u2.getUserId()).getUserType());

	}

	
	/** 
	 * @throws UserNotFoundException
	 */
	@Test
	public void testViewUser1() throws UserNotFoundException {
		when(userRepository.findById(u2.getUserId())).thenReturn(Optional.empty());
		
		UserNotFoundException exception=assertThrows(UserNotFoundException.class,()->userService.viewUser(u2.getUserId()));
		assertEquals("Service.USER_NOT_FOUND", exception.getMessage());
	}
	
	
	
	/** 
	 * @throws UserNotFoundException
	 */
	// viewAllUsers() Tests:
	@Test
	public void testViewAllUser() throws UserNotFoundException {

		List<User> allUsers = new ArrayList<>();
		allUsers.add(ue1);
		allUsers.add(ue2);
		allUsers.add(ue3);
		allUsers.add(ue4);

		when(userRepository.findAll()).thenReturn(allUsers);
		assertEquals(4, userService.viewAllUsers().size());
	}
	
	
	/** 
	 * @throws UserNotFoundException
	 */
	@Test
	public void testViewAllUser1() throws UserNotFoundException {

		List<User> allUsers = new ArrayList<>();

		when(userRepository.findAll()).thenReturn(allUsers);
		UserNotFoundException exception=assertThrows(UserNotFoundException.class,()->userService.viewAllUsers());
		assertEquals("Service.USERS_NOT_FOUND", exception.getMessage());
	}
	
	
	
	/** 
	 * @throws UserNotFoundException
	 * @throws ValidationException
	 */
	// validateUsers() Tests:
	@Test
	public void testvalidateUser() throws UserNotFoundException, ValidationException{
		when(userRepository.findByUserName(u2.getUserName())).thenReturn(u02);
		
		assertEquals(true, userService.validateUser(u2.getUserName(),u2.getPassword(),u2.getUserType()));
		assertEquals(true,userService.validateUser(u2.getUserName(),u2.getPassword(),u2.getUserType()));
		assertEquals(true, userService.validateUser(u2.getUserName(),u2.getPassword(),u2.getUserType()));
		assertEquals(true, userService.validateUser(u2.getUserName(),u2.getPassword(),u2.getUserType()));
	}
	
	
	/** 
	 * @throws UserNotFoundException
	 */
	@Test
	public void testvalidateUser1() throws UserNotFoundException{
		when(userRepository.findByUserName(u2.getUserName())).thenReturn(Optional.empty());
		
		UserNotFoundException exception=assertThrows(UserNotFoundException.class,()->userService.validateUser(u2.getUserName(),u2.getPassword(),u2.getUserType()));
		assertEquals("Service.USER_NOT_FOUND", exception.getMessage());
	}
	
	
	/** 
	 * @throws ValidationException
	 */
	@Test
	public void testvalidateUser2() throws ValidationException{
		when(userRepository.findByUserName(u2.getUserName())).thenReturn(u01);
		
		ValidationException exception=assertThrows(ValidationException.class,()->userService.validateUser(u2.getUserName(),u2.getPassword(),u2.getUserType()));
		assertEquals("Service.INCORRECT_PASSWORD", exception.getMessage());
	}
}