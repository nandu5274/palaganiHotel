package com.staxrt.tutorial.dto;

public class InvoiceDetailsResponseDTO {

	private String billno;
	private String date;
	private String customername;
	private String adress;
	private String contactphone;
	private String contactemailid;
	private String roomno;
	private String checkin;
	private String checkout;
	private String status;
	
	public InvoiceDetailsResponseDTO(String billno, String date, String customername, String adress,
			String contactphone, String contactemailid, String roomno, String checkin, String checkout) {
		super();
		this.billno = billno;
		this.date = date;
		this.customername = customername;
		this.adress = adress;
		this.contactphone = contactphone;
		this.contactemailid = contactemailid;
		this.roomno = roomno;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	public InvoiceDetailsResponseDTO() {
		super();
	}
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getContactphone() {
		return contactphone;
	}
	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}
	public String getContactemailid() {
		return contactemailid;
	}
	public void setContactemailid(String contactemailid) {
		this.contactemailid = contactemailid;
	}
	public String getRoomno() {
		return roomno;
	}
	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	

	
	
	
}
