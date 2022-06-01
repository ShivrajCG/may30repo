package com.cg.incentivesystem.dto;

public class ViewCarDto {
	private int chassisNumber;
	private String carModel;
	private int carPrice;
	private String specification;

	public int getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(int chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

}
