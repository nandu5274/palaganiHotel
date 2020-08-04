package com.staxrt.tutorial.dto;

public class budgetdetailsDTO {

	
	

	
	private long bookingid;
	private String roomnumber;
	private String checkintime;
	private String roomstatus;
	private String checkouttime;
	private long adavnceamount;
	private long paidamount;
	private String paidamountyoe;
	private String adavanceamouttype;
	
	
	
	public budgetdetailsDTO() {
		super();
	}



	public budgetdetailsDTO(long bookingid, String roomnumber, String checkintime, String checkouttime,
			long adavnceamount, long paidamount, String paidamountyoe, String adavanceamouttype) {
		super();
		this.bookingid = bookingid;
		this.roomnumber = roomnumber;
		this.checkintime = checkintime;
		this.checkouttime = checkouttime;
		this.adavnceamount = adavnceamount;
		this.paidamount = paidamount;
		this.paidamountyoe = paidamountyoe;
		this.adavanceamouttype = adavanceamouttype;
	}



	public long getBookingid() {
		return bookingid;
	}



	public void setBookingid(long bookingid) {
		this.bookingid = bookingid;
	}



	public String getRoomnumber() {
		return roomnumber;
	}



	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}



	public String getCheckintime() {
		return checkintime;
	}



	public void setCheckintime(String checkintime) {
		this.checkintime = checkintime;
	}



	public String getCheckouttime() {
		return checkouttime;
	}



	public void setCheckouttime(String checkouttime) {
		this.checkouttime = checkouttime;
	}



	public long getAdavnceamount() {
		return adavnceamount;
	}



	public void setAdavnceamount(long adavnceamount) {
		this.adavnceamount = adavnceamount;
	}



	public long getPaidamount() {
		return paidamount;
	}



	public void setPaidamount(long paidamount) {
		this.paidamount = paidamount;
	}



	public String getPaidamountyoe() {
		return paidamountyoe;
	}



	public void setPaidamountyoe(String paidamountyoe) {
		this.paidamountyoe = paidamountyoe;
	}



	public String getAdavanceamouttype() {
		return adavanceamouttype;
	}



	public void setAdavanceamouttype(String adavanceamouttype) {
		this.adavanceamouttype = adavanceamouttype;
	}



	public String getRoomstatus() {
		return roomstatus;
	}



	public void setRoomstatus(String roomstatus) {
		this.roomstatus = roomstatus;
	}



	
	
	
}
