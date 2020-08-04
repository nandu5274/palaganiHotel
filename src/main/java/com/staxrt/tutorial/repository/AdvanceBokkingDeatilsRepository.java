package com.staxrt.tutorial.repository;

import org.springframework.stereotype.Repository;

import com.staxrt.tutorial.model.AdvanceBookingDetails;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AdvanceBokkingDeatilsRepository extends JpaRepository<AdvanceBookingDetails, Long> {

}

