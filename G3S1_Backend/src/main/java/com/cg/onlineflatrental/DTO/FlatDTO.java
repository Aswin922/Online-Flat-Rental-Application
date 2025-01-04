package com.cg.onlineflatrental.DTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class FlatDTO {
	private int flatId;
	@NotNull(message = "Please provide a valid cost")
	@Min(value = 1, message = "Cost should be more than 0")
    private float cost;
	
    private FlatAddressDTO flatAddress;
	@NotNull(message = "Flat availability is mandatory")
    private String availability;

    private LandlordDTO landlordId;

    public FlatDTO() {
    	super();
    }

    public FlatDTO(int flatId, float cost, FlatAddressDTO flatAddress, String availability) {
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
     * @param cost
     */
    public void setCost(float cost) {
        this.cost = cost;
    }

    
    /** 
     * @return FlatAddressDTO
     */
    public FlatAddressDTO getFlatAddress() {
        return flatAddress;
    }

    
    /** 
     * @param flatAddress
     */
    public void setFlatAddress(FlatAddressDTO flatAddress) {
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
        return "FlatDTO{" +
                "flatId=" + flatId +
                ", cost=" + cost +
                ", flatAddress=" + flatAddress +
                ", availability='" + availability + '\'' +
                '}';
    }
}

