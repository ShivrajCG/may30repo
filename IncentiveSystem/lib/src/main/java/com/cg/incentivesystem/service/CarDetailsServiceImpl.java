 package com.cg.incentivesystem.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.incentivesystem.dto.CarDetailsDto;
import com.cg.incentivesystem.dto.ViewCarDto;
import com.cg.incentivesystem.entites.CarCompany;
import com.cg.incentivesystem.entites.CarDetails;
import com.cg.incentivesystem.exception.CarCompanyNotFoundException;
import com.cg.incentivesystem.exception.CarDetailsNotFoundException;
import com.cg.incentivesystem.repository.CarCompanyRepository;
import com.cg.incentivesystem.repository.CarDetailsRepository;

@Service
public class CarDetailsServiceImpl implements CarDetailsService {
	@Autowired
	CarDetailsRepository cardetrepo;
	@Autowired
	CarCompanyRepository carcomrepo;

	@Override
	public int addCarDetails(CarDetailsDto detdto) {
		CarCompany carcomp = carcomrepo.getCompanyById(detdto.getCompanyId());
		if (carcomp == null)
			throw new CarCompanyNotFoundException();

		CarDetails carDet = new CarDetails();
		carDet.setCarModel(detdto.getCarModel());
		carDet.setCarPrice(detdto.getCarPrice());
		carDet.setSpecification(detdto.getSpecification());
		carDet.setCarCom(carcomp);
		cardetrepo.save(carDet);
		return carDet.getChassisNumber();
	}

	@Override
	public void deleteCarDetails(int carChassisNo) {
		cardetrepo.deleteById(carChassisNo);

	}

	@Override
	public List<Integer> viewChassisnoByCompanyName(String compName) {
		CarCompany comp = carcomrepo.getByName(compName);
		List<Integer> chassisno = cardetrepo.getChassisNumberByCompanyName(comp);
		if (chassisno.isEmpty())
			throw new CarCompanyNotFoundException();
		else {
			return chassisno;
		}
	}

	@Override
	public ViewCarDto getCarDetailsById(int chassisNumber) {
		CarDetails cardet = cardetrepo.getCarDetailsByChassisNumber(chassisNumber);
		if(cardet==null)
			throw new CarDetailsNotFoundException();
		else {
			ViewCarDto cardto = new ViewCarDto();
			cardto.setChassisNumber(cardet.getChassisNumber());
			cardto.setCarModel(cardet.getCarModel());
			cardto.setCarPrice(cardet.getCarPrice());
			cardto.setSpecification(cardet.getSpecification());
			return cardto;
		}
		
	}

	@Override
	public List<ViewCarDto> viewAllCarDetails() {
		List<CarDetails> cardet = cardetrepo.findAll();
		List<ViewCarDto> cardto = new ArrayList<>();
		for(int i=0;i<cardet.size();i++)
		{
			ViewCarDto cardto1 = new ViewCarDto();
			cardto1.setCarModel(cardet.get(i).getCarModel());
			cardto1.setCarPrice(cardet.get(i).getCarPrice());
			cardto1.setChassisNumber(cardet.get(i).getChassisNumber());
			cardto1.setSpecification(cardet.get(i).getSpecification());
			cardto.add(cardto1);
		}
		return cardto;	
	}

}
