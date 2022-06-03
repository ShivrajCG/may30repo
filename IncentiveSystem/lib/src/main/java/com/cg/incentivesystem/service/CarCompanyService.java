package com.cg.incentivesystem.service;


import java.util.List;

import com.cg.incentivesystem.dto.CarCompanyDto;
import com.cg.incentivesystem.dto.ViewCarCompanyDto;
import com.cg.incentivesystem.exception.CarCompanyAlreadyExistException;
import com.cg.incentivesystem.exception.CarCompanyNotFoundException;


public interface CarCompanyService {
	int addCarCompany(CarCompanyDto comp) throws CarCompanyAlreadyExistException;
	List<ViewCarCompanyDto> getAllCarCompany();
	ViewCarCompanyDto getCarCompanyById(int companyId) throws CarCompanyNotFoundException;

}
