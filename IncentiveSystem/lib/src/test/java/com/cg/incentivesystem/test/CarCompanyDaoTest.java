package com.cg.incentivesystem.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.incentivesystem.entites.CarCompany;
import com.cg.incentivesystem.repository.CarCompanyRepository;

@SpringBootTest	
public class CarCompanyDaoTest {
	@Autowired
	CarCompanyRepository comprepo;
	
	
	@Test
	public void testGetIdByName() {
		int companyId = comprepo.getIdByName("Maruti");
		System.out.println(companyId);
		assertEquals(companyId,1);
	}
	
	@Test
	public void testGetByName() {
		CarCompany comp = comprepo.getByName("Maruti");
		System.out.println(comp.getCompanyName());
		assertEquals( "Maruti",comp.getCompanyName());
	}
	
	

}
