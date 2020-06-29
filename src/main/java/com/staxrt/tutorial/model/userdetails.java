package com.staxrt.tutorial.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Entity
@Table(name = "userdetails")
@EntityListeners(AuditingEntityListener.class)
public class userdetails {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private long id ;
	 
	@Column(name = "username", nullable = false) 
	 private String username;
	
	@Column(name = "userpassword", nullable = false) 
	 private String userpassword;
	
	@Column(name = "accesstype", nullable = false) 
	 private String accesstype ;
	
	@Column(name = "mailid", nullable = false) 
	 private String mailid ;
	 
	@Column(name = "mobilenumber", nullable = false)  
	 private long mobilenumber;
	 
	@CreationTimestamp
	 @Temporal(TemporalType.DATE)
	 @Column(name = "createddate", nullable = false)
	 private Date createddate ;


	public userdetails() {
		super();
	}




	public userdetails(int id, String username, String userpassword, String accesstype, String mailid, int mobilenumber,
			Date createddate) {
		super();
		this.id = id;
		this.username = username;
		this.userpassword = userpassword;
		this.accesstype = accesstype;
		this.mailid = mailid;
		this.mobilenumber = mobilenumber;
		this.createddate = createddate;
	}










	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getUserpassword() {
		return userpassword;
	}




	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}




	public String getAccesstype() {
		return accesstype;
	}




	public void setAccesstype(String accesstype) {
		this.accesstype = accesstype;
	}




	public String getMailid() {
		return mailid;
	}




	public void setMailid(String mailid) {
		this.mailid = mailid;
	}





	public long getMobilenumber() {
		return mobilenumber;
	}




	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}




	public Date getCreateddate() {
		return createddate;
	}




	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}




	@Override
	public String toString() {
		return "userdetails [id=" + id + ", username=" + username + ", userpassword=" + userpassword + ", accesstype="
				+ accesstype + ", mailid=" + mailid + ", mobilenumber=" + mobilenumber + ", createddate=" + createddate
				+ "]";
	}
	
	
	
	
	
}
