package com.cooksys.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.Itinerary;
import com.cooksys.entity.Trip;
import com.cooksys.entity.User;
import com.cooksys.model.BookingResponseModel;
import com.cooksys.repository.ItineraryRepository;
import com.cooksys.repository.TripRepository;
import com.cooksys.repository.UserRepository;

@Service
public class ItineraryService {
	
	@Autowired
	private ItineraryRepository repo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TripRepository tripRepo;
	
	public void updateItinerary(Itinerary itinerary){
		Itinerary nouveau = new Itinerary();
		nouveau.setFlights(itinerary.getFlights());
		nouveau.setUser(itinerary.getUser());
		nouveau.setDateCreated(new Date());
		for(Trip trip : itinerary.getFlights()){
			Trip go = new Trip();
			go.setOrigin(trip.getOrigin());
			go.setDestination(trip.getDestination());
			go.setFlightTime(trip.getFlightTime());
			go.setOffset(trip.getOffset());
			go.setDateCreated(new Date());
			tripRepo.save(go);
		}
		repo.save(nouveau);
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
