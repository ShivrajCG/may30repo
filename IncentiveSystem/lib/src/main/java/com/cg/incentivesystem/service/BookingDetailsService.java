package com.cg.incentivesystem.service;

import java.util.List;
import java.util.Optional;

import com.cg.incentivesystem.dto.BookingDetailsDto;
import com.cg.incentivesystem.entites.BookingDetails;
import com.cg.incentivesystem.exception.BookingIdNotFoundException;
import com.cg.incentivesystem.exception.ChassisNumberAlreadyBookedException;
import com.cg.incentivesystem.exception.DealerNotFoundException;

public interface BookingDetailsService {
	int addBookingDetails(BookingDetailsDto bkngdet) throws DealerNotFoundException;


}
