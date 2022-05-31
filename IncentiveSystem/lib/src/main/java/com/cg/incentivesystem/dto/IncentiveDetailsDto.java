package com.cg.incentivesystem.dto;

public class IncentiveDetailsDto {

	private int bookingId;
	private int customerId;
	private int dealerId;
	private int amount;



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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "IncentiveDetailsDto [bookingId=" + bookingId + ", customerId=" + customerId + ", dealerId=" + dealerId
				+ ", amount=" + amount + ", getBookingId()=" + getBookingId() + ", getCustomerId()=" + getCustomerId()
				+ ", getDealerId()=" + getDealerId() + ", getAmount()=" + getAmount() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
}
