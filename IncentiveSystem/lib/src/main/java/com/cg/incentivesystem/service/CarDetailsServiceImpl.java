package com.cg.incentivesystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.incentivesystem.entites.CarDetails;
import com.cg.incentivesystem.exception.CarDetailsAlreadyExistException;
import com.cg.incentivesystem.exception.CarDetailsNotFoundException;
import com.cg.incentivesystem.repository.CarDetailsRepository;

@Service
public class CarDetailsServiceImpl implements CarDetailsService{
	@Autowired
	CarDetailsRepository cardetrepo;
	@Override
	public void addCarDetails(CarDetails det) throws CarDetailsAlreadyExistException {
		Optional<CarDetails> cardetails = cardetrepo.findById(det.getChassisNumber());
		System.out.println(cardetails);
		if (!cardetails.isEmpty())
			throw new CarDetailsAlreadyExistException();
		cardetrepo.save(det);

	}

	@Override
	public List<CarDetails> viewAllCarDetails() {
		return cardetrepo.findAll();
	}

	@Override
	public Optional<CarDetails> getCarById(int carChassisNo) throws CarDetailsNotFoundException {
		Optional<CarDetails> det = cardetrepo.findById(carChassisNo);
		if(det.isEmpty())
			throw new CarDetailsNotFoundException();
		return det;
	}

	@Override
	public void updateCarDetails(CarDetails det) {
		cardetrepo.save(det);

	}

	@Override
	public void deleteCarDetails(int carChassisNo) {
		cardetrepo.deleteById(carChassisNo);

}
}
