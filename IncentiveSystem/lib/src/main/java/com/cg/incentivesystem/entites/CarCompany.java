package com.cg.incentivesystem.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="carcompany")
public class CarCompany {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int companyId;
	@Column(name="companyname",length = 30)
	private String companyName;
	@OneToMany(mappedBy = "carCom", cascade = CascadeType.ALL)
	private List<CarDetails> carDetails;
	@OneToMany(mappedBy = "carCom", cascade = CascadeType.ALL)
	private List<CarDealer> carDealer;
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public List<CarDealer> getCarDealer() {
		return carDealer;
	}
	public void setCarDealer(List<CarDealer> carDealer) {
		this.carDealer = carDealer;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<CarDetails> getCarDetails() {
		return carDetails;
	}
	public void setCarDetails(List<CarDetails> carDetails) {
		this.carDetails = carDetails;
	}
	@Override
	public String toString() {
		return "CarCompany [companyId=" + companyId + ", companyName=" + companyName + ", carDetails=" + carDetails
				+ ", carDealer=" + carDealer + ", getCompanyId()=" + getCompanyId() + ", getCarDealer()="
				+ getCarDealer() + ", getCompanyName()=" + getCompanyName() + ", getCarDetails()=" + getCarDetails()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
