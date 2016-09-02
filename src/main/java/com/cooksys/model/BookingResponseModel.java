package com.cooksys.model;

import java.util.List;

import com.cooksys.entity.Trip;

public class BookingResponseModel {
	
	private List<Trip> trip;
	private long userId;
	
	public BookingResponseModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingResponseModel(List<Trip> trip, long userId) {
		this.trip = trip;
		this.userId = userId;
	}

	public List<Trip> getTrip() {
		return trip;
	}

	public void setTrip(List<Trip> trip) {
		this.trip = trip;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	

}
