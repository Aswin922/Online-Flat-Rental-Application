package com.cg.onlineflatrental.DTO;

public class FlatAddressDTO {
	private int houseNo;
    private String street;
    private String city;
    private String state;
    private int pin;
    private String country;

    public FlatAddressDTO() {
    	super();
    }
    
    public FlatAddressDTO(int houseNo, String street, String city, String state, int pin, String country) {
        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
        this.state = state;
        this.pin = pin;
        this.country = country;
    }

    
    /** 
     * @return int
     */
    public int getHouseNo() {
        return houseNo;
    }

    
    /** 
     * @param houseNo
     */
    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    
    /** 
     * @return String
     */
    public String getStreet() {
        return street;
    }

    
    /** 
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    
    /** 
     * @return String
     */
    public String getCity() {
        return city;
    }

    
    /** 
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    
    /** 
     * @return String
     */
    public String getState() {
        return state;
    }

    
    /** 
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    
    /** 
     * @return int
     */
    public int getPin() {
        return pin;
    }

    
    /** 
     * @param pin
     */
    public void setPin(int pin) {
        this.pin = pin;
    }

    
    /** 
     * @return String
     */
    public String getCountry() {
        return country;
    }

    
    /** 
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "FlatAddressDTO{" +
                "houseNo=" + houseNo +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pin=" + pin +
                ", country='" + country + '\'' +
                '}';
    }
}
