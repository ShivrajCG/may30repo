package com.cg.incentivesystem.service;

import com.cg.incentivesystem.dto.BookingDetailsDto;
import com.cg.incentivesystem.exception.DealerNotFoundException;

public interface BookingDetailsService {
	int addBookingDetails(BookingDetailsDto bkngdet) throws DealerNotFoundException;


}
