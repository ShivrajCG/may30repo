package com.cg.incentivesystem.service;

import java.util.List;
import java.util.Optional;

import com.cg.incentivesystem.dto.CustomerDetailsDto;
import com.cg.incentivesystem.entites.CustomerDetails;
import com.cg.incentivesystem.exception.CustomerAlreadyExistException;
import com.cg.incentivesystem.exception.CustomerNotFoundException;

public interface CustomerDetailsService {
	int addCustomer(CustomerDetailsDto custdto) throws CustomerAlreadyExistException;
	
	List<CustomerDetails> viewAllCusts();

	Optional<CustomerDetails> getCustById(int customerId) throws CustomerNotFoundException;
	
}
