package com.cg.incentivesystem.service;

import java.util.List;
import com.cg.incentivesystem.entites.CarCompany;
import com.cg.incentivesystem.exception.CarCompanyAlreadyExistException;


public interface CarCompanyService {
	void addCarCompany(CarCompany comp) throws CarCompanyAlreadyExistException;
	List<CarCompany> viewCarCompany();
	void updateCarCompany(CarCompany comp);
}
