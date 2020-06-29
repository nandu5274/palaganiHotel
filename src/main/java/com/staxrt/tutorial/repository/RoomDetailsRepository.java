package com.staxrt.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.staxrt.tutorial.model.roomdetails;


@Repository
public interface RoomDetailsRepository extends JpaRepository<roomdetails,Long> {}

