package com.intuit.exercise.marketplace.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.intuit.exercise.marketplace.service.MarketPlaceService;

@Component
public class MarketPlaceScheduler {
	
	@Autowired
	private MarketPlaceService marketPlaceService;
	
	@Scheduled(cron="* */2 * * * *")
	public void assignProject() {
		
		marketPlaceService.assignProject();
		
	}
	
	
}
