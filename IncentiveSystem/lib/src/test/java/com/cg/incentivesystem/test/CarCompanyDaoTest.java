package com.cg.incentivesystem.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.incentivesystem.dto.CarCompanyDto;
import com.cg.incentivesystem.entites.CarCompany;
import com.cg.incentivesystem.repository.CarCompanyRepository;
import com.cg.incentivesystem.service.CarCompanyServiceImpl;

@SpringBootTest	
class CarCompanyDaoTest {
	@Autowired
	CarCompanyRepository comprepo;
	@Autowired
	CarCompanyServiceImpl carservice;
	@Test
	void testAddCarCompany() {
		
		 CarCompanyDto dto = new CarCompanyDto();
		 dto.setCompanyName("Benz");
		 CarCompany comp = new CarCompany();
		 comp.setCompanyName(dto.getCompanyName());
		 int compid = carservice.addCarCompany(dto);
		 assertEquals("Benz",comprepo.getCompanyById(compid).getCompanyName());
		
	}
}
