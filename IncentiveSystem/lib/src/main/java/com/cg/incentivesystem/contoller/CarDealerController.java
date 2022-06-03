package com.cg.incentivesystem.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.cg.incentivesystem.dto.BookingDetailsDto;

import com.cg.incentivesystem.dto.CarDealerDto;
import com.cg.incentivesystem.dto.CarDetailsDto;
import com.cg.incentivesystem.dto.CustomerDetailsDto;
import com.cg.incentivesystem.dto.IncentiveDetailsDto;
import com.cg.incentivesystem.dto.ViewBookingDto;
import com.cg.incentivesystem.dto.ViewCarCompanyDto;
import com.cg.incentivesystem.dto.ViewCarDto;
import com.cg.incentivesystem.dto.ViewCustomerDto;
import com.cg.incentivesystem.dto.ViewDealerDto;
import com.cg.incentivesystem.service.BookingDetailsServiceImpl;
import com.cg.incentivesystem.service.CarCompanyService;
import com.cg.incentivesystem.service.CarDealerServiceImpl;
import com.cg.incentivesystem.service.CarDetailsServiceImpl;
import com.cg.incentivesystem.service.CustomerDetailsServiceImpl;
import com.cg.incentivesystem.service.IncentiveDetailsServiceImpl;

@RestController
@RequestMapping("/dealer")
public class CarDealerController {

	@Autowired
	CustomerDetailsServiceImpl custService;
	@Autowired
	IncentiveDetailsServiceImpl inceService;
	@Autowired
	CarDealerServiceImpl dealService;
	@Autowired
	CarDetailsServiceImpl carService;
	@Autowired
	BookingDetailsServiceImpl bookservice;
	@Autowired
	CarCompanyService compservice;

	@PostMapping("/addCarDetails")
	public ResponseEntity<String> addCarDetails(@RequestBody CarDetailsDto details) {
		int chasissno = carService.addCarDetails(details);
		return new ResponseEntity<String>("insertedCarDetails" + chasissno, HttpStatus.OK);
	}

	@PostMapping("/addCustomerDetails")
	public ResponseEntity<String> addCustomerDetails(@RequestBody CustomerDetailsDto custdto) {
		custService.addCustomer(custdto);
		return new ResponseEntity<String>("insertedCustomerDetails", HttpStatus.OK);
	}

	@PostMapping("/addCarDealer")
	public ResponseEntity<String> addCarDealer(@RequestBody CarDealerDto dealdto) {
		dealService.addCarDealer(dealdto);
		return new ResponseEntity<String>("insertedDealerDetails", HttpStatus.OK);
	}

	@GetMapping("/viewAllCars")
	public ResponseEntity<List<ViewCarDto>> getAllCars() {
		List<ViewCarDto> cardto = carService.viewAllCarDetails();
		return new ResponseEntity<List<ViewCarDto>>(cardto, HttpStatus.OK);
	}

	@GetMapping("/viewCarByChassis/{chassisNumber}")
	public ResponseEntity<ViewCarDto> viewCarDetailsById(@PathVariable int chassisNumber) {
		ViewCarDto cardto = carService.getCarDetailsById(chassisNumber);
		return new ResponseEntity<ViewCarDto>(cardto, HttpStatus.OK);
	}

	@GetMapping("/viewAllDealer")
	public ResponseEntity<List<ViewDealerDto>> getAllDealers() {
		List<ViewDealerDto> dealdto = dealService.viewAllDealers();
		return new ResponseEntity<List<ViewDealerDto>>(dealdto, HttpStatus.OK);
	}

	@GetMapping("/dealer/{dealerId}")
	public ResponseEntity<ViewDealerDto> getDealerById(@PathVariable int dealerId) {

		ViewDealerDto dealdto = dealService.getDealerById(dealerId);
		return new ResponseEntity<ViewDealerDto>(dealdto, HttpStatus.OK);
	}

	@GetMapping("/viewAllCusts")
	public ResponseEntity<List<ViewCustomerDto>> getAllCusts() {

		List<ViewCustomerDto> custdto = custService.viewAllCusts();
		return new ResponseEntity<List<ViewCustomerDto>>(custdto, HttpStatus.OK);
	}

	@GetMapping("/customer/{customerId}")
	public ResponseEntity<ViewCustomerDto> getCustomerByID(@PathVariable int customerId) {

		ViewCustomerDto custdto = custService.getCustomerById(customerId);
		return new ResponseEntity<ViewCustomerDto>(custdto, HttpStatus.OK);
	}

	@PostMapping("/addIncentiveDetails")
	public ResponseEntity<String> addIncentive(@RequestBody IncentiveDetailsDto incdetails) {
		int incentiveId = inceService.addIncentiveDetails(incdetails);
		return new ResponseEntity<String>("incentive added " + incentiveId, HttpStatus.OK);
	}

	@PostMapping("/addBookingDetails")
	public ResponseEntity<String> addBookingDetails(@RequestBody BookingDetailsDto bookdetails) {
		int bookingID = bookservice.addBookingDetails(bookdetails);
		return new ResponseEntity<String>("carbooked added " + bookingID, HttpStatus.OK);
	}
	@PutMapping("/updateCustomerDetails")
	public ResponseEntity<String> updateCustomerDetails(@RequestBody ViewCustomerDto customerDto){
		custService.updateCustomerById(customerDto);
		return new ResponseEntity<String>("customer updated", HttpStatus.OK);
	}
	@GetMapping("/viewAllBookingDetails")
	public ResponseEntity<List<ViewBookingDto>> viewAllBookingDetails(){
		List<ViewBookingDto> bookingDetails=bookservice.getAllBookingDetails();
		return new ResponseEntity<List<ViewBookingDto>>(bookingDetails, HttpStatus.OK);
	}
	@GetMapping("/viewBookingDetailsById")
	public ResponseEntity<ViewBookingDto> viewBookingDetailsbyId(@RequestBody int bookingId){
		ViewBookingDto bookingDetails = bookservice.getBookingDetailsById(bookingId);
		return new ResponseEntity<ViewBookingDto>(bookingDetails, HttpStatus.OK);
	}
	@GetMapping("/viewAllCarCompany")
	public ResponseEntity<List<ViewCarCompanyDto>> viewAllCarCompany(){
		List<ViewCarCompanyDto> companyDetails = compservice.getAllCarCompany();
		return new ResponseEntity<>(companyDetails, HttpStatus.OK);
	}
	@GetMapping("/viewCarcompanyById")
	public ResponseEntity<ViewCarCompanyDto> viewCarcompanyById(@PathVariable int companyId){
		ViewCarCompanyDto companyDto = compservice.getCarCompanyById(companyId);
		return new ResponseEntity<ViewCarCompanyDto>(companyDto, HttpStatus.OK);
	}
}