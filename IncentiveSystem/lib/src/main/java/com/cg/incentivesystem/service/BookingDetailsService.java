package com.cg.incentivesystem.service;

import java.util.List;

import com.cg.incentivesystem.dto.BookingDetailsDto;
import com.cg.incentivesystem.dto.ViewBookingDto;
import com.cg.incentivesystem.exception.BookingIdNotFoundException;
import com.cg.incentivesystem.exception.ChassisNumberAlreadyBookedException;
import com.cg.incentivesystem.exception.CustomerNotFoundException;
import com.cg.incentivesystem.exception.DealerNotFoundException;

public interface BookingDetailsService {
	int addBookingDetails(BookingDetailsDto bkngdet) throws DealerNotFoundException,CustomerNotFoundException,ChassisNumberAlreadyBookedException;
	List<ViewBookingDto> getAllBookingDetails(); 
	ViewBookingDto getBookingDetailsById(int bookingId) throws BookingIdNotFoundException;
	
}
