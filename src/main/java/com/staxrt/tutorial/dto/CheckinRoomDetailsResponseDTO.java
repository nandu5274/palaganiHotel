package com.staxrt.tutorial.dto;

public class CheckinRoomDetailsResponseDTO {

	
	private long bookingid;
	private String firstname;
	private String lastname;
	private String roomnumber;
	private String checkintime;
	private long extrabeds;
	private long nofpersons;
	private long paidamount;
	private long indexid;
	
	public CheckinRoomDetailsResponseDTO() {
		super();
	}

	public long getBookingid() {
		return bookingid;
	}

	public void setBookingid(long bookingid) {
		this.bookingid = bookingid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public long getExtrabeds() {
		return extrabeds;
	}

	public void setExtrabeds(long extrabeds) {
		this.extrabeds = extrabeds;
	}

	public long getNofpersons() {
		return nofpersons;
	}

	public void setNofpersons(long nofpersons) {
		this.nofpersons = nofpersons;
	}

	public long getPaidamount() {
		return paidamount;
	}

	public void setPaidamount(long paidamount) {
		this.paidamount = paidamount;
	}
	
	

	public long getIndexid() {
		return indexid;
	}

	public void setIndexid(long indexid) {
		this.indexid = indexid;
	}

	public CheckinRoomDetailsResponseDTO(long bookingid, String firstname, String lastname, String roomnumber,
			String checkintime, long extrabeds, long nofpersons, long paidamount) {
		super();
		this.bookingid = bookingid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.roomnumber = roomnumber;
		this.checkintime = checkintime;
		this.extrabeds = extrabeds;
		this.nofpersons = nofpersons;
		this.paidamount = paidamount;
	}

	
	
	@Override
	public String toString() {
		return "CheckinRoomDetailsResponseDTO [bookingid=" + bookingid + ", firstname=" + firstname + ", lastname="
				+ lastname + ", roomnumber=" + roomnumber + ", checkintime=" + checkintime + ", extrabeds=" + extrabeds
				+ ", nofpersons=" + nofpersons + ", paidamount=" + paidamount + "]";
	}
	
	
	
	
	
}
