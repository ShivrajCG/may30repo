package com.cg.incentivesystem.dto;

public class CarDetailsDto {

	private String specification;
	private int carPrice;
	private String carModel;
	private int companyId;
	

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyName) {
		this.companyId = companyName;
	}

	@Override
	public String toString() {
		return "CarDetailsDto [specification=" + specification + ", carPrice=" + carPrice + ", carModel=" + carModel
				+ ", companyId=" + companyId +  "]";
	}

}
