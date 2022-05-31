package com.cg.incentivesystem.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.service.CarDealerService;
import com.cg.incentivesystem.service.CarDealerServiceImpl;



@ExtendWith(MockitoExtension.class)
public class IncentiveServiceTest {
	@Mock
	CarDealer dealrepo;

	@InjectMocks
	CarDealerService dealser = new CarDealerServiceImpl();

	@Test
	public void testGetAllDealers() {
		dealser.viewAllDealers();
//		 Mockito.verify(dealrepo).findAll();

	}
}