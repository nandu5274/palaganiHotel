package com.staxrt.tutorial.service;

import static com.staxrt.tutorial.constants.RoomBookingConstants.CHECK_IN;
import static com.staxrt.tutorial.constants.RoomBookingConstants.ERROR;
import static com.staxrt.tutorial.constants.RoomBookingConstants.FAILED;
import static com.staxrt.tutorial.constants.RoomBookingConstants.PAYMENT_STATUS_NOT_PAID;
import static com.staxrt.tutorial.constants.RoomBookingConstants.SUCESS;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.staxrt.tutorial.dto.CheckinRoomDetailsResponseDTO;
import com.staxrt.tutorial.dto.RoomBokingResponseDTO;
import com.staxrt.tutorial.dto.RoomDetailsDTO;
import com.staxrt.tutorial.dto.RoomstatsDTO;
import com.staxrt.tutorial.dto.customerOrderDTO;
import com.staxrt.tutorial.exception.ResourceNotFoundException;
import com.staxrt.tutorial.model.customerdetails;
import com.staxrt.tutorial.model.roombookingdetails;
import com.staxrt.tutorial.model.roomdetails;
import com.staxrt.tutorial.model.userdetails;
import com.staxrt.tutorial.repository.CustomerDetailsRepository;
import com.staxrt.tutorial.repository.RoomBookingDetailsRepository;
import com.staxrt.tutorial.repository.RoomDetailsRepository;
import com.staxrt.tutorial.repository.UserDetailsRepository;


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
@Autowired
EntityManager em;

	

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
					
					roombookingdetails.setCostomerid((int)customerdetailsResponse.getId());
					roombookingdetails.setCheckintime(date);
					roombookingdetails.setLoginby(userdetails);
					roombookingdetails.setRoomstatus(CHECK_IN);
					roombookingdetails.setRoomid(roomdetails);
					roombookingdetails.setPaymentstatus(PAYMENT_STATUS_NOT_PAID);
					roombookingdetails.setNoofpersons(customerOrderDTO.getNoofpersons());
					roombookingdetails.setExtrabeds(customerOrderDTO.getExtrabeds());
					roombookingdetails.setPaidamount(customerOrderDTO.getPaidamount());
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




	public List<RoomDetailsDTO> getRoomDeatils() {
	
		
		List<roomdetails> roomdetails =  new ArrayList<>();
		 List<RoomDetailsDTO> roomdetailsDtoList  =  new ArrayList<>(); 
		roomdetails	= roomDetailsRepository.findAll();
		
		for( roomdetails roomdetail : roomdetails)
		{
			RoomDetailsDTO	roomdetailsDto = new RoomDetailsDTO();
			roomdetailsDto.setFloorid(roomdetail.getFloorid());
			roomdetailsDto.setId(roomdetail.getId());
			roomdetailsDto.setRoomnumber(roomdetail.getRoomnumber());
			roomdetailsDto.setRoomstatus(roomdetail.getRoomstatus());
			roomdetailsDto.setRoomtype(roomdetail.getRoomtype());
	
			roomdetailsDtoList.add(roomdetailsDto);
			
		}
		
		
		return roomdetailsDtoList;
		
		
		
	}




	public RoomBokingResponseDTO updateBooking(@Valid customerOrderDTO customerOrderDTO) {
		RoomBokingResponseDTO roomBokingResponseDTO = new RoomBokingResponseDTO();
		try{
			
		roombookingdetails roombookingdetails = roomBookingDetailsRepository.findById(Long.valueOf(customerOrderDTO.getId()))
				 .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + customerOrderDTO.getRoomid()));
		
		
		
		
		customerdetails	customerdetails = 	customerDetailsRepository.findById(Long.valueOf(roombookingdetails.getCostomerid()))
		 .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + customerOrderDTO.getRoomid()));
		
		
		customerdetails.setPhotocopy(customerOrderDTO.getPhotocopy());
		
		customerdetails.setAdhacopy(customerOrderDTO.getAdhacopy());
		
		customerDetailsRepository.save(customerdetails);
		roombookingdetails.getRoomid().setRoomstatus(CHECK_IN);
		roomDetailsRepository.save(roombookingdetails.getRoomid());
		roomBokingResponseDTO.setBookingid(roombookingdetails.getBookingid());
		roomBokingResponseDTO.setUsername(customerdetails.getFirstname() + customerdetails.getLastname());
		roomBokingResponseDTO.setMessage("Booking id updated with latest details");
		roomBokingResponseDTO.setStatus(SUCESS);
		}catch(Exception e )
		{
			
			System.out.println(e.getMessage()); 
			roomBokingResponseDTO.setMessage("ERROR OCCURED . PLEASE TRY AGAIN");
			roomBokingResponseDTO.setStatus(FAILED);
			
		}
		
		return roomBokingResponseDTO;
	}




	public List<CheckinRoomDetailsResponseDTO> getcheckinRooms() {
	
		
		 List<CheckinRoomDetailsResponseDTO> checkinRoomDetailsResponseDTOList = new ArrayList<>();
	    String nativeQuery = "select r.bookingid ,c.firstname ,c.lastname,room.roomnumber,r.checkintime "
	    		+ ",r.extrabeds ,r.noofpersons,r.paidamount from b1kr4swwths1vyla9typ.roombookingdetails r"
	    		+ " join b1kr4swwths1vyla9typ.customerdetails c on c.id = r.costomerid join "
	    		+ "b1kr4swwths1vyla9typ.roomdetails room on room.id = r.roomid where r.roomstatus = 'CHECK_IN'  "
	    		+ "ORDER  by  r.bookingid desc";   
	    Query query = em.createNativeQuery(nativeQuery);

	    List<Object[]> list = query.getResultList();
long count = 1;
	    for(Object[] q1 : list){

	    	CheckinRoomDetailsResponseDTO checkinRoomDetailsResponseDTO = new CheckinRoomDetailsResponseDTO();
	    	
	    			checkinRoomDetailsResponseDTO.setBookingid(Long.parseLong(q1[0].toString()));
	    			checkinRoomDetailsResponseDTO.setFirstname(q1[1].toString());
	    			checkinRoomDetailsResponseDTO.setLastname(q1[2].toString());
	    			checkinRoomDetailsResponseDTO.setRoomnumber(q1[3].toString());
	    			checkinRoomDetailsResponseDTO.setCheckintime(q1[4].toString());
	    			checkinRoomDetailsResponseDTO.setExtrabeds(Long.parseLong(q1[5].toString()));
	    			checkinRoomDetailsResponseDTO.setNofpersons(Long.parseLong(q1[6].toString()));
	    			checkinRoomDetailsResponseDTO.setPaidamount(Long.parseLong(q1[7].toString()));
	    			checkinRoomDetailsResponseDTO.setIndexid(count);
	    			checkinRoomDetailsResponseDTOList.add(checkinRoomDetailsResponseDTO);
	    			count++;
	    			
	    }
		
		
		
		return checkinRoomDetailsResponseDTOList;
	}




	public RoomstatsDTO getroomstats() {
		
		
		RoomstatsDTO roomstatsDTO = new RoomstatsDTO();
		
		 String nativeQuery = " select roomstatus , count(*) from b1kr4swwths1vyla9typ.roomdetails r group by  roomstatus ";
		    	
		    Query query = em.createNativeQuery(nativeQuery);

		    List<Object[]> list = query.getResultList();
	
		    
		    roomstatsDTO.setAvailablestatus("AVAILABLE");
		    roomstatsDTO.setAvailablecount("0");
		    
		    
		    roomstatsDTO.setCheckinstatus("CHECK_IN");
		    roomstatsDTO.setCheckincount("0");
		
		    
		    roomstatsDTO.setCleancount("0");
		    roomstatsDTO.setCleanstatus("CLEAN");
		    
		    for(Object[] q1 : list){
		    	
		    	
		    	if(q1[0].toString().equalsIgnoreCase("AVAILABLE"))
		    	{
		    		
		    		  roomstatsDTO.setAvailablecount(q1[1].toString());
		    	}
		    	else if(q1[0].toString().equalsIgnoreCase("CHECK_IN"))
		    	{
		    		
		    		
		    		  roomstatsDTO.setCheckincount(q1[1].toString());
		    	}
		    	else if(q1[0].toString().equalsIgnoreCase("CLEAN"))
		    	{
		    		 roomstatsDTO.setCleancount(q1[1].toString());
		    	}
		    		
		    	
		    }
		
		
		return roomstatsDTO;
	}
	
	
	
	

}
