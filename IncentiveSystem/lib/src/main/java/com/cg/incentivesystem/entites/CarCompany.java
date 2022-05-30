package com.cg.incentivesystem.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="carcompany")
public class CarCompany {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int companyId;
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
	@Column(name="companyname",length = 30)
	private String companyName;
	@OneToMany(mappedBy = "carCom", cascade = CascadeType.ALL)
	private List<CarDetails> carDetails;
	@OneToMany(mappedBy = "carComDealer", cascade = CascadeType.ALL)
	private List<CarDealer> carDealer;
	
	
	
	
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
	
}
