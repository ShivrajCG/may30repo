package com.cg.incentivesystem.service;

import java.util.List;
import java.util.Optional;

import com.cg.incentivesystem.entites.BookingDetails;
import com.cg.incentivesystem.exception.BookingIdNotFoundException;
import com.cg.incentivesystem.exception.ChassisNumberAlreadyBookedException;

public interface BookingDetailsService {
	void addBookingDetails(BookingDetails bkngdet) throws ChassisNumberAlreadyBookedException;

	List<BookingDetails> viewAllBookingDetails();

	Optional<BookingDetails> viewBookingDeatilsById(int bookingId) throws BookingIdNotFoundException;

	void updatedBookingDetails(BookingDetails bookingdet);

	void deleteBookingDetailsById(int bookingId) throws ChassisNumberAlreadyBookedException;
}
