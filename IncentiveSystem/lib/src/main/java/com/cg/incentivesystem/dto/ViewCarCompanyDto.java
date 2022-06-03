package com.cg.incentivesystem.dto;

public class ViewCarCompanyDto {
	
	private String companyName;
	private int companyId;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	@Override
	public String toString() {
		return "ViewCarCompanyDto [companyName=" + companyName + ", companyId=" + companyId + "]";
	}
	
}
