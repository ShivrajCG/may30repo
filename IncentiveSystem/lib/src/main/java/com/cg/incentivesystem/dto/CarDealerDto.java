package com.cg.incentivesystem.dto;

public class CarDealerDto {
	private String dealerName;
	private String dealerBranch;
	private int companyId;

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getDealerBranch() {
		return dealerBranch;
	}

	public void setDealerBranch(String dealerBranch) {
		this.dealerBranch = dealerBranch;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "CarDealerDto [dealerName=" + dealerName + ", dealerBranch=" + dealerBranch + ", companyId=" + companyId
				+ "]";
	}

}
