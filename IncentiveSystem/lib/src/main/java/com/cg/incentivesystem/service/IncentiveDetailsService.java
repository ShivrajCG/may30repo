package com.cg.incentivesystem.service;

import com.cg.incentivesystem.dto.IncentiveDetailsDto;
import com.cg.incentivesystem.entites.IncentiveDetails;
import com.cg.incentivesystem.exception.IncentiveForThisBookingIDAlreadyExistException;

public interface IncentiveDetailsService {
	int addIncentiveDetails(IncentiveDetailsDto incdetdto) throws IncentiveForThisBookingIDAlreadyExistException;  
}
