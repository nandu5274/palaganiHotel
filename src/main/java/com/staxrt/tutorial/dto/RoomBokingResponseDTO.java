package com.staxrt.tutorial.dto;

import javax.net.ssl.SSLEngineResult.Status;

public class RoomBokingResponseDTO {

	
	private String username;
	private long bookingid;
	private String status;
	private String message;
	
	
	
	
	
	public RoomBokingResponseDTO() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getBookingid() {
		return bookingid;
	}
	public void setBookingid(long bookingid) {
		this.bookingid = bookingid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
	
	
}
