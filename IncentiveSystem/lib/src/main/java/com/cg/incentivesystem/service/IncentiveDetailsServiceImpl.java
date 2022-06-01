package com.cg.incentivesystem.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.incentivesystem.dto.IncentiveDetailsDto;
import com.cg.incentivesystem.dto.ViewIncentiveDto;
import com.cg.incentivesystem.entites.BookingDetails;
import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.entites.CustomerDetails;
import com.cg.incentivesystem.entites.IncentiveDetails;
import com.cg.incentivesystem.exception.BookingIdNotFoundException;
import com.cg.incentivesystem.exception.CustomerNotFoundException;
import com.cg.incentivesystem.exception.DealerNotFoundException;
import com.cg.incentivesystem.exception.NotEligibleForIncentiveException;
import com.cg.incentivesystem.repository.BookingDetailsRepository;
import com.cg.incentivesystem.repository.CarDealerRepository;
import com.cg.incentivesystem.repository.CarDetailsRepository;
import com.cg.incentivesystem.repository.CustomerDetailsRepository;
import com.cg.incentivesystem.repository.IncentiveDetailsRepository;

@Service
public class IncentiveDetailsServiceImpl implements IncentiveDetailsService {
	@Autowired
	IncentiveDetailsRepository incerepo;
	@Autowired
	BookingDetailsRepository bookrepo;
	@Autowired
	CustomerDetailsRepository custrepo;
	@Autowired
	CarDealerRepository dealrepo;
	@Autowired
	CarDetailsRepository carrepo;
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
		incdet.setBooking(bookDetails);
		incdet.setCustdetails(custDetails);
		incdet.setDealer(dealerDetails);
		incerepo.save(incdet);
		return incdet.getIncentiveId();
		}
	}
	@Override
	public List<Integer> viewIncentiveDetails(int dealerId) {
		CarDealer deal = dealrepo.getById(dealerId);
		List<Integer> details = incerepo.viewIncentiveBydealerId(deal);
		if(details.isEmpty())
			throw new DealerNotFoundException();
		return details;
	}
	@Override
	public Double caluculateIncentive(int incentiveId) {
		IncentiveDetails inc = incerepo.getById(incentiveId);
		//System.out.println(inc.getBooking().getBookingId());
		int bookiId = inc.getBooking().getBookingId();
		BookingDetails book = bookrepo.getById(bookiId);
		//System.out.println(bookid.getBookingId());
		double price = carrepo.getCarPriceByBookinId(book);
		
		
//		System.out.println(price);
		if(price<5000) {
			inc.setIncentiveAmount(0.00);
			inc.setStatus("NotEligible");
			inc.setComments("carPriceLessThan5000");
			incerepo.save(inc);
			throw new NotEligibleForIncentiveException();
		}
		else {
			double  incentiveAmount = price*0.1;
			inc.setIncentiveAmount(incentiveAmount);
			inc.setStatus("Eligible");
			inc.setComments("Approved");
			incerepo.save(inc);
			return incentiveAmount;
		} 
				
	}
	@Override
	public ViewIncentiveDto getIncentiveStatus(int incentiveId) {
		IncentiveDetails incdet = incerepo.getById(incentiveId);
		ViewIncentiveDto incdto = new ViewIncentiveDto();
		incdto.setComments(incdet.getComments());
		incdto.setIncentiveAmount(incdet.getIncentiveAmount());
		incdto.setIncentiveId(incdet.getIncentiveId());
		incdto.setStatus(incdet.getStatus());
		return incdto;
	}
	
	
	
}
