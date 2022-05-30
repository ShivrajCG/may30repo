package com.cg.incentivesystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.incentivesystem.entites.CarCompany;
import com.cg.incentivesystem.exception.CarCompanyAlreadyExistException;
import com.cg.incentivesystem.repository.CarCompanyRepository;

@Service
public class CarCompanyServiceImpl implements CarCompanyService {
	@Autowired
	CarCompanyRepository carComrepo;
	@Override
	public void addCarCompany(CarCompany comp) throws CarCompanyAlreadyExistException {
		Optional<CarCompany> carCom = carComrepo.findById(comp.getCompanyId());
		if(!carCom.isEmpty())
			throw new CarCompanyAlreadyExistException();
		carComrepo.save(comp);
	}

	@Override
	public List<CarCompany> viewCarCompany() {
		
		return carComrepo.findAll();
	}

	@Override
	public void updateCarCompany(CarCompany comp) {
		carComrepo.save(comp);
		
	}

}
