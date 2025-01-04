package com.cg.onlineflatrental.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineflatrental.DTO.UserDTO;
import com.cg.onlineflatrental.exception.UserNotFoundException;
import com.cg.onlineflatrental.exception.ValidationException;
import com.cg.onlineflatrental.service.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins="http://localhost:3000")
@Validated
@Api(value="users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Environment environment;

	
	/** 
	 * @param id
	 * @return ResponseEntity<UserDTO>
	 * @throws UserNotFoundException
	 */
	@GetMapping("/viewUser/{id}")
	public ResponseEntity<UserDTO> viewUser(@PathVariable Integer id) throws UserNotFoundException {
		UserDTO user = userService.viewUser(id);
		ResponseEntity<UserDTO> retvalue = new ResponseEntity<UserDTO>(user, HttpStatus.OK);
		return retvalue;
	}
	
	
	/** 
	 * @return ResponseEntity<List<UserDTO>>
	 * @throws UserNotFoundException
	 */
	@GetMapping("/viewAllUsers")
	public ResponseEntity<List<UserDTO>> viewAllUsers() throws UserNotFoundException {
		List<UserDTO> list=userService.viewAllUsers();
		return new ResponseEntity<List<UserDTO>>(list,HttpStatus.OK);
	}
	
	
	/** 
	 * @param user
	 * @return ResponseEntity<String>
	 * @throws UserNotFoundException
	 */
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@Valid @RequestBody UserDTO user) throws UserNotFoundException {
		UserDTO user1=userService.addUser(user);
		String successMessage = "User id: "+ user1.getUserId()+" ,"+environment.getProperty("API.INSERT_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
	
	
	/** 
	 * @param user
	 * @return ResponseEntity<String>
	 * @throws UserNotFoundException
	 */
	@PutMapping("/updateUser")
	public ResponseEntity<String> updateUser(@Valid @RequestBody UserDTO user) throws UserNotFoundException {
		UserDTO user1 = userService.updateUser(user);
		String successMessage = "User id: "+ user1.getUserId()+" ,"+environment.getProperty("API.UPDATE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	
	
	/** 
	 * @param user
	 * @param newpass
	 * @return ResponseEntity<String>
	 * @throws UserNotFoundException
	 */
	@PatchMapping("/updatePassword/{newpass}")
	public ResponseEntity<String> updatePassword(@Valid @RequestBody UserDTO user,@PathVariable String newpass) throws UserNotFoundException {
		UserDTO user1 = userService.updatePassword(user, newpass);
		String successMessage = "User id: "+ user1.getUserId()+" ,"+environment.getProperty("API.UPDATE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	
	
	/** 
	 * @param userId
	 * @return ResponseEntity<String>
	 * @throws UserNotFoundException
	 */
	@DeleteMapping("/removeUser/{userId}")
	public ResponseEntity<String> removeUser(@PathVariable Integer userId) throws UserNotFoundException {
		UserDTO user1=userService.removeUser(userId);
		String successMessage = "User id: "+ user1.getUserId()+" ,"+environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	
	
	/** 
	 * @param username
	 * @param password
	 * @param userType
	 * @return ResponseEntity<String>
	 * @throws UserNotFoundException
	 * @throws ValidationException
	 */
	@PatchMapping("/validateUser/{username}/{password}/{userType}")
	public ResponseEntity<String> validateUser(@PathVariable String username, @PathVariable String password,@PathVariable String userType) throws UserNotFoundException, ValidationException {
		if(!userService.validateUser(username,password,userType)) {
			ResponseEntity<String> retvalue = new ResponseEntity<String>("User and Password Not Matched.",HttpStatus.UNAUTHORIZED);
			return retvalue;
		}
		else {
			ResponseEntity<String> retvalue = new ResponseEntity<String>("User and Password Matched.",HttpStatus.ACCEPTED);
			return retvalue;
		}
	}

}

