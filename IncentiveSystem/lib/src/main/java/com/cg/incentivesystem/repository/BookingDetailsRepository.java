package com.cg.incentivesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.incentivesystem.entites.BookingDetails;

@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Integer> {
	@Query("select book from BookingDetails book where book.bookingId =?1")
	BookingDetails getBookingDetailsByIncentiveId(int bookingId);
}
