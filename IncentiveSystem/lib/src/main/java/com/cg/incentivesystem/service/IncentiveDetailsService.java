package com.cg.incentivesystem.service;

import com.cg.incentivesystem.entites.IncentiveDetails;
import com.cg.incentivesystem.exception.IncentiveForThisBookingIDAlreadyExistException;

public interface IncentiveDetailsService {
	void addIncentiveDetails(IncentiveDetails incdet) throws IncentiveForThisBookingIDAlreadyExistException;  
}
