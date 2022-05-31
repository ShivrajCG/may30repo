package com.cg.incentivesystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.incentivesystem.dto.CarDetailsDto;
import com.cg.incentivesystem.entites.CarCompany;
import com.cg.incentivesystem.entites.CarDetails;
import com.cg.incentivesystem.exception.CarCompanyNotFoundException;
import com.cg.incentivesystem.exception.CarDetailsAlreadyExistException;
import com.cg.incentivesystem.exception.CarDetailsNotFoundException;
import com.cg.incentivesystem.repository.CarCompanyRepository;
import com.cg.incentivesystem.repository.CarDetailsRepository;

@Service
public class CarDetailsServiceImpl implements CarDetailsService{
	@Autowired
	CarDetailsRepository cardetrepo;
	@Autowired
	CarCompanyRepository carcomrepo;
	@Override
	public int addCarDetails(CarDetailsDto detdto) {
		CarCompany carcomp= carcomrepo.getById(detdto.getCompanyId());
		if(carcomp==null)
			throw new CarCompanyNotFoundException();
		
		CarDetails carDet = new CarDetails();
		carDet.setCarModel(detdto.getCarModel());
		carDet.setCarPrice(detdto.getCarPrice());
		carDet.setSpecification(detdto.getSpecification());
		carDet.setCarCom(carcomp);
		cardetrepo.save(carDet);
		System.out.println(detdto);
		return carDet.getChassisNumber();
	}

	@Override
	public List<CarDetails> viewAllCarDetails() {
		return cardetrepo.findAll();
	}

	@Override
	public Optional<CarDetails> getCarById(int carChassisNo)  {
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

	@Override
	public CarDetailsDto viewCarByCompanyName(String compName) {
		CarCompany comp = carcomrepo.getIdByName(compName);	
		CarDetails details = cardetrepo.getCarDetailsByCompanyName(comp.getCompanyId());
		if(details==null)
			throw new CarCompanyNotFoundException();
		else
		{
			CarDetailsDto dts = new CarDetailsDto();
			dts.setCarModel(details.getCarModel());
			dts.setCarPrice(details.getCarPrice());
			dts.setCompanyId(comp.getCompanyId());
			dts.setSpecification(details.getSpecification());
			return dts;
		}
		
	}
}
