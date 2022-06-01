package com.cg.incentivesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.incentivesystem.entites.CarCompany;

@Repository
public interface CarCompanyRepository extends JpaRepository<CarCompany, Integer> {

	@Query(value="select com from CarCompany com where com.companyName=?1")
	CarCompany getByName(String compname);
}
