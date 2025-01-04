package com.cg.onlineflatrental.entity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



@Entity
public class Landlord {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int landlordId;
	
	private String landlordName;
	
	private int landlordAge;
	
	@OneToMany(cascade=CascadeType.MERGE)
	@JoinColumn(name="landlordId")
	private List<Flat> flatList;
  
	public Landlord() {
		super();
	}
	
	public Landlord(int landlordId, @NotNull(message = "Landlord name is mandatory") String landlordName,
			@NotNull(message = "Landlord age is mandatory") @Min(value = 1, message = "Age should be more than 0") int landlordAge,
			List<Flat> flatList) {
		super();
		this.landlordId = landlordId;
		this.landlordName = landlordName;
		this.landlordAge = landlordAge;
		this.flatList = flatList;
	}

	
	/** 
	 * @return Integer
	 */
	public Integer getLandlordId() {
		return landlordId;
	}
	
	/** 
	 * @param landlordId
	 */
	public void setLandlordId(Integer landlordId) {
		this.landlordId = landlordId;
	}
	
	/** 
	 * @return String
	 */
	public String getLandlordName() {
		return landlordName;
	}
	
	/** 
	 * @param landlordName
	 */
	public void setLandlordName(String landlordName) {
		this.landlordName = landlordName;
	}
	
	/** 
	 * @return int
	 */
	public int getLandlordAge() {
		return landlordAge;
	}
	
	/** 
	 * @param landlordAge
	 */
	public void setLandlordAge(int landlordAge) {
		this.landlordAge = landlordAge;
	}
	
	/** 
	 * @return List<Flat>
	 */
	public List<Flat> getFlatList() { 
		  return flatList; 
	} 
	
	/** 
	 * @param flatList
	 */
	public void setFlatList(List<Flat> flatList) { 
		  this.flatList = flatList;
	}
	
	/** 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Landlord [landlordId=" + landlordId + ", landlordName=" + landlordName + ", landlordAge=" + landlordAge
				+ ", flatList=" + flatList + "]";
	}
}
