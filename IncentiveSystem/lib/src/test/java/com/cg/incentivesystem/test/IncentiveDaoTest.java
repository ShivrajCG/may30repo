package com.cg.incentivesystem.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.incentivesystem.dto.CarCompanyDto;
import com.cg.incentivesystem.dto.CarDealerDto;
import com.cg.incentivesystem.entites.CarCompany;
import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.entites.CarDetails;
import com.cg.incentivesystem.entites.CustomerDetails;
import com.cg.incentivesystem.repository.CarCompanyRepository;
import com.cg.incentivesystem.repository.CarDealerRepository;
import com.cg.incentivesystem.repository.CarDetailsRepository;
import com.cg.incentivesystem.repository.CustomerDetailsRepository;

@SpringBootTest
public class IncentiveDaoTest {

	@Autowired
	CarDealerRepository dealrepo;
	@Autowired
	CarCompanyRepository carComrepo;
	@Autowired
	CarDetailsRepository cardetrepo;
	@Autowired
	CustomerDetailsRepository custrepo;

	@Test
	public void testGetDealerById() {
		CarDealer deal = dealrepo.getById(3);
		System.out.println(deal.getDealerId());
		assertEquals(deal.getDealerId(), 3);
	}

	@Test
	public void getCarById() {
		CarDetails det = cardetrepo.getById(12000293);
		System.out.println(det.getChassisNumber());
		assertEquals(det.getChassisNumber(), 12000293);
	}

	@Test
	public void getCustByID() {
		CustomerDetails cust = custrepo.getById(4);
		System.out.println(cust.getCustomerId());
		assertEquals(cust.getCustomerId(), 4);
	}

	@Test
	void testGetAllItemsNotNull() {
		List<CarDealer> deallist = dealrepo.findAll();
		assertNotNull(deallist);
	}

	@Test
	public void testGetAllItemsNull() {
		List<CarDealer> deallist = dealrepo.findAll();
		assertNull(deallist);
	}
}
