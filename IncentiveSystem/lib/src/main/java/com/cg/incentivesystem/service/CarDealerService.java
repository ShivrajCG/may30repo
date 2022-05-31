package com.cg.incentivesystem.service;



import com.cg.incentivesystem.dto.CarDealerDto;
<<<<<<< Updated upstream
import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.entites.CarDetails;
import com.cg.incentivesystem.entites.CustomerDetails;
import com.cg.incentivesystem.exception.CarDetailsNotFoundException;
import com.cg.incentivesystem.exception.CustomerNotFoundException;
import com.cg.incentivesystem.exception.DealerAlreadyExistException;
import com.cg.incentivesystem.exception.DealerNotFoundException;
=======
import com.cg.incentivesystem.exception.CarCompanyNotFoundException;
>>>>>>> Stashed changes

public interface CarDealerService {
	int addCarDealer(CarDealerDto dealdto) throws DealerAlreadyExistException;

	List<CarDealer> viewAllDealers();

	Optional<CarDealer> getDealerById(int dealerID) throws DealerNotFoundException;

	List<CarDetails> viewAllCarDetails();

	Optional<CarDetails> getCarById(int carChassisNo) throws CarDetailsNotFoundException;

	List<CustomerDetails> viewAllCusts();

	Optional<CustomerDetails> getCustByID(int customerID) throws CustomerNotFoundException;
}

