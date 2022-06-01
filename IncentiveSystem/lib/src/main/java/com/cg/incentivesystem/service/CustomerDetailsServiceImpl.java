package com.cg.incentivesystem.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.incentivesystem.dto.CustomerDetailsDto;
import com.cg.incentivesystem.dto.ViewCustomerDto;
import com.cg.incentivesystem.dto.ViewDealerDto;
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
	public List<ViewCustomerDto> viewAllCusts() {
		List<CustomerDetails> custdet = custrepo.findAll();
		List<ViewCustomerDto> custdto = new ArrayList<ViewCustomerDto>();
		return custdto;
	}

	@Override
	public ViewCustomerDto getCustomerById(int customerId) throws CustomerNotFoundException {
		CustomerDetails custdet = custrepo.getById(customerId);
		ViewCustomerDto custdto = new ViewCustomerDto();
		custdto.setCustomerId(custdet.getCustomerId());
		custdto.setCustomerName(custdet.getCustomerName());
		custdto.setCustomerMobileNo(custdet.getCustomerMobileNo());
		custdto.setCustomerMail(custdet.getCustomerMail());
		return custdto;
	}

	
}
