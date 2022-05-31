package com.cg.incentivesystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.incentivesystem.entites.CarDetails;

@Repository
public interface CarDetailsRepository extends JpaRepository<CarDetails, Integer> {
	@Query("select del from CarDetails del where del.carCom=?1")
	List<CarDetails> getCarDetailsByCompanyName(int companyId);
	
}
