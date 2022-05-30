package com.cg.incentivesystem.dto;

import java.util.Date;

import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.entites.CarDetails;

public class BookingDetailsDto {
	private CarDealer cardealer;
	private CarDetails carDetails;
	private Date bookingDate;
	private int customerId;

	public CarDealer getCardealer() {
		return cardealer;
	}

	public void setCardealer(CarDealer cardealer) {
		this.cardealer = cardealer;
	}

	public CarDetails getCarDetails() {
		return carDetails;
	}

	public void setCarDetails(CarDetails carDetails) {
		this.carDetails = carDetails;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "BookingDetailsDto [cardealer=" + cardealer + ", carDetails=" + carDetails + ", bookingDate="
				+ bookingDate + ", customerId=" + customerId + "]";
	}

}
