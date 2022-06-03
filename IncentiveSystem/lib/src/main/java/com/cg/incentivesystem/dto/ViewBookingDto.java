package com.cg.incentivesystem.dto;

public class ViewBookingDto {
	private int chassisno;
	private int cardealerId;
	private int customerId;
	private int bookingId;
	
	public int getChassisno() {
		return chassisno;
	}
	public void setChassisno(int chassisno) {
		this.chassisno = chassisno;
	}
	public int getCardealerId() {
		return cardealerId;
	}
	public void setCardealerId(int cardealerId) {
		this.cardealerId = cardealerId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	@Override
	public String toString() {
		return "ViewBookingDto [chassisno=" + chassisno + ", cardealerId=" + cardealerId + ", customerId=" + customerId
				+ ", bookingId=" + bookingId + "]";
	}
	
}
