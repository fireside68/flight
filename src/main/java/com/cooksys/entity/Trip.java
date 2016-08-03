package com.cooksys.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.cooksys.pojo.Flight;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="trip")
public class Trip {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="origin")
	private String origin;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="flight_time")
	private Long flightTime;
	
	@Column(name="offset")
	private Long offset;
	
	@ManyToMany(mappedBy="flights")
	@JsonIgnore
	private List<Itinerary> itineraries;

	public Trip() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Trip(String origin, String destination, Long flightTime, Long offset) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.flightTime = flightTime;
		this.offset = offset;
	}



	public Trip(Long id, String origin, String destination, Long flightTime, Long offset) {
		this.id = id;
		this.origin = origin;
		this.destination = destination;
		this.flightTime = flightTime;
		this.offset = offset;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Long getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(Long flightTime) {
		this.flightTime = flightTime;
	}

	public Long getOffset() {
		return offset;
	}

	public void setOffset(Long offset) {
		this.offset = offset;
	}

	public List<Itinerary> getItineraries() {
		return itineraries;
	}

	public void setItineraries(List<Itinerary> itineraries) {
		this.itineraries = itineraries;
	}
	
	public void transfer(Flight flight){
		this.origin = flight.getOrigin();
		this.destination = flight.getDestination();
		this.flightTime = flight.getFlightTime();
		this.offset = flight.getOffset();
	}

}
