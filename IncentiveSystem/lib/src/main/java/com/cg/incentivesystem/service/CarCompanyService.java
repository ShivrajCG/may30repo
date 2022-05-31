package com.cg.incentivesystem.service;


import com.cg.incentivesystem.dto.CarCompanyDto;

import java.util.List;
import java.util.Optional;

import com.cg.incentivesystem.entites.CarCompany;

import com.cg.incentivesystem.exception.CarCompanyAlreadyExistException;
import com.cg.incentivesystem.exception.CarCompanyNotFoundException;

public interface CarCompanyService {
	int addCarCompany(CarCompanyDto comp) throws CarCompanyAlreadyExistException;

	List<CarCompany> viewCarCompany();

	Optional<CarCompany> getCompanyById(int companyId) throws CarCompanyNotFoundException;


}
