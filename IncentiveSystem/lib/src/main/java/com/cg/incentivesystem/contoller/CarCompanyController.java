package com.cg.incentivesystem.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.incentivesystem.dto.CarCompanyDto;
import com.cg.incentivesystem.dto.CarDealerDto;
import com.cg.incentivesystem.dto.CarDetailsDto;
import com.cg.incentivesystem.dto.IncentiveDetailsDto;
import com.cg.incentivesystem.entites.CarCompany;
import com.cg.incentivesystem.entites.CarDetails;
import com.cg.incentivesystem.entites.IncentiveDetails;
import com.cg.incentivesystem.service.CarCompanyServiceImpl;
import com.cg.incentivesystem.service.CarDealerServiceImpl;
import com.cg.incentivesystem.service.CarDetailsServiceImpl;
import com.cg.incentivesystem.service.IncentiveDetailsServiceImpl;


@RestController
@RequestMapping("/serv")
public class CarCompanyController {
	@Autowired
	CarCompanyServiceImpl comService;
	@Autowired
	CarDealerServiceImpl dealerService;
	@Autowired
	CarDetailsServiceImpl carService;
	@Autowired
	IncentiveDetailsServiceImpl incService;
	@PostMapping
	public ResponseEntity<String> registerCarCompany(@RequestBody CarCompanyDto comp) {
		int companyId=comService.addCarCompany(comp);
		return new ResponseEntity<String>("added company "+companyId, HttpStatus.OK);
	}
//	@PostMapping("/registerdealer")
//	public ResponseEntity<String> registerDealer(@RequestBody CarDealerDto dealerDetails){
//		int dealerID = dealerService.addCarDealer(dealerDetails);
//		return new ResponseEntity<String>("dealer added "+dealerID, HttpStatus.OK);
//	}
//	@PostMapping("/registerCarDetails")
//	public ResponseEntity<String> registerCar(@RequestBody CarDetailsDto carDetails){
//		int chassisNo = carService.addCarDetails(carDetails);
//		return new ResponseEntity<String>("car added "+chassisNo, HttpStatus.OK);
//	}
//	@GetMapping("/viewCarcompany")
//	public ResponseEntity<List<CarCompany>> viewAllCompany(){
//		List<CarCompany> car=comService.viewCarCompany();
//		return new ResponseEntity<List<CarCompany>>(car, HttpStatus.OK);
//	}
	@GetMapping("/viewCarDetails/{companyName}")
	public ResponseEntity<List<CarDetails>> viewCarsByCompanyName(@PathVariable String companyName){
		List<CarDetails> details = carService.viewCarByCompanyName(companyName);
		return new ResponseEntity<List<CarDetails>>(details,HttpStatus.OK);
	}
	@GetMapping("/viewIncentiveDetails/{dealerId}")
	public ResponseEntity<List<IncentiveDetails>> viewIncentives(@PathVariable int dealerId){
		List<IncentiveDetails> incentive = incService.viewIncentiveDetails(dealerId);
		return new ResponseEntity<List<IncentiveDetails>>(incentive,HttpStatus.OK);
	}
	@PostMapping("/calculateIncentiveAmount/{incentiveId}")
	public ResponseEntity<String> IncentiveById(@PathVariable int incentiveId) {
		double amt =incService.caluculateIncentive(incentiveId);
		return new ResponseEntity<String>("IncentiveAmount "+amt, HttpStatus.OK);
	}
}

