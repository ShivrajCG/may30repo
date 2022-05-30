package com.cg.incentivesystem.service;

import java.util.List;
import java.util.Optional;

import com.cg.incentivesystem.dto.CarDealerDto;
import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.exception.DealerAlreadyExistException;
import com.cg.incentivesystem.exception.DealerNotFoundException;

public interface CarDealerService {
	int addCarDealer(CarDealerDto dealdto) throws DealerAlreadyExistException;

	List<CarDealer> viewAllDealers();

	Optional<CarDealer> getDealerById(int dealerID) throws DealerNotFoundException;

	void updateDealer(CarDealer deal);

	void deleteDealer(int dealerID) throws DealerNotFoundException;
}
