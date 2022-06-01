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

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	@JsonBackReference
	private CustomerDetails custdetails;
	@ManyToOne
	@JoinColumn(name = "dealerid")
	@JsonBackReference
	private CarDealer dealer;
	@Column(name="incentiveAmount")
	private double incentiveAmount;
	@Column(name = "status")
	private String status;
	@Column(name="comments")
	private String comments;
	

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

	@Override
	public String toString() {
		return "IncentiveDetails [incentiveId=" + incentiveId + ", booking=" + booking + ", custdetails=" + custdetails
				+ ", dealer=" + dealer + ", incentiveAmount=" + incentiveAmount + ", status=" + status + ", comments="
				+ comments + "]";
	}



	public double getIncentiveAmount() {
		return incentiveAmount;
	}

	public void setIncentiveAmount(double incentiveAmount) {
		this.incentiveAmount = incentiveAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public CarDealer getDealer() {
		return dealer;
	}

	public void setDealer(CarDealer dealer) {
		this.dealer = dealer;
	}


	
	
}
