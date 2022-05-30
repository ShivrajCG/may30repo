package com.cg.incentivesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.incentivesystem.entites.CarDetails;

@Repository
public interface CarDetailsRepository extends JpaRepository<CarDetails, Integer> {

}
