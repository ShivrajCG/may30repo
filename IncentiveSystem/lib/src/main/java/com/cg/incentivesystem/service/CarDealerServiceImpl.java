package com.cg.incentivesystem.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.incentivesystem.dto.CarDealerDto;
import com.cg.incentivesystem.entites.CarCompany;
import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.entites.CarDetails;
import com.cg.incentivesystem.entites.CustomerDetails;
import com.cg.incentivesystem.exception.CarCompanyNotFoundException;
import com.cg.incentivesystem.exception.CarDetailsNotFoundException;
import com.cg.incentivesystem.exception.CustomerNotFoundException;
import com.cg.incentivesystem.exception.DealerAlreadyExistException;
import com.cg.incentivesystem.exception.DealerNotFoundException;
import com.cg.incentivesystem.repository.CarCompanyRepository;
import com.cg.incentivesystem.repository.CarDealerRepository;
import com.cg.incentivesystem.repository.CarDetailsRepository;
import com.cg.incentivesystem.repository.CustomerDetailsRepository;

@Service
public class CarDealerServiceImpl implements CarDealerService {
	@Autowired
	CarDealerRepository dealrepo;
	@Autowired
	CarCompanyRepository carComrepo;
	@Autowired
	CarDetailsRepository cardetrepo;
	@Autowired
	CustomerDetailsRepository custrepo;

	@Override
	public int addCarDealer(CarDealerDto dealdto) throws DealerAlreadyExistException {
		CarCompany carcom = carComrepo.getById(dealdto.getCompanyId());
		if (carcom == null)
			throw new CarCompanyNotFoundException();

		CarDealer deal = new CarDealer();
		deal.setDealerName(dealdto.getDealerName());
		deal.setDealerBranch(dealdto.getDealerBranch());

		deal.setCarCom(carcom);
		dealrepo.save(deal);
		System.out.println(dealdto);
		return deal.getDealerId();

	}

	@Override
	public List<CarDealer> viewAllDealers() {
		return dealrepo.findAll();
	}

	@Override
	public Optional<CarDealer> getDealerById(int dealerID) throws DealerNotFoundException {
		Optional<CarDealer> deal = dealrepo.findById(dealerID);
		if (deal.isEmpty())
			throw new DealerNotFoundException();
		return deal;
	}

	@Override
	public List<CarDetails> viewAllCarDetails() {
		return cardetrepo.findAll();
	}

	@Override
	public Optional<CarDetails> getCarById(int carChassisNo) throws CarDetailsNotFoundException {
		Optional<CarDetails> det = cardetrepo.findById(carChassisNo);
		if (det.isEmpty())
			throw new CarDetailsNotFoundException();
		return det;
	}

	@Override
	public List<CustomerDetails> viewAllCusts() {
		return custrepo.findAll();
	}

	@Override
	public Optional<CustomerDetails> getCustByID(int customerID) throws CustomerNotFoundException {
		Optional<CustomerDetails> cust = custrepo.findById(customerID);
		if (cust.isEmpty())
			throw new CustomerNotFoundException();
		return cust;
	}

	
}