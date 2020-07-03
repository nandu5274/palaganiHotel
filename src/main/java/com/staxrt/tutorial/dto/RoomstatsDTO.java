package com.staxrt.tutorial.dto;

public class RoomstatsDTO {
	
	
	

    private String Availablestatus;
    private String Availablecount;
    private String checkinstatus;
    private String checkincount;
    private String cleanstatus;
    private String cleancount;
	public String getAvailablestatus() {
		return Availablestatus;
	}
	public void setAvailablestatus(String availablestatus) {
		Availablestatus = availablestatus;
	}
	public String getAvailablecount() {
		return Availablecount;
	}
	public void setAvailablecount(String availablecount) {
		Availablecount = availablecount;
	}
	public String getCheckinstatus() {
		return checkinstatus;
	}
	public void setCheckinstatus(String checkinstatus) {
		this.checkinstatus = checkinstatus;
	}
	public String getCheckincount() {
		return checkincount;
	}
	public void setCheckincount(String checkincount) {
		this.checkincount = checkincount;
	}
	public String getCleanstatus() {
		return cleanstatus;
	}
	public void setCleanstatus(String cleanstatus) {
		this.cleanstatus = cleanstatus;
	}
	public String getCleancount() {
		return cleancount;
	}
	public void setCleancount(String cleancount) {
		this.cleancount = cleancount;
	}
	public RoomstatsDTO(String availablestatus, String availablecount, String checkinstatus, String checkincount,
			String cleanstatus, String cleancount) {
		super();
		Availablestatus = availablestatus;
		Availablecount = availablecount;
		this.checkinstatus = checkinstatus;
		this.checkincount = checkincount;
		this.cleanstatus = cleanstatus;
		this.cleancount = cleancount;
	}
	public RoomstatsDTO() {
		super();
	}
	@Override
	public String toString() {
		return "RoomstatsDTO [Availablestatus=" + Availablestatus + ", Availablecount=" + Availablecount
				+ ", checkinstatus=" + checkinstatus + ", checkincount=" + checkincount + ", cleanstatus=" + cleanstatus
				+ ", cleancount=" + cleancount + "]";
	}
    
    
    
    
}
