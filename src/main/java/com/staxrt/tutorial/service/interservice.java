package com.staxrt.tutorial.service;

import static com.staxrt.tutorial.constants.RoomBookingConstants.CHECK_IN;
import static com.staxrt.tutorial.constants.RoomBookingConstants.AVAILABLE;
import static com.staxrt.tutorial.constants.RoomBookingConstants.CHECK_OUT;
import static com.staxrt.tutorial.constants.RoomBookingConstants.ERROR;
import static com.staxrt.tutorial.constants.RoomBookingConstants.FAILED;
import static com.staxrt.tutorial.constants.RoomBookingConstants.PAYMENT_STATUS_NOT_PAID;
import static com.staxrt.tutorial.constants.RoomBookingConstants.SUCESS;
import static com.staxrt.tutorial.constants.RoomBookingConstants.PAYMENT_HOLD;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.staxrt.tutorial.dto.PaymentHoldRoomDetailsResponseDTO;
import com.staxrt.tutorial.dto.CheckinRoomDetailsResponseDTO;
import com.staxrt.tutorial.dto.CheckoutRoomDetailsRequest;
import com.staxrt.tutorial.dto.CheckoutRoomDetailsResponse;
import com.staxrt.tutorial.dto.InvoiceDetailsResponseDTO;
import com.staxrt.tutorial.dto.RoomBokingResponseDTO;
import com.staxrt.tutorial.dto.RoomDetailsDTO;
import com.staxrt.tutorial.dto.RoomstatsDTO;
import com.staxrt.tutorial.dto.budegetDEatilsResponse;
import com.staxrt.tutorial.dto.budgetdetailsDTO;
import com.staxrt.tutorial.dto.creatAdvanceBookingRequestDTO;
import com.staxrt.tutorial.dto.creatAdvanceBookingResponseDTO;
import com.staxrt.tutorial.dto.customerOrderDTO;
import com.staxrt.tutorial.dto.getAdvanceBookingDetailDTO;
import com.staxrt.tutorial.exception.ResourceNotFoundException;
import com.staxrt.tutorial.model.AdvanceBookingDetails;
import com.staxrt.tutorial.model.customerdetails;
import com.staxrt.tutorial.model.roombookingdetails;
import com.staxrt.tutorial.model.roomdetails;
import com.staxrt.tutorial.model.userdetails;
import com.staxrt.tutorial.repository.AdvanceBokkingDeatilsRepository;
import com.staxrt.tutorial.repository.CustomerDetailsRepository;
import com.staxrt.tutorial.repository.RoomBookingDetailsRepository;
import com.staxrt.tutorial.repository.RoomDetailsRepository;
import com.staxrt.tutorial.repository.UserDetailsRepository;
import static com.staxrt.tutorial.constants.RoomBookingConstants.PENDING;

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
private AdvanceBokkingDeatilsRepository advanceBokkingDeatilsRepository;


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
					roombookingdetails.setAdvanceamount(customerOrderDTO.getAdvanceamount());
					roombookingdetails.setAdvanceamounttype(customerOrderDTO.getAdvanceamounttype());
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
	
		try{
		
	    String nativeQuery = "select r.bookingid ,c.firstname ,c.lastname,room.roomnumber,r.checkintime "
	    		+ ",r.extrabeds ,r.noofpersons,r.advanceamount from b1kr4swwths1vyla9typ.roombookingdetails r"
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
	    			
	    			checkinRoomDetailsResponseDTO.setCheckintime(formatDateToString(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S").parse(q1[4].toString())  ,"dd MMM yyyy hh:mm:ss a","CST"));
	    			checkinRoomDetailsResponseDTO.setExtrabeds(Long.parseLong(q1[5].toString()));
	    			checkinRoomDetailsResponseDTO.setNofpersons(Long.parseLong(q1[6].toString()));
	    			checkinRoomDetailsResponseDTO.setPaidamount(Long.parseLong(q1[7].toString()));
	    			checkinRoomDetailsResponseDTO.setIndexid(count);
	    			checkinRoomDetailsResponseDTOList.add(checkinRoomDetailsResponseDTO);
	    			count++;
	    			
	    }
		
		}
		catch(Exception e)
		{
			
			System.out.println(e.getMessage());
		}
		
		return checkinRoomDetailsResponseDTOList;
	}

	
	public List<PaymentHoldRoomDetailsResponseDTO> getpaymentHoldRooms() {

		List<PaymentHoldRoomDetailsResponseDTO> checkinRoomDetailsResponseDTOList = new ArrayList<>();
	
		try{
		
	    String nativeQuery = "select r.bookingid ,c.firstname ,c.lastname,room.roomnumber,r.checkintime,r.checkouttime  "
	    		+ ",r.extrabeds ,r.noofpersons,r.advanceamount from b1kr4swwths1vyla9typ.roombookingdetails r"
	    		+ " join b1kr4swwths1vyla9typ.customerdetails c on c.id = r.costomerid join "
	    		+ "b1kr4swwths1vyla9typ.roomdetails room on room.id = r.roomid where r.roomstatus = 'PAYMENT_HOLD'  "
	    		+ "ORDER  by  r.bookingid desc";   
	    Query query = em.createNativeQuery(nativeQuery);

	    List<Object[]> list = query.getResultList();
long count = 1;
	    for(Object[] q1 : list){

	    	PaymentHoldRoomDetailsResponseDTO checkinRoomDetailsResponseDTO = new PaymentHoldRoomDetailsResponseDTO();
	    	
	    			checkinRoomDetailsResponseDTO.setBookingid(Long.parseLong(q1[0].toString()));
	    			checkinRoomDetailsResponseDTO.setFirstname(q1[1].toString());
	    			checkinRoomDetailsResponseDTO.setLastname(q1[2].toString());
	    			checkinRoomDetailsResponseDTO.setRoomnumber(q1[3].toString());
	    			
	    			checkinRoomDetailsResponseDTO.setCheckintime(formatDateToString(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S").parse(q1[4].toString())  ,"dd MMM yyyy hh:mm:ss a","CST"));
	    			checkinRoomDetailsResponseDTO.setCheckouttime(formatDateToString(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S").parse(q1[5].toString())  ,"dd MMM yyyy hh:mm:ss a","CST"));
	    			checkinRoomDetailsResponseDTO.setExtrabeds(Long.parseLong(q1[6].toString()));
	    			checkinRoomDetailsResponseDTO.setNofpersons(Long.parseLong(q1[7].toString()));
	    			checkinRoomDetailsResponseDTO.setPaidamount(Long.parseLong(q1[8].toString()));
	    			checkinRoomDetailsResponseDTO.setIndexid(count);
	    			checkinRoomDetailsResponseDTOList.add(checkinRoomDetailsResponseDTO);
	    			count++;
	    			
	    }
		
		}
		catch(Exception e)
		{
			
			System.out.println(e.getMessage());
		}
		
		return checkinRoomDetailsResponseDTOList;
	}

	
	
	
	
	
	
	
	public static String formatDateToString(Date date, String format,
			String timeZone) {
		// null check
		if (date == null) return null;
		// create SimpleDateFormat object with input format
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		// default system timezone if passed null or empty
		if (timeZone == null || "".equalsIgnoreCase(timeZone.trim())) {
			timeZone = Calendar.getInstance().getTimeZone().getID();
		}
		// set timezone to SimpleDateFormat
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		// return Date in required format with timezone as String
		//return sdf.format(date);
		
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		formatter.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata")); // Or whatever IST is supposed to be
		return formatter.format(date);
	}
	
	public static String DateformatDateToString(Date date, String format,
			String timeZone) {
		// null check
		if (date == null) return null;
		// create SimpleDateFormat object with input format
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		// default system timezone if passed null or empty
		if (timeZone == null || "".equalsIgnoreCase(timeZone.trim())) {
			timeZone = Calendar.getInstance().getTimeZone().getID();
		}
		// set timezone to SimpleDateFormat
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		// return Date in required format with timezone as String
		//return sdf.format(date);
		
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		formatter.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata")); // Or whatever IST is supposed to be
		return formatter.format(date);
	}

	
	
	public static String getMonthFromDate(Date date, String format,
			String timeZone) {
		// null check
		if (date == null) return null;
		// create SimpleDateFormat object with input format
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		// default system timezone if passed null or empty
		if (timeZone == null || "".equalsIgnoreCase(timeZone.trim())) {
			timeZone = Calendar.getInstance().getTimeZone().getID();
		}
		// set timezone to SimpleDateFormat
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		// return Date in required format with timezone as String
		//return sdf.format(date);
		
		DateFormat formatter = new SimpleDateFormat("MM");
		formatter.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata")); // Or whatever IST is supposed to be
		return formatter.format(date);
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




	public CheckoutRoomDetailsResponse customercheckout(@Valid CheckoutRoomDetailsRequest checkoutRoomDTO) {
	
		
		// get roombooking detail domain//
		Date date = new Date();
		CheckoutRoomDetailsResponse checkoutRoomDetailsResponse = new CheckoutRoomDetailsResponse();
		try{
		roombookingdetails roombookingdetails = new roombookingdetails();
		roombookingdetails roombookingdetailsresponse = new roombookingdetails();
		
		roombookingdetails = roomBookingDetailsRepository.findById(checkoutRoomDTO.getBookingid())
				 .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + checkoutRoomDTO.getBookingid()));
		
		roombookingdetails.setRequestedamount(Integer.parseInt(checkoutRoomDTO.getRequestedamount()) + (int) roombookingdetails.getAdvanceamount());
		roombookingdetails.setCheckouttime(date);
		roombookingdetails.setPaidamount(Integer.parseInt(checkoutRoomDTO.getPaidamount()));
		roombookingdetails.setPaidamounttype(checkoutRoomDTO.getPaidamounttype());
		roombookingdetails.setPaymentstatus(checkoutRoomDTO.getPaymentstatus());
		roombookingdetails.setRoomstatus(CHECK_OUT);
		
		
		userdetails userdetail =new userdetails();
		userdetail = userDetailsRepository.findById((long)checkoutRoomDTO.getLoginby())
				 .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + checkoutRoomDTO.getBookingid()));
		roombookingdetails.setLoginby(userdetail);
		
		roomdetails roomdetails = new roomdetails();
		roomdetails = roombookingdetails.getRoomid();
		roomdetails.setRoomstatus(checkoutRoomDTO.getRoomstatus());
		roombookingdetails.setRoomid(roomdetails);
		
		roombookingdetailsresponse = roomBookingDetailsRepository.save(roombookingdetails);
		System.out.println("status = " + roombookingdetailsresponse.toString());
		
		checkoutRoomDetailsResponse.setBookingid(roombookingdetailsresponse.getBookingid());
		checkoutRoomDetailsResponse.setMessage("CHECK-OUT sucessfully");
		checkoutRoomDetailsResponse.setPaymentstatus(roombookingdetailsresponse.getPaymentstatus());
		checkoutRoomDetailsResponse.setStatus(SUCESS);
		
		
		}
		catch(Exception e)
		{
			

			checkoutRoomDetailsResponse.setBookingid(checkoutRoomDTO.getBookingid());
			checkoutRoomDetailsResponse.setMessage("CHECK-OUT failed");
			checkoutRoomDetailsResponse.setPaymentstatus("not paid");
			checkoutRoomDetailsResponse.setStatus(FAILED);
			
			
			System.out.println(e.getMessage());
		}
		
		return checkoutRoomDetailsResponse;
		
		}


public CheckoutRoomDetailsResponse customercheckoutPaymenthold(@Valid CheckoutRoomDetailsRequest checkoutRoomDTO) {
	
		
		// get roombooking detail domain//
		Date date = new Date();
		CheckoutRoomDetailsResponse checkoutRoomDetailsResponse = new CheckoutRoomDetailsResponse();
		try{
		roombookingdetails roombookingdetails = new roombookingdetails();
		roombookingdetails roombookingdetailsresponse = new roombookingdetails();
		
		roombookingdetails = roomBookingDetailsRepository.findById(checkoutRoomDTO.getBookingid())
				 .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + checkoutRoomDTO.getBookingid()));
		
		roombookingdetails.setRequestedamount(Integer.parseInt(checkoutRoomDTO.getRequestedamount()) + (int) roombookingdetails.getAdvanceamount());
		//roombookingdetails.setCheckouttime(date);
		roombookingdetails.setPaidamount(Integer.parseInt(checkoutRoomDTO.getPaidamount()));
		roombookingdetails.setPaidamounttype(checkoutRoomDTO.getPaidamounttype());
		roombookingdetails.setPaymentstatus(checkoutRoomDTO.getPaymentstatus());
		roombookingdetails.setRoomstatus(CHECK_OUT);
		
		
		userdetails userdetail =new userdetails();
		userdetail = userDetailsRepository.findById((long)checkoutRoomDTO.getLoginby())
				 .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + checkoutRoomDTO.getBookingid()));
		roombookingdetails.setLoginby(userdetail);
		
		roomdetails roomdetails = new roomdetails();
		roomdetails = roombookingdetails.getRoomid();
		//roomdetails.setRoomstatus(checkoutRoomDTO.getRoomstatus());
		roombookingdetails.setRoomid(roomdetails);
		
		roombookingdetailsresponse = roomBookingDetailsRepository.save(roombookingdetails);
		System.out.println("status = " + roombookingdetailsresponse.toString());
		
		checkoutRoomDetailsResponse.setBookingid(roombookingdetailsresponse.getBookingid());
		checkoutRoomDetailsResponse.setMessage("CHECK-OUT sucessfully");
		checkoutRoomDetailsResponse.setPaymentstatus(roombookingdetailsresponse.getPaymentstatus());
		checkoutRoomDetailsResponse.setStatus(SUCESS);
		
		
		}
		catch(Exception e)
		{
			

			checkoutRoomDetailsResponse.setBookingid(checkoutRoomDTO.getBookingid());
			checkoutRoomDetailsResponse.setMessage("CHECK-OUT failed");
			checkoutRoomDetailsResponse.setPaymentstatus("not paid");
			checkoutRoomDetailsResponse.setStatus(FAILED);
			
			
			System.out.println(e.getMessage());
		}
		
		return checkoutRoomDetailsResponse;
		
		}


	
	

	public CheckoutRoomDetailsResponse customercheckoutpaymenthold(@Valid CheckoutRoomDetailsRequest checkoutRoomDTO) {
	
		
		// get roombooking detail domain//
		Date date = new Date();
		CheckoutRoomDetailsResponse checkoutRoomDetailsResponse = new CheckoutRoomDetailsResponse();
		try{
		roombookingdetails roombookingdetails = new roombookingdetails();
		roombookingdetails roombookingdetailsresponse = new roombookingdetails();
		
		roombookingdetails = roomBookingDetailsRepository.findById(checkoutRoomDTO.getBookingid())
				 .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + checkoutRoomDTO.getBookingid()));
		
		roombookingdetails.setRequestedamount(Integer.parseInt(checkoutRoomDTO.getRequestedamount()) + (int) roombookingdetails.getAdvanceamount());
		roombookingdetails.setCheckouttime(date);
		roombookingdetails.setPaidamount(Integer.parseInt(checkoutRoomDTO.getPaidamount()));
		roombookingdetails.setPaidamounttype(checkoutRoomDTO.getPaidamounttype());
		roombookingdetails.setPaymentstatus(checkoutRoomDTO.getPaymentstatus());
		roombookingdetails.setRoomstatus(PAYMENT_HOLD);
		
		
		userdetails userdetail =new userdetails();
		userdetail = userDetailsRepository.findById((long)checkoutRoomDTO.getLoginby())
				 .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + checkoutRoomDTO.getBookingid()));
		roombookingdetails.setLoginby(userdetail);
		
		roomdetails roomdetails = new roomdetails();
		roomdetails = roombookingdetails.getRoomid();
		roomdetails.setRoomstatus(checkoutRoomDTO.getRoomstatus());
		roombookingdetails.setRoomid(roomdetails);
		
		roombookingdetailsresponse = roomBookingDetailsRepository.save(roombookingdetails);
		System.out.println("status = " + roombookingdetailsresponse.toString());
		
		checkoutRoomDetailsResponse.setBookingid(roombookingdetailsresponse.getBookingid());
		checkoutRoomDetailsResponse.setMessage("CHECK-OUT sucessfully");
		checkoutRoomDetailsResponse.setPaymentstatus(roombookingdetailsresponse.getPaymentstatus());
		checkoutRoomDetailsResponse.setStatus(SUCESS);
		
		
		}
		catch(Exception e)
		{
			

			checkoutRoomDetailsResponse.setBookingid(checkoutRoomDTO.getBookingid());
			checkoutRoomDetailsResponse.setMessage("CHECK-OUT failed");
			checkoutRoomDetailsResponse.setPaymentstatus("not paid");
			checkoutRoomDetailsResponse.setStatus(FAILED);
			
			
			System.out.println(e.getMessage());
		}
		
		return checkoutRoomDetailsResponse;
		
		}

	
	
	


	public InvoiceDetailsResponseDTO getInvoiceData(@Valid Long bookinid) {
	
		InvoiceDetailsResponseDTO invoiceDetailsResponseDTO = new InvoiceDetailsResponseDTO();
		try{
			Date date = new Date();
			roombookingdetails roombookingdetails = new roombookingdetails();
			roombookingdetails = roomBookingDetailsRepository.findById(bookinid)
					 .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + bookinid));
			
			
			customerdetails  customerdetails = new customerdetails();
			customerdetails = customerDetailsRepository.findById((long)roombookingdetails.getCostomerid())
					 .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + bookinid));
			
			
			invoiceDetailsResponseDTO.setAdress(customerdetails.getAddress()+"," + customerdetails.getCity()+","
													+customerdetails.getPostalcode()+ "," + customerdetails.getCountry());
			
			invoiceDetailsResponseDTO.setCheckin(formatDateToString(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S").parse(roombookingdetails.getCheckintime().toString())  ,"dd-MMM-yyyy hh:mm:ss a","CST"));
			
			invoiceDetailsResponseDTO.setCheckout(formatDateToString(date ,"dd-MMM-yyyy hh:mm:ss a","CST"));
			
			invoiceDetailsResponseDTO.setContactemailid(customerdetails.getEmailid());
			invoiceDetailsResponseDTO.setContactphone(customerdetails.getMobilenumber());
			invoiceDetailsResponseDTO.setBillno(String.valueOf(roombookingdetails.getBookingid()));
			invoiceDetailsResponseDTO.setRoomno(roombookingdetails.getRoomid().getRoomnumber());
			invoiceDetailsResponseDTO.setStatus(SUCESS);
			invoiceDetailsResponseDTO.setCustomername(customerdetails.getFirstname() + " " +customerdetails.getLastname() );
			invoiceDetailsResponseDTO.setDate(DateformatDateToString(date  ,"dd-MMM-yyyy","CST"));
			
			
			
			
		}catch(Exception e)
		{
			
			invoiceDetailsResponseDTO.setStatus(FAILED);
			System.out.println(e.getMessage());
		}
		
		
		
		
		return invoiceDetailsResponseDTO;
		
		
	}




	public RoomDetailsDTO makeroomavilable(@Valid Long roomid) {
		
		RoomDetailsDTO RoomDetailsDTO = new RoomDetailsDTO();
		try{
			
			roomdetails roomdetails =  new roomdetails();
			roomdetails roomdetailsreponse =  new roomdetails();
			
			roomdetails	= roomDetailsRepository.findById(roomid).
					orElseThrow(() -> new ResourceNotFoundException("room not found on :: " + roomid));
			
			roomdetails.setRoomstatus(AVAILABLE);
			roomdetailsreponse = 	roomDetailsRepository.save(roomdetails);
			
			RoomDetailsDTO.setFloorid(roomdetailsreponse.getFloorid());
			RoomDetailsDTO.setId(roomdetailsreponse.getId());
			RoomDetailsDTO.setRoomnumber(roomdetailsreponse.getRoomnumber());
			RoomDetailsDTO.setRoomstatus(roomdetailsreponse.getRoomstatus());
			RoomDetailsDTO.setRoomtype(roomdetailsreponse.getRoomtype());
			
		}
		catch(Exception e)
		{
			RoomDetailsDTO.setId(0L);
			System.out.println(e.getMessage());
		}
		
		
		return RoomDetailsDTO;
	}




	public budegetDEatilsResponse getcurentmnthbudeget() {
	
		
		budegetDEatilsResponse budegetDEatilsResponse = new budegetDEatilsResponse();
		
		ArrayList<budgetdetailsDTO> budgetdetailsDTOlist = new ArrayList<>();
		try{
			String checkInTimeMonthIST = null;
			String checOutTimeMonthIST= null;
			String currentmnth = null;
			
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");

			String dateString = format.format( new Date()   );
			
			
			Long finalAmount = 0L;
			Long lastMnthAdvanceAMount = 0L;
			Long nextMnthpaidAMount = 0L;
			
			
		 String nativeQuery = "select r.bookingid,r2.roomnumber,r.roomstatus,r.checkintime ,r.checkouttime ,r.paidamount , r.paidamounttype ,r.advanceamount ,r.advanceamounttype "
		 		+ "from roombookingdetails r join roomdetails r2 on r2.id = r.roomid where"
		 		+ " MONTH(checkintime ) = MONTH(CURRENT_DATE()) OR "
		 		+ "DATE(checkintime) = LAST_DAY(CURRENT_DATE() - INTERVAL 1 MONTH) OR"
		 		+ " DATE(checkintime) = LAST_DAY(CURRENT_DATE() + INTERVAL 1 MONTH) OR"
		 		+ " MONTH(checkouttime ) = MONTH(CURRENT_DATE()) OR "
		 		+ "DATE(checkouttime) = LAST_DAY(CURRENT_DATE() - INTERVAL 1 MONTH) OR "
		 		+ "DATE(checkouttime) = LAST_DAY(CURRENT_DATE() + INTERVAL 1 MONTH)    order by r.checkintime asc";   
		    Query query = em.createNativeQuery(nativeQuery);

		    List<Object[]> list = query.getResultList();
		    
		    for(Object[] q1 : list){
		    	
		    	//remove if checkin and check out are from past month or feature  mnth r3 r4
		    	currentmnth = getMonthFromDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S").parse(	dateString)  ,"dd-MMM-yyyy hh:mm:ss a","CST");
		    	
		    	
		    	checkInTimeMonthIST = getMonthFromDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S").parse(	q1[3].toString())  ,"dd-MMM-yyyy hh:mm:ss a","CST");
		    	if(	q1[4] !=null)
		    	checOutTimeMonthIST = getMonthFromDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S").parse(	q1[4].toString())  ,"dd-MMM-yyyy hh:mm:ss a","CST");
		    	else
		    	checOutTimeMonthIST = currentmnth;
		    	
		    	
		    	
		    	if(checkInTimeMonthIST.equalsIgnoreCase(currentmnth) || checOutTimeMonthIST.equalsIgnoreCase(currentmnth))
		    	{
		    		
		    	budgetdetailsDTO budgetdetailsDTO = new budgetdetailsDTO();
		    	
		    	
		    	
		    	
		    	budgetdetailsDTO.setBookingid(Long.parseLong(q1[0].toString()));
		    	budgetdetailsDTO.setRoomnumber(q1[1].toString());
		    	budgetdetailsDTO.setRoomstatus(q1[2].toString());
		    	budgetdetailsDTO.setCheckintime(formatDateToString(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S").parse(q1[3].toString())  ,"dd MMM yyyy hh:mm:ss a","CST"));
		    	if(	q1[4] !=null)
		    	budgetdetailsDTO.setCheckouttime(formatDateToString(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S").parse(q1[4].toString())  ,"dd MMM yyyy hh:mm:ss a","CST"));
		    	else
		    		budgetdetailsDTO.setCheckouttime("");
		    		
		    	budgetdetailsDTO.setPaidamount(Long.parseLong(q1[5].toString()));
		    	if(	q1[6] !=null)
		    	budgetdetailsDTO.setPaidamountyoe(q1[6].toString());
		    	else
		    		budgetdetailsDTO.setPaidamountyoe("");
		    	budgetdetailsDTO.setAdavnceamount(Long.parseLong(q1[7].toString()));
		    	budgetdetailsDTO.setAdavanceamouttype(q1[8].toString());
		    	
		    	
		    	if(checkInTimeMonthIST.equalsIgnoreCase(currentmnth))
		    	{
		    		finalAmount = finalAmount + budgetdetailsDTO.getAdavnceamount();
		    	}
		    	else
		    	{
		    		lastMnthAdvanceAMount = lastMnthAdvanceAMount +  budgetdetailsDTO.getAdavnceamount();
		    	}
		    	if(checOutTimeMonthIST.equalsIgnoreCase(currentmnth))
		    	{
		    		finalAmount = finalAmount + budgetdetailsDTO.getPaidamount();
		    	}
		    	else
		    	{
		    		nextMnthpaidAMount = nextMnthpaidAMount +  budgetdetailsDTO.getPaidamount();
		    	}
		    	
		    	
		    	budgetdetailsDTOlist.add(budgetdetailsDTO);
		    	
		    	}
		    	
		    	
		    }
		    
		    
		    
		    budegetDEatilsResponse.setBudgetdetailsDTOList(budgetdetailsDTOlist);
		    budegetDEatilsResponse.setFinalAmount(finalAmount);
		    budegetDEatilsResponse.setLastMnthAdvanceAMount(lastMnthAdvanceAMount);
		    budegetDEatilsResponse.setNextMnthpaidAMount(nextMnthpaidAMount);
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
		return budegetDEatilsResponse;
	}




	public creatAdvanceBookingResponseDTO createAdavnceBooking(
			@Valid creatAdvanceBookingRequestDTO creatAdvanceBookingRequestDTO) {
		Date date = new Date();
		creatAdvanceBookingResponseDTO creatAdvanceBookingResponse = new creatAdvanceBookingResponseDTO();
		
		try{
			AdvanceBookingDetails advanceBookingDetailsResponse = new AdvanceBookingDetails();
			AdvanceBookingDetails advanceBookingDetails = new AdvanceBookingDetails();
			advanceBookingDetails.setCustomerName(creatAdvanceBookingRequestDTO.getAdvancecustomername());	
			advanceBookingDetails.setCheckinDate(getAdvanceBookingcheckindate(creatAdvanceBookingRequestDTO.getAdvancecheckindate()));
			advanceBookingDetails.setCreatedDate(date);
			advanceBookingDetails.setNumberOfPersons(creatAdvanceBookingRequestDTO.getAdvancenoofperosons());
			advanceBookingDetails.setNumberOfRooms(creatAdvanceBookingRequestDTO.getAdvancenoofrooms());
			advanceBookingDetails.setStatus(PENDING);
			advanceBookingDetails.setAdvanceAmount(creatAdvanceBookingRequestDTO.getAdvanceadavanceamout());
			advanceBookingDetails.setRemainingAmount(creatAdvanceBookingRequestDTO.getAdvanceadavanceamout());
			advanceBookingDetails.setReturnedAmount(0L);
			advanceBookingDetails.setMobileNumber(creatAdvanceBookingRequestDTO.getAdvancemobilenumber());
			advanceBookingDetails.setUpdatedDate(date);
			advanceBookingDetails.setPurposeofvist(creatAdvanceBookingRequestDTO.getAdvancepurposeofvist());
			advanceBookingDetailsResponse = 	advanceBokkingDeatilsRepository.save(advanceBookingDetails);
			if(advanceBookingDetailsResponse !=null)
			{
				creatAdvanceBookingResponse.setMessage("SUCCESS");
				creatAdvanceBookingResponse.setStatus("SUCCESS");
				
			}
			else
			{
				creatAdvanceBookingResponse.setMessage("FAILED");
				creatAdvanceBookingResponse.setStatus("FAILED");
			}
		}
		catch(Exception e)
		{
			
			creatAdvanceBookingResponse.setMessage("FAILED");
			creatAdvanceBookingResponse.setStatus("FAILED");
			
		}
		
		
		
		
		return creatAdvanceBookingResponse;
	}




	private Date getAdvanceBookingcheckindate(String advancecheckindate) {
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(advancecheckindate);
			 date1.setTime(date1.getTime() + TimeUnit.HOURS.toMillis(7));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return date1;
	}




	public List<getAdvanceBookingDetailDTO> getAdvanceBookingDetails() {
	
		List<getAdvanceBookingDetailDTO> getAdvanceBookingDetailList = new ArrayList<>();
		
		try{
			
			
			
			
			
			 String nativeQuery = "select * from advancebookingdetails where status in ('PENDING','CHECK_IN')";   
			    Query query = em.createNativeQuery(nativeQuery);

			    List<Object[]> list = query.getResultList();
			    
			    for(Object[] q1 : list){
		
			    	getAdvanceBookingDetailDTO getAdvanceBookingDetailDTO = new getAdvanceBookingDetailDTO();
			    	
			    	getAdvanceBookingDetailDTO.setId(Long.parseLong(q1[0].toString()));
			    	getAdvanceBookingDetailDTO.setAdvanceAmount(Long.parseLong(q1[1].toString()));
			    	if(q1[2] != null)
			    	getAdvanceBookingDetailDTO.setBookingIds(q1[2].toString());
			    	else
			    	getAdvanceBookingDetailDTO.setBookingIds("");	
			    	getAdvanceBookingDetailDTO.setCheckinDate(DateformatDateToString(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S").parse(q1[3].toString())  ,"dd MMM yyyy hh:mm:ss a","CST"));
			    	getAdvanceBookingDetailDTO.setCreatedDate(formatDateToString(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S").parse(q1[4].toString())  ,"dd MMM yyyy hh:mm:ss a","CST"));
			    	getAdvanceBookingDetailDTO.setCustomerName(q1[5].toString());
			    	getAdvanceBookingDetailDTO.setNumberOfPersons(Long.parseLong(q1[6].toString()));
			    	getAdvanceBookingDetailDTO.setNumberOfRooms(Long.parseLong(q1[7].toString()));
			    	getAdvanceBookingDetailDTO.setRemainingAmount(Long.parseLong(q1[8].toString()));
			    	getAdvanceBookingDetailDTO.setReturnedAmount(Long.parseLong(q1[9].toString()));
			    	getAdvanceBookingDetailDTO.setStatus(q1[10].toString());
			    	getAdvanceBookingDetailDTO.setUpdatedDate(formatDateToString(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S").parse(q1[11].toString())  ,"dd MMM yyyy hh:mm:ss a","CST"));
			    	getAdvanceBookingDetailDTO.setMobileNumber(q1[12].toString());
			    	getAdvanceBookingDetailDTO.setPurposeofvist(q1[13].toString());
			    	
			    	getAdvanceBookingDetailList.add(getAdvanceBookingDetailDTO);
			    }
			
			
			
		}catch(Exception e )
		{
			
			System.out.println(e.getLocalizedMessage());
			
		}
		
		
		
		
		
		return getAdvanceBookingDetailList;
	}




	public getAdvanceBookingDetailDTO editAdavnceBooking(
			@Valid getAdvanceBookingDetailDTO getAdvanceBookingDetailDTO) {
	
		
		getAdvanceBookingDetailDTO editAdvanceBookingDetailDTOResponse = new getAdvanceBookingDetailDTO();
		
		try{
			Date date = new Date();
			AdvanceBookingDetails advanceBookingDetails  = new AdvanceBookingDetails();
			AdvanceBookingDetails advanceBookingDetailsResponse  = new AdvanceBookingDetails();
			
			advanceBookingDetails = advanceBokkingDeatilsRepository.findById(getAdvanceBookingDetailDTO.getId())
					 .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + getAdvanceBookingDetailDTO.getId()));
			
			
			advanceBookingDetails.setBookingIds(getAdvanceBookingDetailDTO.getBookingIds());
			advanceBookingDetails.setMobileNumber(getAdvanceBookingDetailDTO.getMobileNumber());
			advanceBookingDetails.setNumberOfPersons(getAdvanceBookingDetailDTO.getNumberOfPersons());
			advanceBookingDetails.setNumberOfRooms(getAdvanceBookingDetailDTO.getNumberOfRooms());
			advanceBookingDetails.setPurposeofvist(getAdvanceBookingDetailDTO.getPurposeofvist());
			advanceBookingDetails.setRemainingAmount(getAdvanceBookingDetailDTO.getRemainingAmount());
			advanceBookingDetails.setStatus(getAdvanceBookingDetailDTO.getStatus());
			advanceBookingDetails.setReturnedAmount(getAdvanceBookingDetailDTO.getReturnedAmount());
			advanceBookingDetails.setUpdatedDate(date);
			
			advanceBookingDetailsResponse = advanceBokkingDeatilsRepository.save(advanceBookingDetails);
			if(advanceBookingDetailsResponse != null)
			{
				editAdvanceBookingDetailDTOResponse = getAdvanceBookingDetailDTO;
			}
			else
			{
				editAdvanceBookingDetailDTOResponse = null;
			}
			
		}
		catch(Exception e)
		{
			
			System.out.println(e.getLocalizedMessage());
			
		}
		
		
		
		return editAdvanceBookingDetailDTOResponse;
	}



	
	
	
	

}
