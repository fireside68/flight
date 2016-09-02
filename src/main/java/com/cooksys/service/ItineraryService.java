package com.cooksys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.Itinerary;
import com.cooksys.entity.User;
import com.cooksys.model.BookingResponseModel;
import com.cooksys.repository.ItineraryRepository;
import com.cooksys.repository.UserRepository;

@Service
public class ItineraryService {
	
	@Autowired
	private ItineraryRepository repo;
	
	@Autowired
	private UserRepository userRepo;
	
	public void updateItinerary(Itinerary itinerary){
		repo.save(itinerary);
	}
	
	public List<Itinerary> getItinerary(Long userId){
		return repo.findByUserId(userId);
	}

	public void addItinerary(BookingResponseModel model) {
		User user = userRepo.findOne(model.getUserId());
		Itinerary itinerary = new Itinerary();
		itinerary.setUser(user);
		itinerary.setFlights(model.getTrip());
		repo.save(itinerary);		
	}
}
