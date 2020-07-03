package com.staxrt.tutorial.model;

import java.io.Serializable;
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

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "roomdetails")
@EntityListeners(AuditingEntityListener.class)
public class roomdetails   implements Serializable  {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 2808392199424731898L;


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    

    @Column(name = "floorid")
    private String floorid;
    

    @Column(name = "roomnumber")
    private String roomnumber;
    

    @Column(name = "roomstatus")
    private String roomstatus;
    
    @Column(name = "roomtype")
    private String roomtype;


    
    
	public roomdetails() {
		super();
	}





	public long getId() {
		return id;
	}





	public void setId(long id) {
		this.id = id;
	}





	public String getFloorid() {
		return floorid;
	}



	public void setFloorid(String floorid) {
		this.floorid = floorid;
	}



	public String getRoomstatus() {
		return roomstatus;
	}



	public void setRoomstatus(String roomstatus) {
		this.roomstatus = roomstatus;
	}



	public String getRoomnumber() {
		return roomnumber;
	}



	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}





	public String getRoomtype() {
		return roomtype;
	}





	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}





	public roomdetails(long id, String floorid, String roomnumber, String roomstatus, String roomtype) {
		super();
		this.id = id;
		this.floorid = floorid;
		this.roomnumber = roomnumber;
		this.roomstatus = roomstatus;
		this.roomtype = roomtype;
	}





	@Override
	public String toString() {
		return "roomdetails [id=" + id + ", floorid=" + floorid + ", roomnumber=" + roomnumber + ", roomstatus="
				+ roomstatus + ", roomtype=" + roomtype + "]";
	}



	
    
    
	
	
}
