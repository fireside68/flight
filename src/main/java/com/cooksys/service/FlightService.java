package com.cooksys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cooksys.component.FlightGenerator;
import com.cooksys.entity.Edge;
import com.cooksys.entity.Itinerary;
import com.cooksys.entity.Trip;
import com.cooksys.entity.Vertex;
import com.cooksys.model.Dijkstra;
import com.cooksys.pojo.Flight;

@Service
public class FlightService {

	@Autowired
	FlightGenerator generator;

	private ArrayList<Flight> flightList = new ArrayList<>();
	private Logger log = LoggerFactory.getLogger(FlightService.class);
	
	public ArrayList<Flight> getDailyFlightList()
	{
		return flightList;
	}
	
	//The fixedDelay parameter determines how often a new day is generated as expressed in milliseconds
	@Scheduled(fixedDelay=5000)
	private void refreshFlights()
	{
		flightList = generator.generateNewFlightList();
	}
	
	public Itinerary getFlightPath(String origin, String destination) {
		List<Edge> edges = new ArrayList<>();
		Map<String, Vertex> vertexes = new HashMap<>();
		List<Vertex> nodes = new ArrayList<>();
		Vertex vertex = new Vertex("orlando", "orlando");
		vertexes.put("orlando", vertex);
		nodes.add(vertex);
		vertex = new Vertex("tallahassee", "tallahassee");
		vertexes.put("tallahassee", vertex);
		nodes.add(vertex);
		vertex = new Vertex("jacksonville", "jacksonville");
		vertexes.put("jacksonville", vertex);
		nodes.add(vertex);
		vertex = new Vertex("miami", "miami");
		vertexes.put("miami", vertex);
		nodes.add(vertex);
		for(Flight flight : flightList){
			Vertex start = vertexes.get(flight.getOrigin().toLowerCase());
			Vertex end = vertexes.get(flight.getDestination().toLowerCase());
			Edge edge = new Edge("Edge_" + start + end, start, end, (int)flight.getFlightTime(), (int)flight.getOffset());
			edges.add(edge);
		}
		log.info("Edges: {}", edges);
		Dijkstra algorithm = new Dijkstra(nodes, edges);
		algorithm.execute(vertexes.get(origin.toLowerCase()));
		log.info("Start: {}", vertexes.get(origin.toLowerCase()));
		log.info("End: {}", vertexes.get(destination.toLowerCase()));
		List<Vertex> path = algorithm.getPath(vertexes.get(destination.toLowerCase()));
		log.info("Path: {}", path);
		log.info("{}", path.size());
		List<Trip> flights = new ArrayList<>();
		if(path != null){
			for(int i = 1; i < path.size(); i++){
				for(Flight flight : flightList){
					if(flight.getOrigin().toLowerCase().equals(path.get(i-1).getName())){
						if(flight.getDestination().toLowerCase().equals(path.get(i).getName())){
							log.info("Flight: {}", flight);
							Trip leg = new Trip();
							leg.copy(flight);
							flights.add(leg);
						}
					}
				}
			}
		}
		
		Itinerary itinerary = new Itinerary();
		itinerary.setFlights(flights);
		for(Trip tripp : flights) {
			log.info("{}", tripp.toString());
		}
		return itinerary;
	}
	
}
