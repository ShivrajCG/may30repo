 package com.cg.incentivesystem.service;

import com.cg.incentivesystem.entites.Login;

public interface LoginService {
	Login findByUserId(String userid);
}