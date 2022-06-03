package com.cg.incentivesystem.service;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.incentivesystem.dto.CustomerDetailsDto;
import com.cg.incentivesystem.dto.ViewCustomerDto;
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
		CarDealer deal = dealrepo.getDealByID(custdto.getDealerID());
		if (deal == null)
			throw new DealerNotFoundException();
		else {
			CustomerDetails cust = new CustomerDetails();
			cust.setCustomerName(custdto.getCustomerName());
			cust.setCustomerMobileNo(custdto.getCustomerMobileNo());
			cust.setCustomerMail(custdto.getCustomerMail());

			custrepo.save(cust);
			return cust.getCustomerId();
		}
		
	}

	@Override
	public List<ViewCustomerDto> viewAllCusts() {
		List<CustomerDetails> custdet = custrepo.findAll();
		List<ViewCustomerDto> custdto = new ArrayList<>();
		for(int i=0;i<custdet.size();i++)
		{
			ViewCustomerDto custdtox= new ViewCustomerDto();
			custdtox.setCustomerId(custdet.get(i).getCustomerId());
			custdtox.setCustomerMail(custdet.get(i).getCustomerMail());
			custdtox.setCustomerMobileNo(custdet.get(i).getCustomerMobileNo());
			custdtox.setCustomerName(custdet.get(i).getCustomerName());
			custdto.add(custdtox);
		}
		return custdto;
	}

	@Override
	public ViewCustomerDto getCustomerById(int customerId) {
		CustomerDetails custdet = custrepo.getCustomerById(customerId);
		if(custdet==null)
			throw new CustomerNotFoundException();
		else {
			ViewCustomerDto custdto = new ViewCustomerDto();
			custdto.setCustomerId(custdet.getCustomerId());
			custdto.setCustomerName(custdet.getCustomerName());
			custdto.setCustomerMobileNo(custdet.getCustomerMobileNo());
			custdto.setCustomerMail(custdet.getCustomerMail());
			return custdto;
		}
		
	}

	@Override
	public void updateCustomerById(ViewCustomerDto cutomerDto) throws CustomerNotFoundException {
		CustomerDetails custdet = custrepo.getCustomerById(cutomerDto.getCustomerId());
		if(custdet==null)
			throw new CustomerNotFoundException();
		else
		{
			CustomerDetails cust = new CustomerDetails();
			cust.setCustomerName(cutomerDto.getCustomerName());
			cust.setCustomerMobileNo(cutomerDto.getCustomerMobileNo());
			cust.setCustomerMail(cutomerDto.getCustomerMail());

			custrepo.save(cust);	
		}
		
	}

	
}
