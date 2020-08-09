package com.staxrt.tutorial.dto;

import java.util.Date;

public class getAdvanceBookingDetailDTO {
	
	

	private long id ;
    


	private String	customerName ;
  
	private String checkinDate; 
        

	private Long advanceAmount ;
    
    

	private Long remainingAmount ;
    
 
	private Long returnedAmount ;
    
    
   
	private Long numberOfRooms ;
    

  	private Long numberOfPersons ;
    

	private String createdDate; 
    
    
 
   	private String bookingIds; 

 	private String updatedDate; 
    
    

   	private String status;
    
  
    private String mobileNumber;
    
 
    private String purposeofvist;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public Long getAdvanceAmount() {
		return advanceAmount;
	}


	public void setAdvanceAmount(Long advanceAmount) {
		this.advanceAmount = advanceAmount;
	}


	public Long getRemainingAmount() {
		return remainingAmount;
	}


	public void setRemainingAmount(Long remainingAmount) {
		this.remainingAmount = remainingAmount;
	}


	public Long getReturnedAmount() {
		return returnedAmount;
	}


	public void setReturnedAmount(Long returnedAmount) {
		this.returnedAmount = returnedAmount;
	}


	public Long getNumberOfRooms() {
		return numberOfRooms;
	}


	public void setNumberOfRooms(Long numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}


	public Long getNumberOfPersons() {
		return numberOfPersons;
	}


	public void setNumberOfPersons(Long numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}


	public String getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}


	public String getBookingIds() {
		return bookingIds;
	}


	public void setBookingIds(String bookingIds) {
		this.bookingIds = bookingIds;
	}


	public String getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getPurposeofvist() {
		return purposeofvist;
	}


	public void setPurposeofvist(String purposeofvist) {
		this.purposeofvist = purposeofvist;
	}


	public getAdvanceBookingDetailDTO() {
		super();
	}


	public String getCheckinDate() {
		return checkinDate;
	}


	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}




}
