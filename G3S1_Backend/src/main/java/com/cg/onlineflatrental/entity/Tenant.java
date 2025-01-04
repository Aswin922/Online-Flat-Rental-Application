package com.cg.onlineflatrental.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;   
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Tenant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tenantId;
	
	private int age;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "houseNo", unique = true)
	private FlatAddress taddress;
	
	public Tenant(int tenantId, int age, FlatAddress taddress) {
		super();
		this.tenantId = tenantId;
		this.age = age;
		this.taddress = taddress;
	}
	
	public Tenant() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/** 
	 * @return FlatAddress
	 */
	public FlatAddress getTaddress() {
		return taddress;
	}
	
	/** 
	 * @param taddress
	 */
	public void setTaddress(FlatAddress taddress) {
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
	 * @return String
	 */
	@Override
	public String toString() {
		return "Tenant [tenantId=" + tenantId + ", age=" + age + ", taddress=" + taddress
				+ "]";
	}
	
}
