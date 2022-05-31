package com.cg.incentivesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.incentivesystem.entites.Login;
import com.cg.incentivesystem.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	UserRepository user_repo;

	@Override
	public Login findByUserId(String userid) {
		return user_repo.findByUserId(userid);
	}

}