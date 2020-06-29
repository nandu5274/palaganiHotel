package com.staxrt.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.staxrt.tutorial.model.userdetails;


	
	@Repository
	public interface UserDetailsRepository extends JpaRepository<userdetails,  Long> {}



