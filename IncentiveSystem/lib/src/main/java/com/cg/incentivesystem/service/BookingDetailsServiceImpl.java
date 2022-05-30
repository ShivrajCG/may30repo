package com.cg.incentivesystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.incentivesystem.entites.BookingDetails;
import com.cg.incentivesystem.exception.BookingIdNotFoundException;
import com.cg.incentivesystem.exception.ChassisNumberAlreadyBookedException;
import com.cg.incentivesystem.repository.BookingDetailsRepository;

@Service
public class BookingDetailsServiceImpl implements BookingDetailsService {

	@Autowired
	BookingDetailsRepository bkdetrepo;
	@Override
	public void addBookingDetails(BookingDetails bkndet) {
		Optional<BookingDetails> bkdet = bkdetrepo.findById(bkndet.getCarDetails().getChassisNumber());
		if(!bkdet.isEmpty())
			throw new ChassisNumberAlreadyBookedException();
		bkdetrepo.save(bkndet);
	}

	@Override
	public List<BookingDetails> viewAllBookingDetails() {
		return bkdetrepo.findAll();
	}

	@Override
	public Optional<BookingDetails> viewBookingDeatilsById(int bookingId) {
		Optional<BookingDetails> details = bkdetrepo.findById(bookingId);
		if(details.isEmpty())
			throw new BookingIdNotFoundException();
		return details;
	}


	@Override
	public void updatedBookingDetails(BookingDetails bookingdet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBookingDetailsById(int bookingId) throws ChassisNumberAlreadyBookedException {
		Optional<BookingDetails> details = bkdetrepo.findById(bookingId);
		if(details.isEmpty())
			throw new BookingIdNotFoundException();
		bkdetrepo.deleteById(bookingId);
	}

}
