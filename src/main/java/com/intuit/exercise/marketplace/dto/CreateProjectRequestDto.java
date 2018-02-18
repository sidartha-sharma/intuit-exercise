package com.intuit.exercise.marketplace.dto;

import java.util.Date;

public class CreateProjectRequestDto {

	private String projectDescription;
	
	private int maxBudget;
	
	private String projectStatus;

	private Date deadineForBids;
	
	private String sellerId;
	
	private String sellerName;

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public int getMaxBudget() {
		return maxBudget;
	}

	public void setMaxBudget(int maxBudget) {
		this.maxBudget = maxBudget;
	}


	public Date getDeadineForBids() {
		return deadineForBids;
	}

	public void setDeadineForBids(Date deadineForBids) {
		this.deadineForBids = deadineForBids;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	
	
	
}
