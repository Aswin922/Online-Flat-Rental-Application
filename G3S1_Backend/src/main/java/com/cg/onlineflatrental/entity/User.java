package com.cg.onlineflatrental.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	private String userName;
	private String password;
	private String userType;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String password, String userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}
	
	
	/** 
	 * @return Integer
	 */
	public Integer getUserId() {
		return userId;
	}
	
	/** 
	 * @param userId
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	/** 
	 * @return String
	 */
	public String getUserName() {
		return userName;
	}
	
	/** 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/** 
	 * @return String
	 */
	public String getPassword() {
		return password;
	}
	
	/** 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/** 
	 * @return String
	 */
	public String getUserType() {
		return userType;
	}
	
	/** 
	 * @param userType
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
	/** 
	 * @return String
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userType=" + userType
				+ "]";
	}
}
