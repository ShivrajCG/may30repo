package com.cg.incentivesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.incentivesystem.entites.IncentiveDetails;

@Repository
public interface IncentiveDetailsRepository  extends JpaRepository<IncentiveDetails, Integer>{

}
