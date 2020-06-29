package com.staxrt.tutorial.service;

import java.util.Date;

import javax.net.ssl.SSLEngineResult.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.stereotype.Component;

import com.staxrt.tutorial.dto.RoomBokingResponseDTO;
import com.staxrt.tutorial.dto.customerOrderDTO;
import com.staxrt.tutorial.exception.ResourceNotFoundException;
import com.staxrt.tutorial.model.User;
import com.staxrt.tutorial.model.customerdetails;
import com.staxrt.tutorial.model.roombookingdetails;
import com.staxrt.tutorial.model.roomdetails;
import com.staxrt.tutorial.model.userdetails;
import com.staxrt.tutorial.repository.CustomerDetailsRepository;
import com.staxrt.tutorial.repository.RoomBookingDetailsRepository;
import com.staxrt.tutorial.repository.RoomDetailsRepository;
import com.staxrt.tutorial.repository.UserDetailsRepository;
import static com.staxrt.tutorial.constants.RoomBookingConstants.CHECK_IN;
import static com.staxrt.tutorial.constants.RoomBookingConstants.PAYMENT_STATUS_NOT_PAID;
import static com.staxrt.tutorial.constants.RoomBookingConstants.SUCESS;
import static com.staxrt.tutorial.constants.RoomBookingConstants.FAILED;
import static com.staxrt.tutorial.constants.RoomBookingConstants.ERROR;


@Component
public class interservice {
	

@Autowired
private CustomerDetailsRepository customerDetailsRepository;
@Autowired
private RoomBookingDetailsRepository roomBookingDetailsRepository;
@Autowired
private RoomDetailsRepository roomDetailsRepository;
@Autowired
private UserDetailsRepository userDetailsRepository;


	

	public RoomBokingResponseDTO createBooking(customerOrderDTO customerOrderDTO) {
		 RoomBokingResponseDTO roomBokingResponse = new RoomBokingResponseDTO();
		customerdetails customerdetails = new customerdetails();
		userdetails userdetails = new userdetails ();
		roomdetails roomdetails = new roomdetails();
		roombookingdetails roombookingdetails = new roombookingdetails();
		roombookingdetails roombookingResponse = new roombookingdetails();
		customerdetails customerdetailsResponse = new customerdetails();
		Date date = new Date();
		try{
		if(customerOrderDTO != null)
		{
			// saving customer data//
			customerdetails.setAddress(customerOrderDTO.getAddress());
			customerdetails.setAdhacopy(customerOrderDTO.getAdhacopy());
			customerdetails.setAdharnumber(customerOrderDTO.getAdharnumber());
			customerdetails.setCity(customerOrderDTO.getCity());
			customerdetails.setCountry(customerOrderDTO.getCountry());
			customerdetails.setCreateddate(date);
			customerdetails.setEmailid(customerOrderDTO.getEmailid());
			customerdetails.setFirstname(customerOrderDTO.getFirstname());
			customerdetails.setLastname(customerOrderDTO.getLastname());
			customerdetails.setManditoryfields(customerOrderDTO.getManditoryfields());
			customerdetails.setMobilenumber(customerOrderDTO.getMobilenumber());
			customerdetails.setPhotocopy(customerOrderDTO.getPhotocopy());
			customerdetails.setPostalcode(customerOrderDTO.getPostalcode());
			customerdetails.setPurposeofvist(customerOrderDTO.getPurposeofvist());
			
			customerdetailsResponse = customerDetailsRepository.save(customerdetails);
			
			System.out.println(customerdetailsResponse.toString());
			
			// saving customer data completed//
			
			
		//Linking room data //
			
			//get room domains by roomnumber//	
					roomdetails =
							roomDetailsRepository
			            .findById(customerOrderDTO.getRoomid())
			            .orElseThrow(() -> new ResourceNotFoundException("Room not found on :: " + customerOrderDTO.getRoomid()));
			
			//get room domains by roomnumber//	
					
				//get user details baesd on id //
					
					userdetails = userDetailsRepository
				            .findById(Long.valueOf(customerOrderDTO.getLoginby()))
				            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + customerOrderDTO.getRoomid()));
					//get user details baesd on id //
					
					// finally save in roombooking table //
					
					roombookingdetails.setCostomerid(customerdetailsResponse.getId());
					roombookingdetails.setCheckintime(date);
					roombookingdetails.setLoginby(userdetails);
					roombookingdetails.setRoomstatus(CHECK_IN);
					roombookingdetails.setRoomid(roomdetails);
					roombookingdetails.setPaymentstatus(PAYMENT_STATUS_NOT_PAID);
					roombookingResponse		= roomBookingDetailsRepository.save(roombookingdetails);
			System.out.println(roombookingResponse);
			roomBokingResponse.setBookingid(roombookingResponse.getBookingid());
			roomBokingResponse.setStatus(SUCESS);
			roomBokingResponse.setUsername(customerdetailsResponse.getFirstname() + customerdetailsResponse.getLastname());
			roomBokingResponse.setMessage("reservation sucessful");
		}
		else
		{
			roomBokingResponse.setBookingid(0);
			roomBokingResponse.setStatus(FAILED);
			roomBokingResponse.setUsername("");
			roomBokingResponse.setMessage("nodata found");
		}
		}
		catch(Exception e)
		{
			roomBokingResponse.setBookingid(0);
			roomBokingResponse.setStatus(ERROR);
			roomBokingResponse.setUsername("");
			roomBokingResponse.setMessage("error occured while porocessing");
			System.out.println(e.getLocalizedMessage());
		}
		// TODO Auto-generated method stub
		return roomBokingResponse;
	}
	
	
	
	

}
