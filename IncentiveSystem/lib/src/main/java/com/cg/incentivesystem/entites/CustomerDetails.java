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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customerdetails")
public class CustomerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int customerId;
	@Column(length = 30)
	private String customerName;
	@Column
	private Long customerMobileNo;
	@Column(length = 200)
	private String customerMail;
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="customers")
	private Set<CarDealer> dealer;
	@OneToMany(mappedBy = "custdetails", cascade = CascadeType.ALL)
	private List<BookingDetails> bookingDetails;
	@OneToMany(mappedBy = "custdetails", cascade = CascadeType.ALL)
	private List<IncentiveDetails> incentiveDetails;
	
	
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
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Long getCustomerMobileNo() {
		return customerMobileNo;
	}
	public void setCustomerMobileNo(Long customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}
	public String getCustomerMail() {
		return customerMail;
	}
	public void setCustomerMail(String customerMail) {
		this.customerMail = customerMail;
	}
	public Set<CarDealer> getDealer() {
		return dealer;
	}
	public void setDealer(Set<CarDealer> dealer) {
		this.dealer = dealer;
	}
}
