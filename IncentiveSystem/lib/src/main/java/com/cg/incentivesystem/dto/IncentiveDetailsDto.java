package com.cg.incentivesystem.dto;

public class IncentiveDetailsDto {

	private int bookingId;
	private int customerId;
	private int dealerId;



	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	@Override
	public String toString() {
		return "IncentiveDetailsDto [bookingId=" + bookingId + ", customerId=" + customerId + ", dealerId=" + dealerId
				+ "]";
	}





	
}
