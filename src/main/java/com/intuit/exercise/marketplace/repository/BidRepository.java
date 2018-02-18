package com.intuit.exercise.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intuit.exercise.marketplace.domain.Bid;

public interface BidRepository extends JpaRepository<Bid, Long> {

}
