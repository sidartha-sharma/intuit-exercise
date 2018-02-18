package com.intuit.exercise.marketplace.controller;

import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuit.exercise.marketplace.controller.MarketplaceController;
import com.intuit.exercise.marketplace.dto.BidProjectRequestDto;
import com.intuit.exercise.marketplace.dto.BidProjectResponseDto;
import com.intuit.exercise.marketplace.dto.CreateProjectRequestDto;
import com.intuit.exercise.marketplace.dto.CreateProjectResponseDto;
import com.intuit.exercise.marketplace.dto.GetProjectByIdResponseDto;
import com.intuit.exercise.marketplace.dto.ShowProjectsResponseDto;
import com.intuit.exercise.marketplace.service.MarketPlaceService;

public class MarketplaceControllerTest {

	private MockMvc mockMvc;

	@Mock
	private MarketPlaceService marketPlaceService;

	@InjectMocks
	private MarketplaceController marketplaceController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(marketplaceController).build();

	}

	@Test
	public void createProject() throws Exception {

		CreateProjectRequestDto createProjectRequestDto = new CreateProjectRequestDto();

		CreateProjectResponseDto createProjectResponse = new CreateProjectResponseDto();
		createProjectResponse.setProjectId(1);

		Mockito.when(marketPlaceService.createProject(any(CreateProjectRequestDto.class)))
				.thenReturn(createProjectResponse);

		mockMvc.perform(post("/marketplace/createproject").content(asJsonString(createProjectRequestDto))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());

	}

	@Test
	public void getPojectById() throws Exception {

		GetProjectByIdResponseDto response = new GetProjectByIdResponseDto();
		response.setProjectDescription("test");

		Mockito.when(marketPlaceService.getProjectById(1L)).thenReturn(response);

		mockMvc.perform(get("/marketplace/project/{id}", 1)).andExpect(status().isOk())
				.andExpect(content().string(asJsonString(response)));

	}

	@Test
	public void showProjects() throws Exception {

		ShowProjectsResponseDto response = new ShowProjectsResponseDto();
		response.setMaxBudget(400);

		List<ShowProjectsResponseDto> showProjectResponse = new ArrayList<ShowProjectsResponseDto>();
		showProjectResponse.add(response);

		Mockito.when(marketPlaceService.showprojects()).thenReturn(showProjectResponse);

		mockMvc.perform(get("/marketplace/showprojects")).andExpect(status().isOk())
				.andExpect(content().string(asJsonString(showProjectResponse)));

	}

	@Test
	public void placeBid() throws Exception {

		BidProjectResponseDto response = new BidProjectResponseDto();
		response.setBidId(1L);

		Mockito.when(marketPlaceService.placeBid(any(BidProjectRequestDto.class))).thenReturn(response);

		mockMvc.perform(post("/marketplace/placebid").content(asJsonString(new BidProjectRequestDto()))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
				.andExpect(content().string(asJsonString(response)));

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
