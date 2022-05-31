package com.cg.incentivesystem.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.incentivesystem.dto.CarDealerDto;
import com.cg.incentivesystem.dto.CarDetailsDto;
import com.cg.incentivesystem.dto.CustomerDetailsDto;
<<<<<<< Updated upstream
import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.entites.CarDetails;
import com.cg.incentivesystem.entites.CustomerDetails;
=======
import com.cg.incentivesystem.dto.IncentiveDetailsDto;
import com.cg.incentivesystem.service.BookingDetailsServiceImpl;
>>>>>>> Stashed changes
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
	IncentiveDetailsServiceImpl inceService;
	@Autowired
	CarDealerServiceImpl dealService;
	@Autowired
	CarDetailsServiceImpl carService;

	@PostMapping("/addCarDetails")
	public ResponseEntity<String> addCarDetails(@RequestBody CarDetailsDto details) {
		int chasissno = carservice.addCarDetails(details);
		return new ResponseEntity<String>("inserted"+chasissno, HttpStatus.OK);
	}

	@PostMapping("/addCustomerDetails")
	public ResponseEntity<String> addCustomerDetails(@RequestBody CustomerDetailsDto custdto) {
		custService.addCustomer(custdto);
		return new ResponseEntity<String>("inserted", HttpStatus.OK);
	}

	@PostMapping("/addCarDealer")
	public ResponseEntity<String> addCarDealer(@RequestBody CarDealerDto dealdto) {
		dealService.addCarDealer(dealdto);
		return new ResponseEntity<String>("inserted", HttpStatus.OK);
	}

	@GetMapping("/viewAllCars")
	public ResponseEntity<List<CarDetails>> getAllCars() {

		List<CarDetails> carList = carService.viewAllCarDetails();
		return new ResponseEntity<List<CarDetails>>(carList, HttpStatus.OK);
	}

	@GetMapping("/id/{chassisNumber}")
	public ResponseEntity<Optional<CarDetails>> getCarById(@PathVariable int chassisNumber) {

		Optional<CarDetails> det = carService.getCarById(chassisNumber);
		return new ResponseEntity<Optional<CarDetails>>(det, HttpStatus.OK);
	}

	@GetMapping("/viewAllDealer")
	public ResponseEntity<List<CarDealer>> getAllDealers() {

		List<CarDealer> dealList = dealService.viewAllDealers();
		return new ResponseEntity<List<CarDealer>>(dealList, HttpStatus.OK);
	}

	@GetMapping("/id/{dealerId}")
	public ResponseEntity<Optional<CarDealer>> getDealerById(@PathVariable int dealerId) {

		Optional<CarDealer> deal = dealService.getDealerById(dealerId);
		return new ResponseEntity<Optional<CarDealer>>(deal, HttpStatus.OK);
	}

	@GetMapping("/viewAllCusts")
	public ResponseEntity<List<CustomerDetails>> getAllCusts() {

		List<CustomerDetails> custList = custService.viewAllCusts();
		return new ResponseEntity<List<CustomerDetails>>(custList, HttpStatus.OK);
	}

	@GetMapping("/id/{customerId}")
	public ResponseEntity<Optional<CustomerDetails>> getCustById(@PathVariable int customerId) {

		Optional<CustomerDetails> cust = custService.getCustById(customerId);
		return new ResponseEntity<Optional<CustomerDetails>>(cust, HttpStatus.OK);
	}
}