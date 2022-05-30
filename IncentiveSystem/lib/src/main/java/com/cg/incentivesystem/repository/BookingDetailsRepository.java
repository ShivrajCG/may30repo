package com.cg.incentivesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.incentivesystem.entites.BookingDetails;

@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Integer> {

}
