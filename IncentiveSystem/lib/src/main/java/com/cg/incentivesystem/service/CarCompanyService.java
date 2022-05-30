package com.cg.incentivesystem.service;

<<<<<<< Updated upstream

import com.cg.incentivesystem.dto.CarCompanyDto;
=======
import java.util.List;
import java.util.Optional;

import com.cg.incentivesystem.entites.CarCompany;
>>>>>>> Stashed changes
import com.cg.incentivesystem.exception.CarCompanyAlreadyExistException;
import com.cg.incentivesystem.exception.CarCompanyNotFoundException;

public interface CarCompanyService {
<<<<<<< Updated upstream
	void addCarCompany(CarCompanyDto comp) throws CarCompanyAlreadyExistException;
	
=======
	void addCarCompany(CarCompany comp) throws CarCompanyAlreadyExistException;

	List<CarCompany> viewCarCompany();

	Optional<CarCompany> getCompanyById(int companyId) throws CarCompanyNotFoundException;

	void updateCarCompany(CarCompany comp);
>>>>>>> Stashed changes
}
