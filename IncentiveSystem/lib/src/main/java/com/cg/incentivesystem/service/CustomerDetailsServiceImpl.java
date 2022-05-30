package com.cg.incentivesystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.incentivesystem.dto.CustomerDetailsDto;
import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.entites.CustomerDetails;
import com.cg.incentivesystem.exception.CustomerNotFoundException;
import com.cg.incentivesystem.exception.DealerNotFoundException;
import com.cg.incentivesystem.repository.CarDealerRepository;
import com.cg.incentivesystem.repository.CustomerDetailsRepository;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	@Autowired
	CustomerDetailsRepository custrepo;
	@Autowired
	CarDealerRepository dealrepo;

	@Override
	public int addCustomer(CustomerDetailsDto custdto) {
		CarDealer deal = dealrepo.getById(custdto.getDealerID());
		if (deal == null)
			throw new DealerNotFoundException();

		CustomerDetails cust = new CustomerDetails();
		cust.setCustomerName(custdto.getCustomerName());
		cust.setCustomerMobileNo(custdto.getCustomerMobileNo());
		cust.setCustomerMail(custdto.getCustomerMail());

		custrepo.save(cust);
		System.out.println(custdto);
		return cust.getCustomerId();
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

}
