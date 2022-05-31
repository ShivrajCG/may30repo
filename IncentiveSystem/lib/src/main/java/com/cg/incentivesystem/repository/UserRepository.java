package com.cg.incentivesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.incentivesystem.entites.Login;

@Repository
public interface UserRepository extends JpaRepository<Login, String> {
	Login findByUserId(String userid);
}