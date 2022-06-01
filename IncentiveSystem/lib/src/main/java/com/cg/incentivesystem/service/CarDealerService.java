package com.cg.incentivesystem.service;



import java.util.List;
import java.util.Optional;

import com.cg.incentivesystem.dto.CarDealerDto;
import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.entites.CarDetails;
import com.cg.incentivesystem.entites.CustomerDetails;
import com.cg.incentivesystem.exception.CarCompanyNotFoundException;
import com.cg.incentivesystem.exception.CarDetailsNotFoundException;
import com.cg.incentivesystem.exception.CustomerNotFoundException;
import com.cg.incentivesystem.exception.DealerNotFoundException;


public interface CarDealerService {
	int addCarDealer(CarDealerDto dealdto) throws CarCompanyNotFoundException;

	List<CarDealer> viewAllDealers();

	CarDealer getDealerById(int dealerID) throws DealerNotFoundException;

	List<CarDetails> viewAllCarDetails();

	Optional<CarDetails> getCarById(int carChassisNo) throws CarDetailsNotFoundException;

	List<CustomerDetails> viewAllCusts();

	Optional<CustomerDetails> getCustByID(int customerID) throws CustomerNotFoundException;
}

