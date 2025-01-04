package com.cg.onlineflatrental.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AdminDTO {
	@NotNull(message = "{Please provide valid admin id}")
	private int adminId;
	@NotNull(message = "{Please provide valid password}")
	@Size(min=5, max=15, message="{Password should have a size between 5 to 15.}")
    private String adminPassword;

    public AdminDTO() {
    	super();
    }

    public AdminDTO(int adminId, String adminPassword) {
        this.adminId = adminId;
        this.adminPassword = adminPassword;
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
        return "AdminDTO{" +
                "adminId=" + adminId +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }
}

