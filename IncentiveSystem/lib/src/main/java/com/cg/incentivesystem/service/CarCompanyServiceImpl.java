package com.cg.incentivesystem.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.incentivesystem.dto.CarCompanyDto;
import com.cg.incentivesystem.dto.ViewCarCompanyDto;
import com.cg.incentivesystem.entites.CarCompany;

import com.cg.incentivesystem.exception.CarCompanyAlreadyExistException;
import com.cg.incentivesystem.exception.CarCompanyNotFoundException;
import com.cg.incentivesystem.repository.CarCompanyRepository;


@Service
public class CarCompanyServiceImpl implements CarCompanyService {
	
	@Autowired
	CarCompanyRepository carcomrepo;
	
	@Override
	public int addCarCompany(CarCompanyDto comp) {
		CarCompany carcomp = carcomrepo.getByName(comp.getCompanyName());
		if(carcomp==null)
		{
			CarCompany company = new CarCompany();
			company.setCompanyName(comp.getCompanyName());
			carcomrepo.save(company);
			return company.getCompanyId();
		}
		else
			throw new CarCompanyAlreadyExistException();
	}

	@Override
	public List<ViewCarCompanyDto> getAllCarCompany() {
		List<CarCompany> carcom = carcomrepo.findAll();
		List<ViewCarCompanyDto> carcomDto = new ArrayList<>();
		for(int i=0;i<carcom.size();i++)
		{
			ViewCarCompanyDto carcompanydto = new ViewCarCompanyDto();
			carcompanydto.setCompanyId(carcom.get(i).getCompanyId());
			carcompanydto.setCompanyName(carcom.get(i).getCompanyName());
			carcomDto.add(carcompanydto);
			
		}
		return carcomDto;
	}

	@Override
	public ViewCarCompanyDto getCarCompanyById(int companyId) {
		CarCompany carcom = carcomrepo.getCompanyById(companyId);
		if(carcom==null)
			throw new CarCompanyNotFoundException();
		else {
			ViewCarCompanyDto carcompanydto = new ViewCarCompanyDto();
			carcompanydto.setCompanyId(carcom.getCompanyId());
			carcompanydto.setCompanyName(carcom.getCompanyName());
			return carcompanydto;
		}	
	}
}	
	


