package com.cooksys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.pojo.Flight;
import com.cooksys.service.ItineraryService;
import com.cooksys.service.TripService;
import com.cooksys.service.UserService;

@RestController
@RequestMapping("trip")
public class TripController {
	
	@Autowired
	private TripService tripService;
	
	@Autowired
	private ItineraryService itineraryService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/trip", method = RequestMethod.POST)
	public void addTrip(@RequestBody Flight flight){
		tripService.addTrip(flight);
	}
	
}
