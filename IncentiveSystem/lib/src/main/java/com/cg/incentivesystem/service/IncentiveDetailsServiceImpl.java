package com.cg.incentivesystem.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.incentivesystem.dto.IncentiveDetailsDto;
import com.cg.incentivesystem.dto.ViewIncentiveDetailsDto;
import com.cg.incentivesystem.dto.ViewIncentiveDto;
import com.cg.incentivesystem.entites.BookingDetails;
import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.entites.CustomerDetails;
import com.cg.incentivesystem.entites.IncentiveDetails;
import com.cg.incentivesystem.exception.BookingIdNotFoundException;
import com.cg.incentivesystem.exception.CustomerNotFoundException;
import com.cg.incentivesystem.exception.DealerNotFoundException;
import com.cg.incentivesystem.exception.IncentiveDetailsNotFoundException;
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
		CarDealer dealerDetails = dealrepo.getDealByID(incdetdto.getDealerId());
		BookingDetails bookDetails = bookrepo.getBookingDetailsByIncentiveId(incdetdto.getBookingId());
		CustomerDetails custDetails = custrepo.getCustomerById(incdetdto.getCustomerId());
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
	public List<ViewIncentiveDetailsDto> viewIncentiveDetails(int dealerId) {
		CarDealer deal = dealrepo.getDealByID(dealerId);
		List<ViewIncentiveDetailsDto> incentiveDto = new ArrayList<>();
		if(deal==null)
			throw new DealerNotFoundException();
		else	
		{
			
			List<IncentiveDetails> incDetails = incerepo.getIncentiveByDealerId(deal.getDealerId());
			if(incDetails==null)
				throw new IncentiveDetailsNotFoundException();
			else
			{
				for(int i=0;i<incDetails.size();i++)
				{
					ViewIncentiveDetailsDto incDto = new ViewIncentiveDetailsDto();
					incDto.setBookingId(incDetails.get(i).getBooking().getBookingId());
					incDto.setCustomerId(incDetails.get(i).getCustdetails().getCustomerId());
					incDto.setDealerId(incDetails.get(i).getDealer().getDealerId());
					incDto.setIncentiveId(incDetails.get(i).getIncentiveId());
					incentiveDto.add(incDto);
				}
			}
				
			
		}
		return incentiveDto;
	}
	@Override
	public Double caluculateIncentive(int incentiveId) {
		IncentiveDetails inc = incerepo.getIncentiveById(incentiveId);
		if(inc==null)
			throw new IncentiveDetailsNotFoundException();
		else {
			BookingDetails book = bookrepo.getBookingDetailsByIncentiveId(inc.getBooking().getBookingId());
			double price = carrepo.getCarPriceByBookinId(book);
			if(book==null)
				throw new BookingIdNotFoundException();
			else {
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
		}
		
		
				
	}
	@Override
	public ViewIncentiveDto getIncentiveStatus(int incentiveId) {
		IncentiveDetails incdet = incerepo.getIncentiveById(incentiveId);
		if(incdet==null)
			throw new IncentiveDetailsNotFoundException();
		else {
			ViewIncentiveDto incdto = new ViewIncentiveDto();
			incdto.setComments(incdet.getComments());
			incdto.setIncentiveAmount(incdet.getIncentiveAmount());
			incdto.setIncentiveId(incdet.getIncentiveId());
			incdto.setStatus(incdet.getStatus());
			return incdto;
		}
		
	}
	@Override
	public List<ViewIncentiveDetailsDto> viewAllIncentive() {
		List<ViewIncentiveDetailsDto> incentiveDto = new ArrayList<>();
		List<IncentiveDetails> incentiveDetails = new ArrayList<>();
		for(int i=0;i<incentiveDetails.size();i++)
		{
			ViewIncentiveDetailsDto incdto = new ViewIncentiveDetailsDto();
			incdto.setBookingId(incentiveDetails.get(i).getBooking().getBookingId());
			incdto.setCustomerId(incentiveDetails.get(i).getCustdetails().getCustomerId());
			incdto.setDealerId(incentiveDetails.get(i).getDealer().getDealerId());
			incdto.setIncentiveId(incentiveDetails.get(i).getIncentiveId());
			incentiveDto.add(incdto);
		}
		return incentiveDto;
	}
	
	
	
}
