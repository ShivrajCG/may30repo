package com.cg.incentivesystem.service;


import com.cg.incentivesystem.dto.CarCompanyDto;
import com.cg.incentivesystem.exception.CarCompanyAlreadyExistException;


public interface CarCompanyService {
	void addCarCompany(CarCompanyDto comp) throws CarCompanyAlreadyExistException;
	
}
