package com.cg.incentivesystem.service;

import java.util.List;

import com.cg.incentivesystem.dto.IncentiveDetailsDto;
import com.cg.incentivesystem.dto.ViewIncentiveDto;
import com.cg.incentivesystem.exception.DealerNotFoundException;
import com.cg.incentivesystem.exception.IncentiveForThisBookingIDAlreadyExistException;

public interface IncentiveDetailsService {
	int addIncentiveDetails(IncentiveDetailsDto incdetdto) throws IncentiveForThisBookingIDAlreadyExistException;
	List<Integer> viewIncentiveDetails(int dealerId) throws DealerNotFoundException;
	Double caluculateIncentive(int incentiveId);
	ViewIncentiveDto getIncentiveStatus(int incentiveId);
}
