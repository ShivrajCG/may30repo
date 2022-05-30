package com.cg.incentivesystem.service;

import java.util.List;
import java.util.Optional;

import com.cg.incentivesystem.entites.CarDetails;
import com.cg.incentivesystem.exception.CarDetailsAlreadyExistException;
import com.cg.incentivesystem.exception.CarDetailsNotFoundException;

public interface CarDetailsService {
	void addCarDetails(CarDetails det) throws CarDetailsAlreadyExistException;

	List<CarDetails> viewAllCarDetails();

	Optional<CarDetails> getCarById(int carChassisNo) throws CarDetailsNotFoundException;

	void updateCarDetails(CarDetails det);

	void deleteCarDetails(int carChassisNo);
}
