package com.cg.onlineflatrental.utility;

import java.time.LocalDateTime;

public class ErrorInfo {
	private String errorMessage;
	private Integer errorCode;
	private LocalDateTime timestamp;
	
	/** 
	 * @return String
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	
	/** 
	 * @param errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	/** 
	 * @return Integer
	 */
	public Integer getErrorCode() {
		return errorCode;
	}
	
	/** 
	 * @param errorCode
	 */
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	
	/** 
	 * @return LocalDateTime
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	/** 
	 * @param timestamp
	 */
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
}
