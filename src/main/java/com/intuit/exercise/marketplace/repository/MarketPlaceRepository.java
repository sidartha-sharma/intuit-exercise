package com.intuit.exercise.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intuit.exercise.marketplace.domain.Project;

public interface MarketPlaceRepository extends JpaRepository<Project, Long> {

}
