package com.staxrt.tutorial.dto;

public class CheckoutRoomDetailsRequest {
	
	
	private long bookingid;
	
	private String paymentstatus;
	
	private String paidamounttype;
	
	private String roomstatus;
	
	private String requestedamount;
	
	private String paidamount;

	private String advanceamount;
	
	private boolean paymentholdpayfalg;
	
	private int loginby;
	
	
	public CheckoutRoomDetailsRequest() {
		super();
	}

	public CheckoutRoomDetailsRequest(long bookingid, String paymentstatus, String paidamounttype, String roomstatus,
			String requestedamount, String paidamount) {
		super();
		this.bookingid = bookingid;
		this.paymentstatus = paymentstatus;
		this.paidamounttype = paidamounttype;
		this.roomstatus = roomstatus;
		this.requestedamount = requestedamount;
		this.paidamount = paidamount;
	}

	public long getBookingid() {
		return bookingid;
	}

	public void setBookingid(long bookingid) {
		this.bookingid = bookingid;
	}

	public String getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public String getPaidamounttype() {
		return paidamounttype;
	}

	public void setPaidamounttype(String paidamounttype) {
		this.paidamounttype = paidamounttype;
	}

	public String getRoomstatus() {
		return roomstatus;
	}

	public void setRoomstatus(String roomstatus) {
		this.roomstatus = roomstatus;
	}

	public String getRequestedamount() {
		return requestedamount;
	}

	public void setRequestedamount(String requestedamount) {
		this.requestedamount = requestedamount;
	}

	public String getPaidamount() {
		return paidamount;
	}

	public void setPaidamount(String paidamount) {
		this.paidamount = paidamount;
	}

	public String getAdvanceamount() {
		return advanceamount;
	}

	public void setAdvanceamount(String advanceamount) {
		this.advanceamount = advanceamount;
	}

	public int getLoginby() {
		return loginby;
	}

	public void setLoginby(int loginby) {
		this.loginby = loginby;
	}

	public boolean isPaymentholdpayfalg() {
		return paymentholdpayfalg;
	}

	public void setPaymentholdpayfalg(boolean paymentholdpayfalg) {
		this.paymentholdpayfalg = paymentholdpayfalg;
	}
	
	
	

}
