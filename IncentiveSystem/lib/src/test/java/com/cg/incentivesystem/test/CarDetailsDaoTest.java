package com.cg.incentivesystem.test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.incentivesystem.entites.CarCompany;
import com.cg.incentivesystem.repository.CarCompanyRepository;
import com.cg.incentivesystem.repository.CarDetailsRepository;

@SpringBootTest
public class CarDetailsDaoTest {
	@Autowired
	CarDetailsRepository detrepo;
	@Autowired
	CarCompanyRepository comprepo;
	
	@Test
	public void testGetChassisNumberByCompanyName() {
		CarCompany comp = comprepo.getByName("Maruti");
		List<Integer> chassisno = detrepo.getChassisNumberByCompanyName(comp);
		System.out.println(chassisno);
		assertNotNull(chassisno);
	}
}
