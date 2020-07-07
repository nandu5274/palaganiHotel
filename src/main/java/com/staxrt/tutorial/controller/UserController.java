/*
 *
 *  Copyright (c) 2018-2020 Givantha Kalansuriya, This source is a part of
 *   Staxrt - sample application source code.
 *   http://staxrt.com
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package com.staxrt.tutorial.controller;

import com.staxrt.tutorial.dto.CheckinRoomDetailsResponseDTO;
import com.staxrt.tutorial.dto.CheckoutRoomDetailsRequest;
import com.staxrt.tutorial.dto.CheckoutRoomDetailsResponse;
import com.staxrt.tutorial.dto.InvoiceDetailsResponseDTO;
import com.staxrt.tutorial.dto.RoomBokingResponseDTO;
import com.staxrt.tutorial.dto.RoomDetailsDTO;
import com.staxrt.tutorial.dto.RoomstatsDTO;
import com.staxrt.tutorial.dto.customerOrderDTO;
import com.staxrt.tutorial.exception.ResourceNotFoundException;
import com.staxrt.tutorial.model.User;
import com.staxrt.tutorial.model.roombookingdetails;
import com.staxrt.tutorial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLEngineResult.Status;
import javax.persistence.EntityManager;
import javax.validation.Valid;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.staxrt.tutorial.service.*;
/**
 * The type User controller.
 *
 * @author Givantha Kalansuriya
 */
@RestController
@RequestMapping("/api/palaganihotel")
public class UserController {
	
	
	  @Autowired
	  private interservice interservice;

  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  EntityManager em;
  


  /**
   * Get all users list.
   *
   * @return the list
   */
  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
  
  
  

  /**
   * Gets users by id.
   *
   * @param userId the user id
   * @return the users by id
   * @throws ResourceNotFoundException the resource not found exception
   */
  @GetMapping("/users/{id}")
  public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId)
      throws ResourceNotFoundException {
    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
    return ResponseEntity.ok().body(user);
  }

  /**
   * Create user user.
   *
   * @param user the user
   * @return the user
   */
  @PostMapping("/users")
  public User createUser(@Valid @RequestBody User user) {
    return userRepository.save(user);
  }

  /**
   * Update user response entity.
   *
   * @param userId the user id
   * @param userDetails the user details
   * @return the response entity
   * @throws ResourceNotFoundException the resource not found exception
   */
  @PutMapping("/users/{id}")
  public ResponseEntity<User> updateUser(
      @PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails)
      throws ResourceNotFoundException {

    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

    user.setEmail(userDetails.getEmail());
    user.setLastName(userDetails.getLastName());
    user.setFirstName(userDetails.getFirstName());
    user.setUpdatedAt(new Date());
    final User updatedUser = userRepository.save(user);
    return ResponseEntity.ok(updatedUser);
  }

  /**
   * Delete user map.
   *
   * @param userId the user id
   * @return the map
   * @throws Exception the exception
   */
  @DeleteMapping("/user/{id}")
  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

    userRepository.delete(user);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
  
  /* main code starts here*/
  
  @CrossOrigin
  @PostMapping("/customercheckin")
  public ResponseEntity<RoomBokingResponseDTO> createbooking(@Valid @RequestBody customerOrderDTO customerOrderDTO) {
    
	  RoomBokingResponseDTO roomBokingResponse =  interservice.createBooking(customerOrderDTO);
	  
if(roomBokingResponse.getBookingid() > 0)
{
	return new ResponseEntity<>(roomBokingResponse, HttpStatus.OK);
}

else
{
	return new ResponseEntity<>(roomBokingResponse, HttpStatus.INTERNAL_SERVER_ERROR);
}
	 
	  
	  
  }
  
  
  @CrossOrigin
  @PostMapping("/updatecheckinorder")
  public ResponseEntity<RoomBokingResponseDTO> updateCheckinorder(@Valid @RequestBody customerOrderDTO customerOrderDTO) {
    
	  RoomBokingResponseDTO roomBokingResponse =  interservice.updateBooking(customerOrderDTO);
	  
if(roomBokingResponse.getStatus().equalsIgnoreCase("SUCCESS"))
{
	return new ResponseEntity<>(roomBokingResponse, HttpStatus.OK);
}

else
{
	return new ResponseEntity<>(roomBokingResponse, HttpStatus.INTERNAL_SERVER_ERROR);
}
	 
	  
	  
  }
  
  

  @CrossOrigin
  @GetMapping("/getRooms")
  public ResponseEntity<List<RoomDetailsDTO>>getRoomsDetails() {
    
	  List<RoomDetailsDTO> roomDetailsDTO =  interservice.getRoomDeatils();
	  
	  
if(!CollectionUtils.isEmpty(roomDetailsDTO))
{
	return new ResponseEntity<>(roomDetailsDTO, HttpStatus.OK);
}

else
{
	return new ResponseEntity<>(roomDetailsDTO, HttpStatus.INTERNAL_SERVER_ERROR);
}
	  
	  
  }
  

 
  
  @CrossOrigin
  @GetMapping("/getcheckinRooms")
  public ResponseEntity<List<CheckinRoomDetailsResponseDTO>>getcheckinRooms() {
    
	  List<CheckinRoomDetailsResponseDTO> roomDetailsDTO =  interservice.getcheckinRooms();
	  
	  
if(!CollectionUtils.isEmpty(roomDetailsDTO))
{
	return new ResponseEntity<>(roomDetailsDTO, HttpStatus.OK);
}

else
{
	return new ResponseEntity<>(roomDetailsDTO, HttpStatus.INTERNAL_SERVER_ERROR);
}
	  
	  
  }
  
  @CrossOrigin
  @GetMapping("/getroomstats")
  public ResponseEntity<RoomstatsDTO>getroomstatsCount() {
    
	 RoomstatsDTO roomDetailsDTO =  interservice.getroomstats();
	  
	  

	return new ResponseEntity<>(roomDetailsDTO, HttpStatus.OK);


	  
  }
  
  
  
  @CrossOrigin
  @PostMapping("/customercheckout")
  public ResponseEntity<CheckoutRoomDetailsResponse> customercheckout(@Valid @RequestBody CheckoutRoomDetailsRequest customerOrderDTO) {
    
	  CheckoutRoomDetailsResponse checkoutRoomDetailsResponse = 	 interservice.customercheckout(customerOrderDTO);
	  
  if(checkoutRoomDetailsResponse.getStatus().equalsIgnoreCase("SUCCESS"))
{
	return new ResponseEntity<>(checkoutRoomDetailsResponse, HttpStatus.OK);
}

else
{
	return new ResponseEntity<>(checkoutRoomDetailsResponse, HttpStatus.INTERNAL_SERVER_ERROR);
}
	 
		
	  
  }

  
  
  
  @CrossOrigin
  @PostMapping("/invoicedata")
  public ResponseEntity<InvoiceDetailsResponseDTO> getInvoiceData(@Valid @RequestBody Long bookinid) {
    
	  InvoiceDetailsResponseDTO invoiceDetailsResponseDTO= 	 interservice.getInvoiceData(bookinid);
	  
  if(invoiceDetailsResponseDTO.getStatus().equalsIgnoreCase("SUCCESS"))
{
	return new ResponseEntity<>(invoiceDetailsResponseDTO, HttpStatus.OK);
}

else
{
	return new ResponseEntity<>(invoiceDetailsResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
}
	 
		
	  
  }
  
  
  @CrossOrigin
  @PostMapping("/makeroomavilable")
  public ResponseEntity<RoomDetailsDTO> makeroomavilable(@Valid @RequestBody Long roomid) {
    
	  RoomDetailsDTO roomDetailsDTO= 	 interservice.makeroomavilable(roomid);
	  
  if(roomDetailsDTO.getId()>0)
{
	return new ResponseEntity<>(roomDetailsDTO, HttpStatus.OK);
}

else
{
	return new ResponseEntity<>(roomDetailsDTO, HttpStatus.INTERNAL_SERVER_ERROR);
}
	 
		
	  
  }
  
  
  
  
}
