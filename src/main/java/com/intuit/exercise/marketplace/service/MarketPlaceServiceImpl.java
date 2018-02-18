package com.intuit.exercise.marketplace.service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intuit.exercise.marketplace.domain.Bid;
import com.intuit.exercise.marketplace.domain.Project;
import com.intuit.exercise.marketplace.dto.BidProjectRequestDto;
import com.intuit.exercise.marketplace.dto.BidProjectResponseDto;
import com.intuit.exercise.marketplace.dto.CreateProjectRequestDto;
import com.intuit.exercise.marketplace.dto.CreateProjectResponseDto;
import com.intuit.exercise.marketplace.dto.GetProjectByIdResponseDto;
import com.intuit.exercise.marketplace.dto.ShowProjectsResponseDto;
import com.intuit.exercise.marketplace.enums.ProjectSatusEnum;
import com.intuit.exercise.marketplace.exception.MarketplaceException;
import com.intuit.exercise.marketplace.repository.BidRepository;
import com.intuit.exercise.marketplace.repository.MarketPlaceRepository;
import com.intuit.exercise.marketplace.transformer.MarketPlaceTransformer;

@Service
public class MarketPlaceServiceImpl implements MarketPlaceService {

	@Autowired
	private MarketPlaceRepository marketPlaceRepository;

	@Autowired
	private BidRepository bidRepository;

	@Autowired
	private MarketPlaceTransformer transformer;

	public CreateProjectResponseDto createProject(CreateProjectRequestDto projectDto) {

		Project project = transformer.transformCreateProjectDto(projectDto);

		marketPlaceRepository.save(project);

		CreateProjectResponseDto response = new CreateProjectResponseDto();

		response.setProjectId(project.getId());

		return response;

	}

	public List<ShowProjectsResponseDto> showprojects() {

		List<Project> openProjects = marketPlaceRepository.findAll().stream()
				.filter(p -> p.getProjectStatus().equals(ProjectSatusEnum.OPEN)).collect(Collectors.toList());

		return openProjects.stream().map(p -> transformer.getShowProjectsResponse(p)).collect(Collectors.toList());

	}

	public BidProjectResponseDto placeBid(BidProjectRequestDto bidProjectRequestDto) {

		Integer bidAmount = bidProjectRequestDto.getBidAmount();

		Project project = marketPlaceRepository.findOne(bidProjectRequestDto.getProjectId());

		BidProjectResponseDto bidResponse = new BidProjectResponseDto();

		MarketplaceException marketplaceException = null;

		if (project == null) {
			marketplaceException = new MarketplaceException("Incorrect project id .Project does not exit.");
			throw marketplaceException;

		} else if (project.getDeadineForBids().compareTo(new Date()) < 0) {

			marketplaceException = new MarketplaceException("Too late: Bidding window has already closed");
			throw marketplaceException;

		} else if (project.getMaxBid() < bidAmount) {

			marketplaceException = new MarketplaceException(
					"Incorrect bid. Bid amount is greater than maximum allowed bid");
			throw marketplaceException;
		}

		Bid bid = new Bid();

		bid.setBidAmount(bidAmount);
		bid.setBidTime(new Date());
		bid.setBidderId(bidProjectRequestDto.getBidderId());
		project.getBids().add(bid);

		bidRepository.save(bid);
		marketPlaceRepository.save(project);

		bidResponse.setBidId(bid.getId());
		bidResponse.setBidCreateTime(bid.getBidTime());

		return bidResponse;

	}

	public GetProjectByIdResponseDto getProjectById(Long id) {

		Project project = marketPlaceRepository.findOne(id);
		
		if (project == null) {
			MarketplaceException marketplaceException = new MarketplaceException("Incorrect project id. Project does not exit.");
			throw marketplaceException;

		}

		GetProjectByIdResponseDto getProjectByIdResponse = transformer.getProjectByIdResponse(project);

		if (!project.getBids().isEmpty() && project.getProjectStatus().equals(ProjectSatusEnum.CLOSED)) {

			project.getBids().sort(new BidCompartor());
			getProjectByIdResponse.setLowestBid(project.getBids().get(0).getBidAmount());
		}

		return getProjectByIdResponse;

	}

	public void assignProject() {

		Date currentDateTime = new Date();

		List<Project> projects = marketPlaceRepository.findAll().stream()
				.filter(p -> p.getProjectStatus().equals(ProjectSatusEnum.OPEN))
				.filter(p -> p.getDeadineForBids().compareTo(currentDateTime) < 0).collect(Collectors.toList());

		for (Project project : projects) {

			project.setProjectStatus(ProjectSatusEnum.CLOSED);

			List<Bid> bids = project.getBids();
			if (!bids.isEmpty()) {
				bids.sort(new BidCompartor());
				project.setBidWinnerId(bids.get(0).getId());
				
				marketPlaceRepository.save(project);
			}
		}
	}

}

class BidCompartor implements Comparator<Bid> {

	@Override
	public int compare(Bid bid1, Bid bid2) {

		if (bid1.getBidAmount() != bid2.getBidAmount())
			return bid1.getBidAmount() - bid2.getBidAmount();
		else
			return bid1.getBidTime().compareTo(bid2.getBidTime());

	}

}