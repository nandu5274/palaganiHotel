package com.staxrt.tutorial.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "customerdetails")
@EntityListeners(AuditingEntityListener.class)
public class customerdetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
    

    
    @Column(name = "emailid")
	private String	emailid ;
    
    @Column(name = "firstname")
	private String firstname;
    
    @Column(name = "lastname")
	private String lastname;
    
    @Column(name = "Address")
	private String Address ;
    
    @Column(name = "city")
	private String city ;
    
    @Column(name = "country")
	private String country ;
    
    @Column(name = "postalcode")
	private String postalcode ;
    
    @Column(name = "adharnumber")
	private String adharnumber ;
    
    @Column(name = "mobilenumber")
	private String mobilenumber ;
    
    @Column(name = "purposeofvist")
	private String purposeofvist ;
    
    @Column(name = "manditoryfields")
	private String manditoryfields ;
    
    @Column(name = "photocopy")
	private String photocopy ;
    
    @Column(name = "adhacopy")
	private String adhacopy ;
    
    @Column(name = "createddate")
	private Date createddate;

    
    
    
	public customerdetails() {
		super();
	}





	public customerdetails(int id, String emailid, String firstname, String lastname, String address, String city,
			String country, String postalcode, String adharnumber, String mobilenumber, String purposeofvist,
			String manditoryfields, String photocopy, String adhacopy, Date createddate) {
		super();
		this.id = id;
		this.emailid = emailid;
		this.firstname = firstname;
		this.lastname = lastname;
		Address = address;
		this.city = city;
		this.country = country;
		this.postalcode = postalcode;
		this.adharnumber = adharnumber;
		this.mobilenumber = mobilenumber;
		this.purposeofvist = purposeofvist;
		this.manditoryfields = manditoryfields;
		this.photocopy = photocopy;
		this.adhacopy = adhacopy;
		this.createddate = createddate;
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
		return Address;
	}




	public void setAddress(String address) {
		Address = address;
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





	@Override
	public String toString() {
		return "customerdetails [id=" + id + ", emailid=" + emailid + ", firstname=" + firstname + ", lastname="
				+ lastname + ", Address=" + Address + ", city=" + city + ", country=" + country + ", postalcode="
				+ postalcode + ", adharnumber=" + adharnumber + ", mobilenumber=" + mobilenumber + ", purposeofvist="
				+ purposeofvist + ", manditoryfields=" + manditoryfields + ", photocopy=" + photocopy + ", adhacopy="
				+ adhacopy + ", createddate=" + createddate + "]";
	}





	
	
	
	
	
}
