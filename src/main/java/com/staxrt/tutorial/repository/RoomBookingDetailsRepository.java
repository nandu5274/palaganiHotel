package com.staxrt.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.staxrt.tutorial.model.roombookingdetails;


@Repository
public interface RoomBookingDetailsRepository extends JpaRepository<roombookingdetails,  Long> {}

