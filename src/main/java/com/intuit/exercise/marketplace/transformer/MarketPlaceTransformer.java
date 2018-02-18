package com.intuit.exercise.marketplace.transformer;

import org.springframework.stereotype.Component;

import com.intuit.exercise.marketplace.domain.Project;
import com.intuit.exercise.marketplace.dto.CreateProjectRequestDto;
import com.intuit.exercise.marketplace.dto.GetProjectByIdResponseDto;
import com.intuit.exercise.marketplace.dto.ShowProjectsResponseDto;
import com.intuit.exercise.marketplace.enums.ProjectSatusEnum;

@Component
public class MarketPlaceTransformer {

	public Project transformCreateProjectDto(CreateProjectRequestDto projectDto) {

		Project project = new Project();

		project.setProjectDescription(projectDto.getProjectDescription());
		project.setMaxBid(projectDto.getMaxBudget());
		project.setProjectStatus(ProjectSatusEnum.OPEN);
		project.setDeadineForBids(projectDto.getDeadineForBids());
		project.setSellerId(projectDto.getSellerId());
		project.setSellerName(projectDto.getSellerName());

		return project;
	}

	public ShowProjectsResponseDto getShowProjectsResponse(Project project) {

		ShowProjectsResponseDto showProjectsResponseDto = new ShowProjectsResponseDto();

		showProjectsResponseDto.setProjectDescription(project.getProjectDescription());
		showProjectsResponseDto.setMaxBudget(project.getMaxBid());
		showProjectsResponseDto.setProjectStatus(project.getProjectStatus().toString());
		showProjectsResponseDto.setDeadineForBids(project.getDeadineForBids());

		return showProjectsResponseDto;
	}

	public GetProjectByIdResponseDto getProjectByIdResponse(Project project) {

		GetProjectByIdResponseDto getProjectByIdResponse = new GetProjectByIdResponseDto();

		getProjectByIdResponse.setProjectDescription(project.getProjectDescription());
		getProjectByIdResponse.setMaxBudget(project.getMaxBid());
		getProjectByIdResponse.setProjectStatus(project.getProjectStatus().toString());

		return getProjectByIdResponse;

	}
}
