package com.cg.incentivesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.incentivesystem.entites.CarDealer;

@Repository
public interface CarDealerRepository extends JpaRepository<CarDealer, Integer>{
//	@Query(value = "select deal from dealer deal where deal.dealerID=?1")
//	CarDealer getDealByID(int dealerID);
}
