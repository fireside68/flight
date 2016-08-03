package com.cooksys.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.Itinerary;
import com.cooksys.pojo.Flight;
import com.cooksys.service.FlightService;
import com.cooksys.service.LocationService;

@RestController
@RequestMapping("flights")
public class FlightsController {
	
	@Autowired
	LocationService locationService;
	
	@Autowired
	FlightService flightService;
	
	@RequestMapping
	public ArrayList<Flight> getFlightList()
	{
		return flightService.getDailyFlightList();
	}
	
	@RequestMapping(value = "/getItinerary")
	public Itinerary getItinerary(@RequestParam("from") String origin, @RequestParam("to") String dest){
		return flightService.getFlightPath(origin, dest);
	}


}
