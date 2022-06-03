package com.cg.incentivesystem.service;

import java.util.List;

import com.cg.incentivesystem.dto.IncentiveDetailsDto;
import com.cg.incentivesystem.dto.ViewIncentiveDetailsDto;
import com.cg.incentivesystem.dto.ViewIncentiveDto;
import com.cg.incentivesystem.exception.BookingIdNotFoundException;
import com.cg.incentivesystem.exception.CustomerNotFoundException;
import com.cg.incentivesystem.exception.DealerNotFoundException;
import com.cg.incentivesystem.exception.IncentiveDetailsNotFoundException;

public interface IncentiveDetailsService {
	int addIncentiveDetails(IncentiveDetailsDto incdetdto) throws DealerNotFoundException,BookingIdNotFoundException,CustomerNotFoundException;
	List<ViewIncentiveDetailsDto> viewIncentiveDetails(int dealerId) throws DealerNotFoundException;
	Double caluculateIncentive(int incentiveId) throws IncentiveDetailsNotFoundException;
	ViewIncentiveDto getIncentiveStatus(int incentiveId) throws IncentiveDetailsNotFoundException;
	List<ViewIncentiveDetailsDto> viewAllIncentive(); 
}
