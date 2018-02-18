package com.intuit.exercise.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.exercise.marketplace.dto.BidProjectRequestDto;
import com.intuit.exercise.marketplace.dto.BidProjectResponseDto;
import com.intuit.exercise.marketplace.dto.CreateProjectRequestDto;
import com.intuit.exercise.marketplace.dto.CreateProjectResponseDto;
import com.intuit.exercise.marketplace.dto.ExceptionResponseDto;
import com.intuit.exercise.marketplace.dto.GetProjectByIdResponseDto;
import com.intuit.exercise.marketplace.dto.ShowProjectsResponseDto;
import com.intuit.exercise.marketplace.exception.MarketplaceException;
import com.intuit.exercise.marketplace.service.MarketPlaceService;

@RestController
@ControllerAdvice
@RequestMapping(value="/marketplace")
public class MarketplaceController {

	@Autowired
	MarketPlaceService service;

	@RequestMapping(value = "/createproject", method = RequestMethod.POST)
	public ResponseEntity<CreateProjectResponseDto> createProject(@RequestBody CreateProjectRequestDto projectDto) {

		CreateProjectResponseDto response = service.createProject(projectDto);

		return new ResponseEntity<CreateProjectResponseDto>(response, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/showprojects", method = RequestMethod.GET)
	public ResponseEntity<List<ShowProjectsResponseDto>> getProjects() {

		List<ShowProjectsResponseDto> projects = service.showprojects();

		return new ResponseEntity<List<ShowProjectsResponseDto>>(projects, HttpStatus.OK);
	}

	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
	public ResponseEntity<GetProjectByIdResponseDto> getProjectById(@PathVariable Long id) {

		GetProjectByIdResponseDto getProjectByIdResponse = service.getProjectById(id);

		return new ResponseEntity<GetProjectByIdResponseDto>(getProjectByIdResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/placebid", method = RequestMethod.POST)
	public ResponseEntity<BidProjectResponseDto> placeBid(@RequestBody BidProjectRequestDto bidProjectRequestDto) {

		BidProjectResponseDto bidProjectResponse = service.placeBid(bidProjectRequestDto);

		return new ResponseEntity<BidProjectResponseDto>(bidProjectResponse, HttpStatus.CREATED);
	}

	@ExceptionHandler(MarketplaceException.class)
	public ResponseEntity<ExceptionResponseDto> handleException(MarketplaceException e) {

		ExceptionResponseDto response = new ExceptionResponseDto(e.getLocalizedMessage());

		return new ResponseEntity<ExceptionResponseDto>(response, HttpStatus.BAD_REQUEST);
	}

}
