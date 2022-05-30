package com.cg.incentivesystem.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.incentivesystem.dto.IncentiveDetailsDto;
import com.cg.incentivesystem.entites.BookingDetails;
import com.cg.incentivesystem.entites.IncentiveDetails;
import com.cg.incentivesystem.exception.BookingIdNotFoundException;
import com.cg.incentivesystem.repository.BookingDetailsRepository;
import com.cg.incentivesystem.repository.IncentiveDetailsRepository;

@Service
public class IncentiveDetailsServiceImpl implements IncentiveDetailsService {
	@Autowired
	IncentiveDetailsRepository incerepo;
	@Autowired
	BookingDetailsRepository bookrepo;
	@Override
	public void addIncentiveDetails(IncentiveDetailsDto incdetdto) {
		BookingDetails bookingdetails = bookrepo.getById(incdetdto.getBooking().getBookingId());
		if(bookingdetails==null)
			throw new BookingIdNotFoundException();
		IncentiveDetails incdet = new IncentiveDetails();
		incdet.setDealer(null);
	}
	
}
