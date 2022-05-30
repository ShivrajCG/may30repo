package com.cg.incentivesystem.service;

import java.util.List;
import java.util.Optional;

import com.cg.incentivesystem.entites.CustomerDetails;
import com.cg.incentivesystem.exception.CustomerAlreadyExistException;
import com.cg.incentivesystem.exception.CustomerNotFoundException;

public interface CustomerDetailsService {
	void addCustomer(CustomerDetails cust) throws CustomerAlreadyExistException;

	List<CustomerDetails> viewAllCusts();

	Optional<CustomerDetails> getCustByID(int customerID) throws CustomerNotFoundException;

	void updateCustomer(CustomerDetails cust);
	
	void deleteCustomer(int custId);
}
