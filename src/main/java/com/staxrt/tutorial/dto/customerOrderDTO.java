package com.staxrt.tutorial.dto;

import java.util.Date;

import com.staxrt.tutorial.model.roombookingdetails;

public class customerOrderDTO {
	
	
	

		private int id ;
	

		private String	emailid ;
	    
	
		private String firstname;
	    
	
		private String lastname;
	    
	    
	
		private String city ;
	    
	
		private String country ;
	    

		private String postalcode ;
	    
	 
		private String adharnumber ;
	  
		private String mobilenumber ;
	    
	
		private String purposeofvist ;

		private String manditoryfields ;

		private String photocopy ;
	
		private String adhacopy ;
	    
	
		private Date createddate;

		private String address;
		
		
		private long roomid;
		
		private String roomstatus;
		
		
		private String loginby;

		public customerOrderDTO() {
			super();
		}






		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}




		public String getEmailid() {
			return emailid;
		}


		public void setEmailid(String emailid) {
			this.emailid = emailid;
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





		public String getAddress() {
			return address;
		}



		public void setAddress(String address) {
			this.address = address;
		}



		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public String getCountry() {
			return country;
		}


		public void setCountry(String country) {
			this.country = country;
		}


		public String getPostalcode() {
			return postalcode;
		}


		public void setPostalcode(String postalcode) {
			this.postalcode = postalcode;
		}


		public String getAdharnumber() {
			return adharnumber;
		}


		public void setAdharnumber(String adharnumber) {
			this.adharnumber = adharnumber;
		}


		public String getMobilenumber() {
			return mobilenumber;
		}


		public void setMobilenumber(String mobilenumber) {
			this.mobilenumber = mobilenumber;
		}


		public String getPurposeofvist() {
			return purposeofvist;
		}


		public void setPurposeofvist(String purposeofvist) {
			this.purposeofvist = purposeofvist;
		}


		public String getManditoryfields() {
			return manditoryfields;
		}


		public void setManditoryfields(String manditoryfields) {
			this.manditoryfields = manditoryfields;
		}


		public String getPhotocopy() {
			return photocopy;
		}


		public void setPhotocopy(String photocopy) {
			this.photocopy = photocopy;
		}


		public String getAdhacopy() {
			return adhacopy;
		}


		public void setAdhacopy(String adhacopy) {
			this.adhacopy = adhacopy;
		}


		public Date getCreateddate() {
			return createddate;
		}


		public void setCreateddate(Date createddate) {
			this.createddate = createddate;
		}









		public long getRoomid() {
			return roomid;
		}






		public void setRoomid(long roomid) {
			this.roomid = roomid;
		}






		public String getRoomstatus() {
			return roomstatus;
		}






		public void setRoomstatus(String roomstatus) {
			this.roomstatus = roomstatus;
		}






		public String getLoginby() {
			return loginby;
		}






		public void setLoginby(String loginby) {
			this.loginby = loginby;
		}




}
