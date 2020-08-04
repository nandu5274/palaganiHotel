package com.staxrt.tutorial.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "advancebookingdetails")
@EntityListeners(AuditingEntityListener.class)
public class AdvanceBookingDetails {

	
	

    /**
	 * 
	 */
	private static final long serialVersionUID = -4220286381300045074L;



	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id ;
    

    
    @Column(name = "customername")
	private String	customerName ;
    
    @Column(name = "checkindate")
	private Date checkinDate; 
        
    @Column(name = "advanceamount")
	private Long advanceAmount ;
    
    
    @Column(name = "remainingamount")
	private Long remainingAmount ;
    
    @Column(name = "returnedamount")
	private Long returnedAmount ;
    
    
    @Column(name = "numberofrooms")
	private Long numberOfRooms ;
    
    @Column(name = "numberofpersons")
  	private Long numberOfPersons ;
    
    @Column(name = "createddate")
	private Date createdDate; 
    
    
    @Column(name = "bookingids")
   	private String bookingIds; 
    
    @Column(name = "updateddate")
 	private Date updatedDate; 
    
    
    @Column(name = "status")
   	private String status;


    
    
    
    
	public AdvanceBookingDetails() {
		super();
	}


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


	public Date getCheckinDate() {
		return checkinDate;
	}


	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
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


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public String getBookingIds() {
		return bookingIds;
	}


	public void setBookingIds(String bookingIds) {
		this.bookingIds = bookingIds;
	}


	public Date getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}    
    
    
    

}
