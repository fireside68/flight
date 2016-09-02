package com.cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.Itinerary;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {

	public List<Itinerary> findByUserId(Long userId);
}
