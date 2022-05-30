package com.cg.incentivesystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.incentivesystem.entites.CarCompany;

@Repository
public interface CarCompanyRepository extends JpaRepository<CarCompany, Integer> {


}
