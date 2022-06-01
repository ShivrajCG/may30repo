package com.cg.incentivesystem.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.incentivesystem.dto.CarDealerDto;
import com.cg.incentivesystem.dto.ViewCarDto;
import com.cg.incentivesystem.dto.ViewDealerDto;
import com.cg.incentivesystem.entites.CarCompany;
import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.entites.CarDetails;
import com.cg.incentivesystem.entites.CustomerDetails;
import com.cg.incentivesystem.exception.CarCompanyNotFoundException;
import com.cg.incentivesystem.exception.CarDetailsNotFoundException;
import com.cg.incentivesystem.exception.CustomerNotFoundException;
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
	public int addCarDealer(CarDealerDto dealdto) {
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
	public List<ViewDealerDto> viewAllDealers() {
		List<CarDealer> cardeal = dealrepo.findAll();
		List<ViewDealerDto> dealdto = new ArrayList<ViewDealerDto>();
		return dealdto;
	}

	@Override
	public ViewDealerDto getDealerById(int dealerId)  {
		CarDealer cardeal = dealrepo.getById(dealerId);
		ViewDealerDto dealdto = new ViewDealerDto();
		dealdto.setDealerId(cardeal.getDealerId());
		dealdto.setDealerName(cardeal.getDealerName());
		dealdto.setDealerBranch(cardeal.getDealerBranch());
		dealdto.setCompanyId(cardeal.getCarCom().getCompanyId());
		return dealdto;
	}

	@Override
	public List<CarDetails> viewAllCarDetails() {
		return cardetrepo.findAll();
	}

	@Override
	public Optional<CarDetails> getCarById(int carChassisNo) {
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
	public Optional<CustomerDetails> getCustByID(int customerID) {
		Optional<CustomerDetails> cust = custrepo.findById(customerID);
		if (cust.isEmpty())
			throw new CustomerNotFoundException();
		return cust;
	}

	
}