package com.cg.incentivesystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.incentivesystem.entites.CarCompany;
import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.exception.CarCompanyAlreadyExistException;
import com.cg.incentivesystem.exception.DealerAlreadyExistException;
import com.cg.incentivesystem.exception.DealerNotFoundException;
import com.cg.incentivesystem.repository.CarDealerRepository;

@Service
public class CarDealerServiceImpl implements CarDealerService{
	@Autowired
	CarDealerRepository dealrepo;

	@Override
	public void addCarDealer(CarDealer deal) throws DealerAlreadyExistException {
		Optional<CarDealer> cardealer = dealrepo.findById(deal.getDealerId());
		System.out.println(cardealer);
		if (!cardealer.isEmpty())
			throw new DealerAlreadyExistException();
		dealrepo.save(deal);

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
	public void updateDealer(CarDealer deal) {
		dealrepo.save(deal);

	}

	@Override
	public void deleteDealer(int dealerID) throws DealerNotFoundException {
		Optional<CarDealer> dealer = dealrepo.findById(dealerID);
		if(dealer.isEmpty())
			throw new DealerNotFoundException();
		dealrepo.deleteById(dealerID);
	}

	
	

}
