package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.Itinerary;
import com.cooksys.model.BookingResponseModel;
import com.cooksys.service.ItineraryService;

@RestController
@RequestMapping("itinerary")
public class ItineraryController {
	
	@Autowired
	private ItineraryService itinServ;
	
	@RequestMapping(value="/updateItinerary", method=RequestMethod.POST)
	public void updateItinerary(@RequestBody BookingResponseModel model){
		itinServ.addItinerary(model);
	}
	
	@RequestMapping(value="/getItinerary/{id}")
	public List<Itinerary> getItinerary(@PathVariable Long id){
		return itinServ.getItinerary(id);
	}

}
