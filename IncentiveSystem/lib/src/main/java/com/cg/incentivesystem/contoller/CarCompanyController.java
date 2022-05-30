package com.cg.incentivesystem.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.incentivesystem.dto.CarCompanyDto;
import com.cg.incentivesystem.entites.CarCompany;
import com.cg.incentivesystem.service.CarCompanyServiceImpl;

@RestController
@RequestMapping("/serv")
public class CarCompanyController {
	@Autowired
	CarCompanyServiceImpl comService;
	@PostMapping
	public ResponseEntity<String> addCarCompany(@RequestBody CarCompanyDto comp) {
		comService.addCarCompany(comp);
		return new ResponseEntity<String>("added", HttpStatus.OK);
	}
	
}

