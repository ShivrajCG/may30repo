package com.cg.incentivesystem.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.incentivesystem.dto.CarDetailsDto;
import com.cg.incentivesystem.dto.CustomerDetailsDto;
import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.entites.CarDetails;
import com.cg.incentivesystem.entites.CustomerDetails;
import com.cg.incentivesystem.entites.IncentiveDetails;
import com.cg.incentivesystem.service.CarDealerServiceImpl;
import com.cg.incentivesystem.service.CarDetailsServiceImpl;
import com.cg.incentivesystem.service.CustomerDetailsServiceImpl;
import com.cg.incentivesystem.service.IncentiveDetailsServiceImpl;

@RestController
@RequestMapping("/deal")
public class CarDealerController {
	@Autowired
	CarDetailsServiceImpl carservice;
	@Autowired
	CustomerDetailsServiceImpl custService;
//	@Autowired
//	IncentiveDetailsServiceImpl inceService;
	
	@PostMapping
	public ResponseEntity<String> addCarDetails(@RequestBody CarDetailsDto details) {
		int chasissno=carservice.addCarDetails(details);
		return new ResponseEntity<String>("inserted", HttpStatus.OK);	
	}
	
//	@PostMapping
//	public ResponseEntity<String> addCustomerDetails(@RequestBody CustomerDetailsDto custdto) {
//		custService.addCustomer(custdto);
//		return new ResponseEntity<String>("inserted", HttpStatus.OK);	
//	}
//	
//	
//	
//	@PostMapping
//	public ResponseEntity<String> addIncentiveDetails(@RequestBody IncentiveDetails incDetails) {
//		inceService.addIncentiveDetails(incDetails);
//		return new ResponseEntity<String>("inserted", HttpStatus.OK);	
//	}
	
}

