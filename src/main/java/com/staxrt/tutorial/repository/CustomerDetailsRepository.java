package com.staxrt.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.staxrt.tutorial.model.customerdetails;


@Repository
public interface CustomerDetailsRepository extends JpaRepository<customerdetails, Long> {}

