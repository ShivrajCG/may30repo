package com.cg.incentivesystem.entites;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "incentivedetails")
public class IncentiveDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int incentiveId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookingId", unique = true)
	private BookingDetails booking;
	@ManyToOne
	@JoinColumn(name = "customerid")
	private CustomerDetails custdetails;
	@ManyToOne
	@JoinColumn(name = "dealerid")
	private CarDealer dealer;
	@Column(name="amount")
	private int amount;
	

	public int getIncentiveId() {
		return incentiveId;
	}

	public void setIncentiveId(int incentiveId) {
		this.incentiveId = incentiveId;
	}

	public BookingDetails getBooking() {
		return booking;
	}

	public void setBooking(BookingDetails booking) {
		this.booking = booking;
	}

	public CustomerDetails getCustdetails() {
		return custdetails;
	}

	public void setCustdetails(CustomerDetails custdetails) {
		this.custdetails = custdetails;
	}

	public CarDealer getDealer() {
		return dealer;
	}

	public void setDealer(CarDealer dealer) {
		this.dealer = dealer;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "IncentiveDetails [incentiveId=" + incentiveId + ", booking=" + booking + ", custdetails=" + custdetails
				+ ", dealer=" + dealer + ", amount=" + amount + ", getIncentiveId()=" + getIncentiveId()
				+ ", getBooking()=" + getBooking() + ", getCustdetails()=" + getCustdetails() + ", getDealer()="
				+ getDealer() + ", getAmount()=" + getAmount() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	
}
