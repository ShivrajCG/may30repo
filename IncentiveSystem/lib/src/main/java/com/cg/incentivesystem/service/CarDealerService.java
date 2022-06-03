package com.cg.incentivesystem.service;



import java.util.List;

import com.cg.incentivesystem.dto.CarDealerDto;
import com.cg.incentivesystem.dto.ViewDealerDto;


import com.cg.incentivesystem.exception.CarCompanyNotFoundException;
import com.cg.incentivesystem.exception.DealerNotFoundException;


public interface CarDealerService {
	int addCarDealer(CarDealerDto dealdto) throws CarCompanyNotFoundException;

	List<ViewDealerDto> viewAllDealers();

	ViewDealerDto getDealerById(int dealerId) throws DealerNotFoundException;

	
}

