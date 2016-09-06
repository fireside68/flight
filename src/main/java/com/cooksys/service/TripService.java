package com.cooksys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.Trip;
import com.cooksys.pojo.Flight;
import com.cooksys.repository.TripRepository;

@Service
public class TripService {
	
	@Autowired
	private TripRepository repo;
	
	public void addTrip(Flight flight){
		Trip trip = new Trip();
		trip.copy(flight);
		repo.save(trip);
	}

}
