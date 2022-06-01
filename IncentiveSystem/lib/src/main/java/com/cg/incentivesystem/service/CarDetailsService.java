package com.cg.incentivesystem.service;

import java.util.List;
import java.util.Optional;

import com.cg.incentivesystem.dto.CarDetailsDto;
import com.cg.incentivesystem.dto.ViewCarDto;
import com.cg.incentivesystem.dto.ViewIncentiveDto;
import com.cg.incentivesystem.entites.CarDetails;
import com.cg.incentivesystem.exception.CarCompanyNotFoundException;
import com.cg.incentivesystem.exception.CarDetailsNotFoundException;
import com.cg.incentivesystem.exception.DealerNotFoundException;

public interface CarDetailsService {
	int addCarDetails(CarDetailsDto det) throws CarCompanyNotFoundException;

	void updateCarDetails(CarDetails det);

	void deleteCarDetails(int carChassisNo);

	List<Integer> viewChassisnoByCompanyName(String compName) throws CarCompanyNotFoundException;

	ViewCarDto getCarDetailsById(int chassisNumber) throws CarDetailsNotFoundException;

	List<ViewCarDto> viewAllCarDetails();
}
