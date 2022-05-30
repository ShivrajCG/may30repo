package com.cg.incentivesystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.incentivesystem.entites.IncentiveDetails;
import com.cg.incentivesystem.exception.IncentiveForThisBookingIDAlreadyExistException;
import com.cg.incentivesystem.repository.IncentiveDetailsRepository;

@Service
public class IncentiveDetailsServiceImpl implements IncentiveDetailsService {
	@Autowired
	IncentiveDetailsRepository incerepo;
	@Override
	public void addIncentiveDetails(IncentiveDetails incdet) {
		Optional<IncentiveDetails> cardealer = incerepo.findById(incdet.getBooking().getBookingId());
		System.out.println(cardealer);
		if (!cardealer.isEmpty())
			throw new IncentiveForThisBookingIDAlreadyExistException();
		incerepo.save(incdet);
		
	}
	
}
