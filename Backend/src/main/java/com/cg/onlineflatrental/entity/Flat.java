package com.cg.onlineflatrental.entity;

import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Flat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int flatId;
	
	private float cost;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="houseNo")
	private FlatAddress flatAddress;
	
	private String availability;
	
	public Flat() {
		super();
		// TODO Auto-generated constructor stub
	}
  
	public Flat(int flatId, float cost, FlatAddress flatAddress, String availability) {
		super();
		this.flatId = flatId;
		this.cost = cost;
		this.flatAddress = flatAddress;
		this.availability = availability;
	}
  
	
	/** 
	 * @return int
	 */
	public int getFlatId() {
		return flatId;
	}
	
	/** 
	 * @param flatId
	 */
	public void setFlatId(int flatId) {
		this.flatId = flatId;
	}
	
	/** 
	 * @return float
	 */
	public float getCost() {
		return cost;
	}
	
	/** 
	 * @param flatCost
	 */
	public void setCost(float flatCost) {
		this.cost = flatCost;
	}
	
	/** 
	 * @return FlatAddress
	 */
	public FlatAddress getFlatAddress() {
		return flatAddress;
	}
	
	/** 
	 * @param flatAddress
	 */
	public void setFlatAddress(FlatAddress flatAddress) {
		this.flatAddress = flatAddress;
	}
	
	/** 
	 * @return String
	 */
	public String getAvailability() {
		return availability;
	}
	
	/** 
	 * @param availability
	 */
	public void setAvailability(String availability) {
		this.availability = availability;
	}
  
	
	/** 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Flat [flatId=" + flatId + ", cost=" + cost + ", flatAddress=" + flatAddress
				+ ", flatAvailability=" + availability + "]";
	}
}
