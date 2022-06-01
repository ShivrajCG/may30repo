package com.cg.incentivesystem.dto;

public class ViewDealerDto {
	private int dealerId;
	private String dealerName;
	private String dealerBranch;
	private int companyId;
	public int getDealerId() {
		return dealerId;
	}
	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}
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
}
