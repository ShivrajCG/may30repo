package com.cg.incentivesystem.service;



import java.util.List;
import java.util.Optional;

import com.cg.incentivesystem.dto.CustomerDetailsDto;
import com.cg.incentivesystem.dto.ViewCarDto;
import com.cg.incentivesystem.dto.ViewCustomerDto;
import com.cg.incentivesystem.entites.CustomerDetails;
import com.cg.incentivesystem.exception.CustomerAlreadyExistException;
import com.cg.incentivesystem.exception.CustomerNotFoundException;

public interface CustomerDetailsService {
	int addCustomer(CustomerDetailsDto custdto) throws CustomerAlreadyExistException;
	
	List<ViewCustomerDto> viewAllCusts();

	ViewCustomerDto getCustomerById(int customerId) throws CustomerNotFoundException;
	
}
