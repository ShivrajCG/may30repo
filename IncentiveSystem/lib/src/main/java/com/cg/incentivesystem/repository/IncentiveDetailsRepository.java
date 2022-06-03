package com.cg.incentivesystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.incentivesystem.entites.IncentiveDetails;

@Repository
public interface IncentiveDetailsRepository  extends JpaRepository<IncentiveDetails, Integer>{
	
	@Query("select incentive from IncentiveDetails incentive where incentive.incentiveId=?1")
	IncentiveDetails getIncentiveById(int incentiveId);
	
	@Query("select incentive from IncentiveDetails incentive where incentive.dealer=?1")
	List<IncentiveDetails> getIncentiveByDealerId(int dealer);
}
