package com.cg.incentivesystem.service;

import java.util.List;
import java.util.Optional;

import com.cg.incentivesystem.dto.CarDetailsDto;
import com.cg.incentivesystem.entites.CarDetails;
import com.cg.incentivesystem.exception.CarCompanyNotFoundException;
import com.cg.incentivesystem.exception.CarDetailsNotFoundException;

public interface CarDetailsService {
	int addCarDetails(CarDetailsDto det) throws CarCompanyNotFoundException;

	List<CarDetails> viewAllCarDetails();

	Optional<CarDetails> getCarById(int carChassisNo) throws CarDetailsNotFoundException;

	void updateCarDetails(CarDetails det);

	void deleteCarDetails(int carChassisNo);
	
	List<CarDetails> viewCarByCompanyName(String compName) throws CarCompanyNotFoundException;
}
