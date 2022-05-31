package com.cg.incentivesystem.entites;

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
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
@Table(name = "cardetails")
public class CarDetails {
	@Id
	@SequenceGenerator(name = "chassis_seq", initialValue = 12000290, sequenceName = "chassis_seq", allocationSize = 2)
	@GeneratedValue(generator = "chassis_seq", strategy = GenerationType.SEQUENCE)
	private int chassisNumber;
	@Column(length = 100)
	private String specification;
	@Column
	private int carPrice;
	@Column(length=30)
	private String carModel;
	@ManyToOne
	@JoinColumn(name = "companyId")
	private CarCompany carCom;
	@OneToOne(mappedBy = "carDetails")
	private BookingDetails bookingDetails;
	
	
	
	
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
	public BookingDetails getBookingDetails() {
		return bookingDetails;
	}
	public void setBookingDetails(BookingDetails bookingDetails) {
		this.bookingDetails = bookingDetails;
	}
	public int getChassisNumber() {
		return chassisNumber;
	}
	public void setChassisNumber(int chassisNumber) {
		this.chassisNumber = chassisNumber;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public CarCompany getCarCom() {
		return carCom;
	}
	public void setCarCom(CarCompany carcomp) {
		this.carCom = carcomp;
	}
	@Override
	public String toString() {
		return "CarDetails [chassisNumber=" + chassisNumber + ", specification=" + specification + ", carPrice="
				+ carPrice + ", carModel=" + carModel + ", carCom=" + carCom + ", bookingDetails=" + bookingDetails
				+ ", getCarPrice()=" + getCarPrice() + ", getCarModel()=" + getCarModel() + ", getBookingDetails()="
				+ getBookingDetails() + ", getChassisNumber()=" + getChassisNumber() + ", getSpecification()="
				+ getSpecification() + ", getCarCom()=" + getCarCom() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	} 
	
}
