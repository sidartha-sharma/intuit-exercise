package com.intuit.exercise.marketplace.service;

import java.util.List;

import com.intuit.exercise.marketplace.dto.BidProjectRequestDto;
import com.intuit.exercise.marketplace.dto.BidProjectResponseDto;
import com.intuit.exercise.marketplace.dto.CreateProjectRequestDto;
import com.intuit.exercise.marketplace.dto.CreateProjectResponseDto;
import com.intuit.exercise.marketplace.dto.GetProjectByIdResponseDto;
import com.intuit.exercise.marketplace.dto.ShowProjectsResponseDto;


public interface MarketPlaceService {
	
	public CreateProjectResponseDto createProject(CreateProjectRequestDto projectDto);
	
	public  List<ShowProjectsResponseDto> showprojects();
	
	public GetProjectByIdResponseDto getProjectById(Long id);
	
	public BidProjectResponseDto placeBid(BidProjectRequestDto bidProjectRequestDto);
	
	public void assignProject();

}
