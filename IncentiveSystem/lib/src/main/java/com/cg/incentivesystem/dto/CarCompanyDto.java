package com.cg.incentivesystem.dto;

public class CarCompanyDto {
	private String companyName;
	private int companyId;
	
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Override
	public String toString() {
		return "CarCompanyDto [companyName=" + companyName + ", companyId=" + companyId + "]";
	}
	
	}
	 
	
	
	
	
