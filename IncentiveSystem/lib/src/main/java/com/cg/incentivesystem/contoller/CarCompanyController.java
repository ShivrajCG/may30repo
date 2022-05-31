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
<<<<<<< Updated upstream
import com.cg.incentivesystem.entites.CarDetails;
import com.cg.incentivesystem.entites.IncentiveDetails;
=======
>>>>>>> Stashed changes
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
	@GetMapping("/viewChassisNumber/{companyName}")
	public ResponseEntity<List<Integer>> viewChassisNoByCompanyName(@PathVariable String companyName){
		List<Integer> details = carService.viewChassisnoByCompanyName(companyName);
		return new ResponseEntity<List<Integer>>(details,HttpStatus.OK);
	}
	@GetMapping("/viewIncentiveDetails/{dealerId}")
	public ResponseEntity<List<Integer>> viewIncentives(@PathVariable int dealerId){
		List<Integer> incentive = incService.viewIncentiveDetails(dealerId);
		return new ResponseEntity<List<Integer>>(incentive,HttpStatus.OK);
	}
	@PostMapping("/calculateIncentiveAmount/{incentiveId}")
	public ResponseEntity<String> IncentiveById(@PathVariable int incentiveId) {
		double amt =incService.caluculateIncentive(incentiveId);
		return new ResponseEntity<String>("IncentiveAmountApproved "+amt, HttpStatus.OK);
	}
}

