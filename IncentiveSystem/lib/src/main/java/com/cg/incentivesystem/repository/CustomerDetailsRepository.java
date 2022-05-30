package com.cg.incentivesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.incentivesystem.entites.CustomerDetails;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Integer>{

}
