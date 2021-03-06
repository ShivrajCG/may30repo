package com.cg.incentivesystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.incentivesystem.entites.BookingDetails;
import com.cg.incentivesystem.entites.CarCompany;

import com.cg.incentivesystem.entites.CarDetails;

@Repository
public interface CarDetailsRepository extends JpaRepository<CarDetails, Integer> {
	@Query("select del.chassisNumber from CarDetails del where del.carCom=?1")
	List<Integer> getChassisNumberByCompanyName(CarCompany comp);
	
	@Query("select del.carPrice from CarDetails del where del.bookingDetails=?1")
	double getCarPriceByBookinId(BookingDetails book);
	
	@Query("select deltails from CarDetails deltails where deltails.chassisNumber=?1")
	CarDetails getCarDetailsByChassisNumber(int chassisNumber);
}
