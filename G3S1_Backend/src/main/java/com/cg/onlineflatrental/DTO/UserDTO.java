package com.cg.onlineflatrental.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDTO {
	
private Integer userId;
	
	@NotNull(message = "{Please provide valid user name}")
	private String userName;
	
	@NotNull(message = "{Please provide valid password}")
	@Size(min=5, max=15, message="{Password should have a size between 5 to 15.}")
	private String password;
	
	@NotNull(message = "{Please provide valid userType}")
	private String userType;
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserDTO(int userId, String userName, String password, String userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}
	
	/** 
	 * @return int
	 */
	public int getUserId() {
		return userId;
	}
	
	/** 
	 * @param userId
	 */
	public void setUserId(int userId) {
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
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userType="
				+ userType + "]";
	}
	
}
