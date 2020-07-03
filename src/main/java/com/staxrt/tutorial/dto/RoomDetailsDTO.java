package com.staxrt.tutorial.dto;

public class RoomDetailsDTO {
	
	
	

    private long id;
    

    private String floorid;
    


    private String roomnumber;
    


    private String roomstatus;
    

    private String roomtype;

    
    
    

	public RoomDetailsDTO() {
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


	public String getRoomnumber() {
		return roomnumber;
	}


	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}


	public String getRoomstatus() {
		return roomstatus;
	}


	public void setRoomstatus(String roomstatus) {
		this.roomstatus = roomstatus;
	}


	public String getRoomtype() {
		return roomtype;
	}


	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}


	public RoomDetailsDTO(long id, String floorid, String roomnumber, String roomstatus, String roomtype) {
		super();
		this.id = id;
		this.floorid = floorid;
		this.roomnumber = roomnumber;
		this.roomstatus = roomstatus;
		this.roomtype = roomtype;
	}


	@Override
	public String toString() {
		return "RoomDetailsDTO [id=" + id + ", floorid=" + floorid + ", roomnumber=" + roomnumber + ", roomstatus="
				+ roomstatus + ", roomtype=" + roomtype + "]";
	}



    
    
    
    
}
