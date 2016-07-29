package com.cooksys.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="itinerary")
public class Itinerary {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToMany
	@JoinTable(
			name="itinerary_flights",
			joinColumns=@JoinColumn(name="itinerary_id", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="trip_id", referencedColumnName="id"))
	private List<Trip> flights;

	public Itinerary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Itinerary(Long id, User user, List<Trip> flights) {
		this.id = id;
		this.user = user;
		this.flights = flights;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Trip> getFlights() {
		return flights;
	}

	public void setFlights(List<Trip> flights) {
		this.flights = flights;
	}
	
	

}
