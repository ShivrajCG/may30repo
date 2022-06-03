package com.cg.incentivesystem.service;



import java.util.List;


import com.cg.incentivesystem.dto.CustomerDetailsDto;

import com.cg.incentivesystem.dto.ViewCustomerDto;
import com.cg.incentivesystem.exception.CustomerAlreadyExistException;
import com.cg.incentivesystem.exception.CustomerNotFoundException;

public interface CustomerDetailsService {
	int addCustomer(CustomerDetailsDto custdto) throws CustomerAlreadyExistException;
	
	List<ViewCustomerDto> viewAllCusts();

	ViewCustomerDto getCustomerById(int customerId) throws CustomerNotFoundException;
	
	void updateCustomerById(ViewCustomerDto customerDto) throws CustomerNotFoundException;
}
