package com.intuit.exercise.marketplace.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.intuit.exercise.marketplace.enums.ProjectSatusEnum;

@Entity
public class Project {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String projectDescription;
	
	private int maxBid;
	
	private Date deadineForBids;
	
	private String sellerId;
	
	private Long bidWinnerId;
	
	private String sellerName;
	

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Bid> bids = new ArrayList<Bid>();

	@Enumerated(EnumType.STRING)
	private ProjectSatusEnum projectStatus;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public int getMaxBid() {
		return maxBid;
	}

	public void setMaxBid(int maxBid) {
		this.maxBid = maxBid;
	}

	

	public Date getDeadineForBids() {
		return deadineForBids;
	}

	public void setDeadineForBids(Date deadineForBids) {
		this.deadineForBids = deadineForBids;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	public ProjectSatusEnum getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(ProjectSatusEnum projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public Long getBidWinnerId() {
		return bidWinnerId;
	}

	public void setBidWinnerId(Long bidWinnerId) {
		this.bidWinnerId = bidWinnerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

}

