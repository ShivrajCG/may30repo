package com.cg.incentivesystem.service;

import java.util.List;

import com.cg.incentivesystem.dto.IncentiveDetailsDto;
import com.cg.incentivesystem.exception.IncentiveForThisBookingIDAlreadyExistException;

public interface IncentiveDetailsService {
	int addIncentiveDetails(IncentiveDetailsDto incdetdto) throws IncentiveForThisBookingIDAlreadyExistException;
	List<Integer> viewIncentiveDetails(int dealerId);
	Double caluculateIncentive(int incentiveId);
}
