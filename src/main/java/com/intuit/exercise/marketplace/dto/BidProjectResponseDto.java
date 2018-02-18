package com.intuit.exercise.marketplace.dto;

import java.util.Date;

public class BidProjectResponseDto {
	
	private Long bidId;
	
	private Date bidCreateTime;

	public Long getBidId() {
		return bidId;
	}

	public void setBidId(Long bidId) {
		this.bidId = bidId;
	}

	public Date getBidCreateTime() {
		return bidCreateTime;
	}

	public void setBidCreateTime(Date bidCreateTime) {
		this.bidCreateTime = bidCreateTime;
	}
	
	
	
}
