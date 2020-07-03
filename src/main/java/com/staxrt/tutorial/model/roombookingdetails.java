package com.staxrt.tutorial.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.staxrt.tutorial.model.userdetails;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "roombookingdetails")
@EntityListeners(AuditingEntityListener.class)
public class roombookingdetails implements Serializable {
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 4861965655911299299L;



	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long bookingid ;
	
    

    @ManyToOne (targetEntity= roomdetails.class,cascade=CascadeType.ALL)
    @JoinColumn(name="roomid")
	private roomdetails roomid ;
	
    @Column(name = "costomerid")
	private int costomerid;
	
	
    @Column(name = "roomstatus")
	private String roomstatus ;
	
    @Column(name = "checkintime")
	private Date checkintime ;
	
    @Column(name = "checkouttime")
	private Date checkouttime ;
	
	
    @Column(name = "paymentstatus")
	private  String paymentstatus ;
	
	
    @Column(name = "requestedamount")
	private int requestedamount;
	
    @Column(name = "paidamount")
	private int paidamount ;
	
	
    @Column(name = "noofpersons")
	private int noofpersons ;
	
    @Column(name = "extrabeds")
	private int extrabeds ;
    
    @ManyToOne (targetEntity= userdetails.class,cascade=CascadeType.ALL)
    @JoinColumn(name="loginby")
	private userdetails loginby ;

    
    
    
    
	public roombookingdetails() {
		super();
	}

	public roombookingdetails(long bookingid, roomdetails roomid, int costomerid, String roomstatus, Date checkintime,
			Date checkouttime, String paymentstatus, int requestedamount, int paidamount, userdetails loginby) {
		super();
		this.bookingid = bookingid;
		this.roomid = roomid;
		this.costomerid = costomerid;
		this.roomstatus = roomstatus;
		this.checkintime = checkintime;
		this.checkouttime = checkouttime;
		this.paymentstatus = paymentstatus;
		this.requestedamount = requestedamount;
		this.paidamount = paidamount;
		this.loginby = loginby;
	}

	public long getBookingid() {
		return bookingid;
	}

	public void setBookingid(long bookingid) {
		this.bookingid = bookingid;
	}

	public roomdetails getRoomid() {
		return roomid;
	}

	public void setRoomid(roomdetails roomid) {
		this.roomid = roomid;
	}

	public int getCostomerid() {
		return costomerid;
	}

	public void setCostomerid(int costomerid) {
		this.costomerid = costomerid;
	}

	public String getRoomstatus() {
		return roomstatus;
	}

	public void setRoomstatus(String roomstatus) {
		this.roomstatus = roomstatus;
	}

	public Date getCheckintime() {
		return checkintime;
	}

	public void setCheckintime(Date checkintime) {
		this.checkintime = checkintime;
	}

	public Date getCheckouttime() {
		return checkouttime;
	}

	public void setCheckouttime(Date checkouttime) {
		this.checkouttime = checkouttime;
	}

	public String getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public int getRequestedamount() {
		return requestedamount;
	}

	public void setRequestedamount(int requestedamount) {
		this.requestedamount = requestedamount;
	}

	public int getPaidamount() {
		return paidamount;
	}

	public void setPaidamount(int paidamount) {
		this.paidamount = paidamount;
	}
	

	public userdetails getLoginby() {
		return loginby;
	}

	public void setLoginby(userdetails loginby) {
		this.loginby = loginby;
	}
	
	

	public int getNoofpersons() {
		return noofpersons;
	}

	public void setNoofpersons(int noofpersons) {
		this.noofpersons = noofpersons;
	}

	public int getExtrabeds() {
		return extrabeds;
	}

	public void setExtrabeds(int extrabeds) {
		this.extrabeds = extrabeds;
	}

	public roombookingdetails(long bookingid, roomdetails roomid, int costomerid, String roomstatus, Date checkintime,
			Date checkouttime, String paymentstatus, int requestedamount, int paidamount, int noofpersons,
			int extrabeds, userdetails loginby) {
		super();
		this.bookingid = bookingid;
		this.roomid = roomid;
		this.costomerid = costomerid;
		this.roomstatus = roomstatus;
		this.checkintime = checkintime;
		this.checkouttime = checkouttime;
		this.paymentstatus = paymentstatus;
		this.requestedamount = requestedamount;
		this.paidamount = paidamount;
		this.noofpersons = noofpersons;
		this.extrabeds = extrabeds;
		this.loginby = loginby;
	}

	@Override
	public String toString() {
		return "roombookingdetails [bookingid=" + bookingid + ", roomid=" + roomid + ", costomerid=" + costomerid
				+ ", roomstatus=" + roomstatus + ", checkintime=" + checkintime + ", checkouttime=" + checkouttime
				+ ", paymentstatus=" + paymentstatus + ", requestedamount=" + requestedamount + ", paidamount="
				+ paidamount + ", noofpersons=" + noofpersons + ", extrabeds=" + extrabeds + ", loginby=" + loginby
				+ "]";
	}


	

}
