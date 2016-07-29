package com.cooksys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.Itinerary;
import com.cooksys.service.ItineraryService;

@RestController
@RequestMapping("itinerary")
public class ItineraryController {
	
	@Autowired
	private ItineraryService itinServ;
	
	@RequestMapping(value="/updateItinerary", method=RequestMethod.POST)
	public @ResponseBody Itinerary updateItinerary(@RequestBody Itinerary itinerary){
		return itinServ.updateItinerary(itinerary);
	}

}
