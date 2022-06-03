package com.cg.incentivesystem.dto;

public class ViewIncentiveDto {
	
	private int incentiveId;
	private String comments;
	private double incentiveAmount;
	private String status;
	
	
	
	public int getIncentiveId() {
		return incentiveId;
	}
	public void setIncentiveId(int incentiveId) {
		this.incentiveId = incentiveId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
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
	@Override
	public String toString() {
		return "ViewIncentiveDto [incentiveId=" + incentiveId + ", comments=" + comments + ", incentiveAmount="
				+ incentiveAmount + ", Status=" + status + "]";
	}
	

}
