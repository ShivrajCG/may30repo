package com.cg.incentivesystem.dto;

import java.util.List;
import java.util.Set;

import com.cg.incentivesystem.entites.BookingDetails;
import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.entites.IncentiveDetails;

public class CustomerDetailsDto {

	private String customerName;
	private Long customerMobileNo;
	private String customerMail;
	private Set<CarDealer> dealer;
	private List<BookingDetails> bookingDetails;
	private List<IncentiveDetails> incentiveDetails;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getCustomerMobileNo() {
		return customerMobileNo;
	}

	public void setCustomerMobileNo(Long customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}

	public String getCustomerMail() {
		return customerMail;
	}

	public void setCustomerMail(String customerMail) {
		this.customerMail = customerMail;
	}

	public Set<CarDealer> getDealer() {
		return dealer;
	}

	public void setDealer(Set<CarDealer> dealer) {
		this.dealer = dealer;
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
		return "CustomerDetailsDto [customerName=" + customerName + ", customerMobileNo=" + customerMobileNo
				+ ", customerMail=" + customerMail + ", dealer=" + dealer + ", bookingDetails=" + bookingDetails
				+ ", incentiveDetails=" + incentiveDetails + "]";
	}

}
