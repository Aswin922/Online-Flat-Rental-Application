package com.cg.onlineflatrental.entity;
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.PastOrPresent;
//import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class FlatBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingNo;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "flatId", unique = true)
	private Flat flat;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "tenantId", unique = true)
	private Tenant tenantId;
	
	private LocalDate bookingFromDate;
	
	private LocalDate bookingToDate;
	
	public FlatBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FlatBooking(Integer bookingNo, Flat flat, Tenant tenantId, LocalDate bookingFromDate, LocalDate bookingToDate) {
		super();
		this.bookingNo = bookingNo;
		this.flat = flat;
		this.tenantId = tenantId;
		this.bookingFromDate = bookingFromDate;
		this.bookingToDate = bookingToDate;
	}

	
	/** 
	 * @return Integer
	 */
	public Integer getBookingNo() {
		return bookingNo;
	}
	
	/** 
	 * @param bookingNo
	 */
	public void setBookingNo(Integer bookingNo) {
		this.bookingNo = bookingNo;
	}
	
	/** 
	 * @return Flat
	 */
	public Flat getFlat() {
		return flat;
	}
	
	/** 
	 * @param flat
	 */
	public void setFlat(Flat flat) {
		this.flat = flat;
	}
	
	/** 
	 * @return Tenant
	 */
	public Tenant getTenantId() {
		return tenantId;
	}
	
	/** 
	 * @param tenantId
	 */
	public void setTenantId(Tenant tenantId) {
		this.tenantId = tenantId;
	}
	
	/** 
	 * @return LocalDate
	 */
	public LocalDate getBookingToDate() {
		return bookingToDate;
	}
	
	/** 
	 * @param bookingToDate
	 */
	public void setBookingToDate(LocalDate bookingToDate) {
		this.bookingToDate = bookingToDate;
	}

	
	/** 
	 * @return LocalDate
	 */
	public LocalDate getBookingFromDate() {
		return bookingFromDate;
	}

	
	/** 
	 * @param bookingFromDate
	 */
	public void setBookingFromDate(LocalDate bookingFromDate) {
		this.bookingFromDate = bookingFromDate;
	}

	
	/** 
	 * @return String
	 */
	@Override
	public String toString() {
		return "FlatBooking{" +
				"bookingNo=" + bookingNo +
				", flat=" + flat +
				", tenantId=" + tenantId +
				", bookingFromDate=" + bookingFromDate +
				", bookingToDate=" + bookingToDate +
				'}';
	}
}

