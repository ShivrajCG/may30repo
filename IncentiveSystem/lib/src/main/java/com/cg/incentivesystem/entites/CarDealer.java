package com.cg.incentivesystem.entites;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cardealer")
public class CarDealer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int dealerId;
	@Column(length = 30, nullable = false)
	private String dealerName;
	@Column(length = 30)
	private String dealerBranch;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "dealer_customer", joinColumns = {
			@JoinColumn(name = "dealerid", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "customerid", nullable = false) })
	private Set<CustomerDetails> customers;
	@ManyToOne
	@JoinColumn(name = "companyId")
	private CarCompany carCom;
	@OneToMany(mappedBy = "cardealer", cascade = CascadeType.ALL)
	private List<BookingDetails> bookingDetails;
	@OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL)
	private List<IncentiveDetails> incentiveDetails;

	public CarCompany getCarCom() {
		return carCom;
	}

	public void setCarCom(CarCompany carCom) {
		this.carCom = carCom;
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

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getDealerBranch() {
		return dealerBranch;
	}

	public void setDealerBranch(String dealerBranch) {
		this.dealerBranch = dealerBranch;
	}

	public Set<CustomerDetails> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<CustomerDetails> customers) {
		this.customers = customers;
	}
}
