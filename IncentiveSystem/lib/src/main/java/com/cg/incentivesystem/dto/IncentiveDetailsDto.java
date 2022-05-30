package com.cg.incentivesystem.dto;

import com.cg.incentivesystem.entites.BookingDetails;
import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.entites.CustomerDetails;

public class IncentiveDetailsDto {

	private BookingDetails booking;
	private int customerId;
	private int dealerId;
	private int amount;

	public BookingDetails getBooking() {
		return booking;
	}

	public void setBooking(BookingDetails booking) {
		this.booking = booking;
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
		return "IncentiveDetailsDto [booking=" + booking + ", customerId=" + customerId + ", dealerId=" + dealerId
				+ ", amount=" + amount + "]";
	}

}
