package com.intuit.exercise.marketplace.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class GetProjectByIdResponseDto {
	
	private String projectDescription;
	
	private Integer maxBudget;
	
	private String projectStatus;

	private Integer lowestBid;
	
	private String lastDateTimeOfAcceptingBids;

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public Integer getMaxBudget() {
		return maxBudget;
	}

	public void setMaxBudget(Integer maxBudget) {
		this.maxBudget = maxBudget;
	}

	public Integer getLowestBid() {
		return lowestBid;
	}

	public void setLowestBid(Integer lowestBid) {
		this.lowestBid = lowestBid;
	}

	public String getLastDateTimeOfAcceptingBids() {
		return lastDateTimeOfAcceptingBids;
	}

	public void setLastDateTimeOfAcceptingBids(String lastDateTimeOfAcceptingBids) {
		this.lastDateTimeOfAcceptingBids = lastDateTimeOfAcceptingBids;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	
	

}
