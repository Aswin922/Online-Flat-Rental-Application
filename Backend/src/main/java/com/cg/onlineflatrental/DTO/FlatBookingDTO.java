package com.cg.onlineflatrental.DTO;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FlatBookingDTO {
	
	private Integer bookingNo;
	
	@NotNull
	private FlatDTO flat;
	
	@NotNull
	private TenantDTO tenantId;
	
	@NotNull(message = "Booking From Date is required")
	@FutureOrPresent
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate bookingFromDate;
	
	@NotNull(message = "Booking To Date is required")
	@Future
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate bookingToDate;
	
	public FlatBookingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FlatBookingDTO(Integer bookingNo, FlatDTO flat, TenantDTO tenantId, LocalDate bookingFromDate,
			LocalDate bookingToDate) {
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
	 * @return FlatDTO
	 */
	public FlatDTO getFlat() {
		return flat;
	}
	
	/** 
	 * @param flat
	 */
	public void setFlat(FlatDTO flat) {
		this.flat = flat;
	}
	
	/** 
	 * @return TenantDTO
	 */
	public TenantDTO getTenantId() {
		return tenantId;
	}
	
	/** 
	 * @param tenantId
	 */
	public void setTenantId(TenantDTO tenantId) {
		this.tenantId = tenantId;
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
	 * @return String
	 */
	@Override
	public String toString() {
		return "FlatBookingDTO [bookingNo=" + bookingNo + ", flat=" + flat + ", tenantId=" + tenantId
				+ ", bookingFromDate=" + bookingFromDate + ", bookingToDate=" + bookingToDate + "]";
	}
}

