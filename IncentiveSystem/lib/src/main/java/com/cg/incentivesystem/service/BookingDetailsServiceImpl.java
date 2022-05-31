package com.cg.incentivesystem.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.incentivesystem.dto.BookingDetailsDto;
import com.cg.incentivesystem.entites.BookingDetails;
import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.entites.CarDetails;
import com.cg.incentivesystem.entites.CustomerDetails;
import com.cg.incentivesystem.exception.ChassisNumberAlreadyBookedException;
import com.cg.incentivesystem.exception.CustomerNotFoundException;
import com.cg.incentivesystem.exception.DealerNotFoundException;
import com.cg.incentivesystem.repository.BookingDetailsRepository;
import com.cg.incentivesystem.repository.CarDealerRepository;
import com.cg.incentivesystem.repository.CarDetailsRepository;
import com.cg.incentivesystem.repository.CustomerDetailsRepository;

@Service
public class BookingDetailsServiceImpl implements BookingDetailsService {

	@Autowired
	BookingDetailsRepository bkdetrepo;
	@Autowired
	CarDealerRepository carDealer;
	@Autowired
	CarDetailsRepository carDetails;
	@Autowired
	CustomerDetailsRepository custDetails;
	@Override
	public int addBookingDetails(BookingDetailsDto bkndet) {
		CarDealer dealer = carDealer.getById(bkndet.getCardealerId());
		CarDetails cardetails = carDetails.getById(bkndet.getChassisno());
		CustomerDetails custdetails = custDetails.getById(bkndet.getCustomerId());
		if(dealer==null)
			throw new DealerNotFoundException();
		else if(cardetails==null)
			throw new ChassisNumberAlreadyBookedException();
		else if(custdetails==null)
			throw new CustomerNotFoundException();
		else
		{
			BookingDetails bookdetails = new BookingDetails();
			Date bookingDate = new Date();
			bookdetails.setBookingDate(bookingDate);
			bookdetails.setCarDetails(cardetails);
			bookdetails.setCustdetails(custdetails);
			bookdetails.setCardealer(dealer);
			bkdetrepo.save(bookdetails);
			return bookdetails.getBookingId();
		}
		
	}
	

	
}
