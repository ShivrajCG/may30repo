package com.cg.incentivesystem.service;



import com.cg.incentivesystem.dto.CustomerDetailsDto;
import com.cg.incentivesystem.exception.CustomerAlreadyExistException;

public interface CustomerDetailsService {
	int addCustomer(CustomerDetailsDto custdto) throws CustomerAlreadyExistException;
	
	List<CustomerDetails> viewAllCusts();

	Optional<CustomerDetails> getCustById(int customerId) throws CustomerNotFoundException;
	
}
