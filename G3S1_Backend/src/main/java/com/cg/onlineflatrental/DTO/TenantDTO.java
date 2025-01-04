package com.cg.onlineflatrental.DTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TenantDTO {
	private int tenantId;
	@NotNull(message = "Tenant age is mandatory")
	@Min(value = 1, message = "Age should be more than 0")
	private int age;
	private FlatAddressDTO taddress;

	public TenantDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TenantDTO(int tenantId, int age, FlatAddressDTO taddress) {
		super();
		this.tenantId = tenantId;
		this.age = age;
		this.taddress = taddress;
	}
	
	/** 
	 * @return int
	 */
	public int getTenantId() {
		return tenantId;
	}
	
	/** 
	 * @param tenantId
	 */
	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}
	
	/** 
	 * @return int
	 */
	public int getAge() {
		return age;
	}
	
	/** 
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/** 
	 * @return FlatAddressDTO
	 */
	public FlatAddressDTO getTaddress() {
		return taddress;
	}
	
	/** 
	 * @param taddress
	 */
	public void setTaddress(FlatAddressDTO taddress) {
		this.taddress = taddress;
	}
	
	/** 
	 * @return String
	 */
	@Override
	public String toString() {
		return "TenantDTO [tenantId=" + tenantId + ", age=" + age + ", taddress="
				+ taddress + "]";
	}
}

