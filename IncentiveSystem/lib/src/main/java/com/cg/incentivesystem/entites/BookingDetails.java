package com.cg.incentivesystem.entites;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="bookingdetails")
public class BookingDetails {
	@Id
	@SequenceGenerator(name = "book_id", initialValue = 91000, sequenceName = "book_id", allocationSize = 2)
	@GeneratedValue(generator = "book_id", strategy = GenerationType.SEQUENCE)
	private int bookingId;
	@ManyToOne 
	@JoinColumn(name = "cardealerId")
	private CarDealer cardealer;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="chassisNumber",unique = true)
	private CarDetails carDetails;
	@Column(name="booking_Date")
	private Date bookingDate;
	@ManyToOne
	@JoinColumn(name="customerid")
	private CustomerDetails custdetails;
	@OneToOne(mappedBy = "booking")
	private IncentiveDetails incentive;
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
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
	public CustomerDetails getCustdetails() {
		return custdetails;
	}
	public void setCustdetails(CustomerDetails custdetails) {
		this.custdetails = custdetails;
	}
}
