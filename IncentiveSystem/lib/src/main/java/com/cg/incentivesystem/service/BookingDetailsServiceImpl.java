package com.cg.incentivesystem.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.incentivesystem.dto.BookingDetailsDto;
import com.cg.incentivesystem.dto.ViewBookingDto;
import com.cg.incentivesystem.entites.BookingDetails;
import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.entites.CarDetails;
import com.cg.incentivesystem.entites.CustomerDetails;
import com.cg.incentivesystem.exception.BookingIdNotFoundException;
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
		CarDealer dealer = carDealer.getDealByID(bkndet.getCardealerId());
		CarDetails cardetails = carDetails.getCarDetailsByChassisNumber(bkndet.getChassisno());
		CustomerDetails custdetails = custDetails.getCustomerById(bkndet.getCustomerId());
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
	@Override
	public List<ViewBookingDto> getAllBookingDetails() {
		List<BookingDetails> bookDet = bkdetrepo.findAll();
		List<ViewBookingDto> bookDto = new ArrayList<>();
		for(int i=0;i<bookDet.size();i++)
		{
			ViewBookingDto bookingDto = new ViewBookingDto();
			bookingDto.setBookingId(bookDet.get(i).getBookingId());
			bookingDto.setCardealerId(bookDet.get(i).getCardealer().getDealerId());
			bookingDto.setChassisno(bookDet.get(i).getCarDetails().getChassisNumber());
			bookingDto.setCustomerId(bookDet.get(i).getCustdetails().getCustomerId());
			bookDto.add(bookingDto);
		}
		return bookDto;
	}
	@Override
	public ViewBookingDto getBookingDetailsById(int bookingId){
		BookingDetails bookingDet = bkdetrepo.getBookingDetailsByIncentiveId(bookingId);
		if(bookingDet==null)
			throw new BookingIdNotFoundException();
		else {
			ViewBookingDto bookingDto = new ViewBookingDto();
			bookingDto.setBookingId(bookingDet.getBookingId());
			bookingDto.setCardealerId(bookingDet.getCardealer().getDealerId());
			bookingDto.setChassisno(bookingDet.getCarDetails().getChassisNumber());
			return bookingDto;
		}
		
	}
	

	
}
