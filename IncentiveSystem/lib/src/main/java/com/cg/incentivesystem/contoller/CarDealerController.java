package com.cg.incentivesystem.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.incentivesystem.dto.BookingDetailsDto;
import com.cg.incentivesystem.dto.CarDealerDto;
import com.cg.incentivesystem.dto.CarDetailsDto;
import com.cg.incentivesystem.dto.CustomerDetailsDto;
import com.cg.incentivesystem.dto.IncentiveDetailsDto;
import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.entites.CarDetails;
import com.cg.incentivesystem.entites.CustomerDetails;
import com.cg.incentivesystem.entites.IncentiveDetails;
import com.cg.incentivesystem.service.BookingDetailsServiceImpl;
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
	@Autowired
	IncentiveDetailsServiceImpl incentiveService;
	@Autowired
	CarDealerServiceImpl dealerService;
	@Autowired
	BookingDetailsServiceImpl bookservice;
	
//	@PostMapping()
//	public ResponseEntity<String> uplaodDetails(@RequestBody CarDetailsDto carDetails,
//												@RequestBody IncentiveDetailsDto incentiveDetails,
//												@RequestBody CarDealerDto dealerDetails,
//												@RequestBody CustomerDetailsDto customerDetails) {
//		
//		
//		int dealerID = dealerService.addCarDealer(dealerDetails);
//		int chasissno=carservice.addCarDetails(carDetails);
//		int custId = custService.addCustomer(customerDetails);
//		incentiveService.addIncentiveDetails(incentiveDetails);
//		
//		return new ResponseEntity<String>("inserted", HttpStatus.OK);	
//	}
	@PostMapping("/adddealer")
	public ResponseEntity<String> addDealer(@RequestBody CarDealerDto dealerDetails){
		int dealerID = dealerService.addCarDealer(dealerDetails);
		return new ResponseEntity<String>("dealer added "+dealerID, HttpStatus.OK);
	}
	@PostMapping("/addCarDetails")
	public ResponseEntity<String> addCar(@RequestBody CarDetailsDto carDetails){
		int chassisNo = carservice.addCarDetails(carDetails);
		return new ResponseEntity<String>("car added "+chassisNo, HttpStatus.OK);
	}
	@PostMapping("/addIncentiveDetails")
	public ResponseEntity<String> addIncentive(@RequestBody IncentiveDetailsDto incdetails){
		int incentiveId = incentiveService.addIncentiveDetails(incdetails);
		return new ResponseEntity<String>("incentive added "+ incentiveId, HttpStatus.OK);
	}
	@PostMapping("/addCustomerDetails")
	public ResponseEntity<String> addCustomer(@RequestBody CustomerDetailsDto custdetails){
		int cutomerId = custService.addCustomer(custdetails);
		return new ResponseEntity<String>("customer added "+ cutomerId, HttpStatus.OK);
	}
	@PostMapping("/addBookingDetails")
	public ResponseEntity<String> addBookingDetails(@RequestBody BookingDetailsDto bookdetails){
		int bookingID = bookservice.addBookingDetails(bookdetails);
		return new ResponseEntity<String>("carbooked added "+ bookingID, HttpStatus.OK);
	}
	
}