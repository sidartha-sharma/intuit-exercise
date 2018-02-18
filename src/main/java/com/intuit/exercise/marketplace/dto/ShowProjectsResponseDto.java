package com.intuit.exercise.marketplace.dto;

import java.util.Date;

public class ShowProjectsResponseDto {

	
private String projectDescription;
	
	private int maxBudget;
	
	private String projectStatus;
	
	
	private Date deadineForBids;

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
	
	
	
}
