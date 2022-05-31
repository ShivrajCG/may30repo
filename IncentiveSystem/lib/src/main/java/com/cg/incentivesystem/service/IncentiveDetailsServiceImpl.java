package com.cg.incentivesystem.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.incentivesystem.dto.IncentiveDetailsDto;
import com.cg.incentivesystem.entites.BookingDetails;
import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.entites.CustomerDetails;
import com.cg.incentivesystem.entites.IncentiveDetails;
import com.cg.incentivesystem.exception.BookingIdNotFoundException;
import com.cg.incentivesystem.exception.CustomerNotFoundException;
import com.cg.incentivesystem.exception.DealerNotFoundException;
import com.cg.incentivesystem.repository.BookingDetailsRepository;
import com.cg.incentivesystem.repository.CarDealerRepository;
import com.cg.incentivesystem.repository.CustomerDetailsRepository;
import com.cg.incentivesystem.repository.IncentiveDetailsRepository;

@Service
public class IncentiveDetailsServiceImpl implements IncentiveDetailsService {
	@Autowired
	IncentiveDetailsRepository incerepo;
	@Autowired
	CarDealerRepository dealrepo;
	@Autowired
	BookingDetailsRepository bookrepo;
	@Autowired
	CustomerDetailsRepository custrepo;
	@Override
	public int addIncentiveDetails(IncentiveDetailsDto incdetdto) {
		CarDealer dealerDetails = dealrepo.getById(incdetdto.getDealerId());
		BookingDetails bookDetails = bookrepo.getById(incdetdto.getBookingId());
		CustomerDetails custDetails = custrepo.getById(incdetdto.getCustomerId());
		if(dealerDetails==null)
			throw new DealerNotFoundException();
		else if(bookDetails==null)
			throw new BookingIdNotFoundException();
		else if(custDetails==null)
			throw new CustomerNotFoundException();
		else
		{
		IncentiveDetails incdet = new IncentiveDetails();
		incdet.setAmount(incdetdto.getAmount());
		incdet.setBooking(bookDetails);
		incdet.setCustdetails(custDetails);
		incdet.setDealer(dealerDetails);
		return incdet.getIncentiveId();
		}
	}
	
}
