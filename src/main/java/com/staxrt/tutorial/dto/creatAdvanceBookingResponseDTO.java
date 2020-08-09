package com.staxrt.tutorial.dto;

public class creatAdvanceBookingResponseDTO {
	
	private String advancecustomername;
	private String advancecheckindate;
	private long advancenoofperosons;
	private long advancenoofrooms;
	private long advanceadavanceamout;
	private String advancemobilenumber;
	private String advancepurposeofvist;
	private String advancepaymenttype;
	private String status;
	private String message;
	
	public creatAdvanceBookingResponseDTO() {
		super();
	}
	
	
	

	public creatAdvanceBookingResponseDTO(String advancecustomername, String advancecheckindate,
			long advancenoofperosons, long advancenoofrooms, long advanceadavanceamout, String advancemobilenumber,
			String advancepurposeofvist, String advancepaymenttype) {
		super();
		this.advancecustomername = advancecustomername;
		this.advancecheckindate = advancecheckindate;
		this.advancenoofperosons = advancenoofperosons;
		this.advancenoofrooms = advancenoofrooms;
		this.advanceadavanceamout = advanceadavanceamout;
		this.advancemobilenumber = advancemobilenumber;
		this.advancepurposeofvist = advancepurposeofvist;
		this.advancepaymenttype = advancepaymenttype;
	}




	public String getAdvancecustomername() {
		return advancecustomername;
	}

	public void setAdvancecustomername(String advancecustomername) {
		this.advancecustomername = advancecustomername;
	}

	public String getAdvancecheckindate() {
		return advancecheckindate;
	}

	public void setAdvancecheckindate(String advancecheckindate) {
		this.advancecheckindate = advancecheckindate;
	}

	public long getAdvancenoofperosons() {
		return advancenoofperosons;
	}

	public void setAdvancenoofperosons(long advancenoofperosons) {
		this.advancenoofperosons = advancenoofperosons;
	}

	public long getAdvancenoofrooms() {
		return advancenoofrooms;
	}

	public void setAdvancenoofrooms(long advancenoofrooms) {
		this.advancenoofrooms = advancenoofrooms;
	}

	public long getAdvanceadavanceamout() {
		return advanceadavanceamout;
	}

	public void setAdvanceadavanceamout(long advanceadavanceamout) {
		this.advanceadavanceamout = advanceadavanceamout;
	}

	public String getAdvancemobilenumber() {
		return advancemobilenumber;
	}

	public void setAdvancemobilenumber(String advancemobilenumber) {
		this.advancemobilenumber = advancemobilenumber;
	}

	public String getAdvancepurposeofvist() {
		return advancepurposeofvist;
	}

	public void setAdvancepurposeofvist(String advancepurposeofvist) {
		this.advancepurposeofvist = advancepurposeofvist;
	}

	public String getAdvancepaymenttype() {
		return advancepaymenttype;
	}

	public void setAdvancepaymenttype(String advancepaymenttype) {
		this.advancepaymenttype = advancepaymenttype;
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
