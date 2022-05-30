package com.cg.incentivesystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.incentivesystem.dto.CustomerDetailsDto;
import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.entites.CustomerDetails;
import com.cg.incentivesystem.exception.CustomerAlreadyExistException;
import com.cg.incentivesystem.exception.CustomerNotFoundException;
import com.cg.incentivesystem.repository.CustomerDetailsRepository;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService{

	@Autowired
	CustomerDetailsRepository custrepo;
	@Override
	public int addCustomer(CustomerDetailsDto custdto) {
		return 1;
	}

	@Override
	public List<CustomerDetails> viewAllCusts() {
		return custrepo.findAll();
	}

	@Override
	public Optional<CustomerDetails> getCustByID(int customerID) {
		Optional<CustomerDetails> cust = custrepo.findById(customerID);
		if (cust.isEmpty())
			throw new CustomerNotFoundException();
		return cust;
	}

	@Override
	public void updateCustomer(CustomerDetails cust) {
		custrepo.save(cust);

	}

	@Override
	public void deleteCustomer(int custId) {
		Optional<CustomerDetails> cust = custrepo.findById(custId);
		if (cust.isEmpty())
			throw new CustomerNotFoundException();
		 custrepo.deleteById(custId);
		
	}

}
