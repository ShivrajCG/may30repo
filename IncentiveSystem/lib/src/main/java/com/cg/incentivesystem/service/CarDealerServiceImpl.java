package com.cg.incentivesystem.service;



import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.incentivesystem.dto.CarDealerDto;

import com.cg.incentivesystem.dto.ViewDealerDto;
import com.cg.incentivesystem.entites.CarCompany;
import com.cg.incentivesystem.entites.CarDealer;

import com.cg.incentivesystem.exception.CarCompanyNotFoundException;
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
		CarCompany carcom = carComrepo.getCompanyById(dealdto.getCompanyId());
		if (carcom == null)
			throw new CarCompanyNotFoundException();

		CarDealer deal = new CarDealer();
		deal.setDealerName(dealdto.getDealerName());
		deal.setDealerBranch(dealdto.getDealerBranch());

		deal.setCarCom(carcom);
		dealrepo.save(deal);
		return deal.getDealerId();

	}

	@Override
	public List<ViewDealerDto> viewAllDealers() {
		List<CarDealer> cardeal = dealrepo.findAll();
		List<ViewDealerDto> dealdto = new ArrayList<>();
		for(int i=0;i<cardeal.size();i++)
		{
			ViewDealerDto dealerdto = new ViewDealerDto();
			dealerdto.setCompanyId(cardeal.get(i).getCarCom().getCompanyId());
			dealerdto.setDealerBranch(cardeal.get(i).getDealerBranch());
			dealerdto.setDealerId(cardeal.get(i).getDealerId());
			dealerdto.setDealerName(cardeal.get(i).getDealerName());
			dealdto.add(dealerdto);
		}
		return dealdto;
	}

	@Override
	public ViewDealerDto getDealerById(int dealerId)  {
		CarDealer cardeal = dealrepo.getDealByID(dealerId);
		if(cardeal==null)
			throw new DealerNotFoundException();
		else
		{
			ViewDealerDto dealdto = new ViewDealerDto();
			dealdto.setDealerId(cardeal.getDealerId());
			dealdto.setDealerName(cardeal.getDealerName());
			dealdto.setDealerBranch(cardeal.getDealerBranch());
			dealdto.setCompanyId(cardeal.getCarCom().getCompanyId());
			return dealdto;
		}
		
	}

	

	


	
}