package com.cg.incentivesystem.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.incentivesystem.dto.CarCompanyDto;
import com.cg.incentivesystem.entites.CarCompany;
<<<<<<< Updated upstream
import com.cg.incentivesystem.entites.IncentiveDetails;
import com.cg.incentivesystem.exception.CarCompanyNotFoundException;
=======
import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.exception.CarCompanyAlreadyExistException;
import com.cg.incentivesystem.exception.CarCompanyNotFoundException;
import com.cg.incentivesystem.exception.DealerNotFoundException;
>>>>>>> Stashed changes
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
	

<<<<<<< Updated upstream
=======
	@Override
	public Optional<CarCompany> getCompanyById(int companyId) throws CarCompanyNotFoundException {
		Optional<CarCompany> carCom = carComrepo.findById(companyId);
		if (carCom.isEmpty())
			throw new CarCompanyNotFoundException();
		return carCom;
	}

}
>>>>>>> Stashed changes
