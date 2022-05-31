package com.cg.incentivesystem.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.incentivesystem.dto.CarCompanyDto;
import com.cg.incentivesystem.entites.CarCompany;
import com.cg.incentivesystem.exception.CarCompanyAlreadyExistException;
import com.cg.incentivesystem.exception.CarCompanyNotFoundException;
import com.cg.incentivesystem.repository.CarCompanyRepository;

@Service
public class CarCompanyServiceImpl implements CarCompanyService {
	@Autowired
	CarCompanyRepository carcomrepo;
	
	@Override
	public int addCarCompany(CarCompanyDto comp) throws CarCompanyAlreadyExistException {
		CarCompany carcomp = carcomrepo.getByName(comp.getCompanyName());
		if(carcomp==null)
		{
			CarCompany company = new CarCompany();
			company.setCompanyName(comp.getCompanyName());
			carcomrepo.save(company);
			System.out.println(comp);
			return company.getCompanyId();
		}
		else
			throw new CarCompanyAlreadyExistException();
		
			
	}

	@Override
	public List<CarCompany> viewCarCompany() {
		return carcomrepo.findAll();
	}

	@Override
	public Optional<CarCompany> getCompanyById(int companyId) throws CarCompanyNotFoundException {
		Optional<CarCompany> carcomp = carcomrepo.findById(companyId);
		if(carcomp.isEmpty())
			throw new CarCompanyNotFoundException();
		return carcomp;
	}



	
		
	}	
	


