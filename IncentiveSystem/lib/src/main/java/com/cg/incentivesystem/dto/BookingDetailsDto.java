package com.cg.incentivesystem.dto;

import java.util.Date;

import com.cg.incentivesystem.entites.CarDealer;
import com.cg.incentivesystem.entites.CarDetails;

public class BookingDetailsDto {
	private int chassisno;
	private int cardealerId;
	private int incentiveId;
	private int customerId;

	

	public int getChassisno() {
		return chassisno;
	}

	public void setChassisno(int chassisno) {
		this.chassisno = chassisno;
	}

	public int getCardealerId() {
		return cardealerId;
	}

	public void setCardealerId(int cardealerId) {
		this.cardealerId = cardealerId;
	}

	public int getIncentiveId() {
		return incentiveId;
	}

	public void setIncentiveId(int incentiveId) {
		this.incentiveId = incentiveId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	
}
