package com.cg.incentivesystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.entites.IncentiveDetails;

@Repository
public interface IncentiveDetailsRepository  extends JpaRepository<IncentiveDetails, Integer>{
	@Query("select incentive.incentiveId from IncentiveDetails incentive where incentive.dealer=?1")
	List<Integer> viewIncentiveBydealerId(CarDealer deal);
	
	
//	@Query("select incentive.amount from IncentiveDetails incentive where incentive.incentiveId=?1")
//	int getAmountById(int incentiveId);
}
