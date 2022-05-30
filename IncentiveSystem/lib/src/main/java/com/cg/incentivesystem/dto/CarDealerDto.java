package com.cg.incentivesystem.dto;

import java.util.List;
import java.util.Set;

import com.cg.incentivesystem.entites.BookingDetails;
import com.cg.incentivesystem.entites.CarCompany;
import com.cg.incentivesystem.entites.CustomerDetails;
import com.cg.incentivesystem.entites.IncentiveDetails;

public class CarDealerDto {
	private String dealerName;
	private String dealerBranch;
	private Set<CustomerDetails> customers;
	private int companyId;
	private List<BookingDetails> bookingDetails;
	private List<IncentiveDetails> incentiveDetails;

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

	public Set<CustomerDetails> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<CustomerDetails> customers) {
		this.customers = customers;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public List<BookingDetails> getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(List<BookingDetails> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	public List<IncentiveDetails> getIncentiveDetails() {
		return incentiveDetails;
	}

	public void setIncentiveDetails(List<IncentiveDetails> incentiveDetails) {
		this.incentiveDetails = incentiveDetails;
	}

	@Override
	public String toString() {
		return "CarDealerDto [dealerName=" + dealerName + ", dealerBranch=" + dealerBranch + ", customers=" + customers
				+ ", companyId=" + companyId + ", bookingDetails=" + bookingDetails + ", incentiveDetails="
				+ incentiveDetails + "]";
	}

}
