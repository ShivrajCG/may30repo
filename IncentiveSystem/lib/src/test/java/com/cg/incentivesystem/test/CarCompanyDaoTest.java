package com.cg.incentivesystem.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.incentivesystem.dto.CarCompanyDto;
import com.cg.incentivesystem.dto.ViewCarCompanyDto;
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
	
	@Test
	void testViewCarCompany() {
		List<ViewCarCompanyDto> com = carservice.getAllCarCompany();
		assertNotNull(com);
	}
	
	@Test
	void testGetCarCompanyById() {
		ViewCarCompanyDto comp = carservice.getCarCompanyById(2);
		assertEquals(2, comp.getCompanyId());
	}
}
