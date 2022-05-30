package com.cg.incentivesystem.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.incentivesystem.dto.CarCompanyDto;
import com.cg.incentivesystem.entites.CarCompany;
import com.cg.incentivesystem.entites.IncentiveDetails;
import com.cg.incentivesystem.exception.CarCompanyNotFoundException;
import com.cg.incentivesystem.repository.CarCompanyRepository;
import com.cg.incentivesystem.repository.IncentiveDetailsRepository;

@Service
public class CarCompanyServiceImpl implements CarCompanyService {
	@Autowired
	CarCompanyRepository carcomrepo;
	@Autowired
	IncentiveDetailsRepository incerepo;
	
	@Override
	public void addCarCompany(CarCompanyDto comp) {
		IncentiveDetails details =incerepo.getById(comp.getCompanyId());
		if (details == null)
			throw new CarCompanyNotFoundException();
		
		CarCompany company = new CarCompany();
		company.setCompanyId(comp.getCompanyId());
		company.setCompanyName(comp.getCompanyName());
		
		System.out.println(comp);
			
	}


	
		
	}	
	

