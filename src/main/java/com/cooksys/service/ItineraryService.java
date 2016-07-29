package com.cooksys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.Itinerary;
import com.cooksys.repository.ItineraryRepository;

@Service
public class ItineraryService {
	
	@Autowired
	private ItineraryRepository repo;
	
	public Itinerary updateItinerary(Itinerary itinerary){
		repo.save(itinerary);
		return itinerary;
	}
}
