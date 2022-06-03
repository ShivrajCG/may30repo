package com.cg.incentivesystem.dto;

public class ViewIncentiveDetailsDto {
	private int bookingId;
	private int customerId;
	private int dealerId;
	private int incentiveId;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getDealerId() {
		return dealerId;
	}
	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}
	public int getIncentiveId() {
		return incentiveId;
	}
	public void setIncentiveId(int incentiveId) {
		this.incentiveId = incentiveId;
	}
	@Override
	public String toString() {
		return "ViewIncentiveDetailsDto [bookingId=" + bookingId + ", customerId=" + customerId + ", dealerId="
				+ dealerId + ", incentiveId=" + incentiveId + "]";
	}
	
}
