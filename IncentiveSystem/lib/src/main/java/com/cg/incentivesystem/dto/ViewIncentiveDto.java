package com.cg.incentivesystem.dto;

public class ViewIncentiveDto {
	
	private int incentiveId;
	private String comments;
	private double incentiveAmount;
	private String Status;
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
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "ViewIncentiveDto [incentiveId=" + incentiveId + ", comments=" + comments + ", incentiveAmount="
				+ incentiveAmount + ", Status=" + Status + "]";
	}
	

}
