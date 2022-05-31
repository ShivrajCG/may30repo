package com.cg.incentivesystem.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "login")
@NamedQueries(@NamedQuery(name = "Login.findByUserId", query = "from Login where userid=?1"))
public class Login {
	@Id
	@Column(length = 30)
	private String userId;
	@Column(length = 30)
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}