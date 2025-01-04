package com.cg.onlineflatrental.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int adminId;
	String adminPassword;
	
	public Admin(int adminId, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminPassword = adminPassword;
	}
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/** 
	 * @return int
	 */
	public int getAdminId() {
		return adminId;
	}
	
	/** 
	 * @param adminId
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	/** 
	 * @return String
	 */
	public String getAdminPassword() {
		return adminPassword;
	}
	
	/** 
	 * @param adminPassword
	 */
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	
	/** 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminPassword=" + adminPassword + "]";
	}
	

}
