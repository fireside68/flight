package com.cooksys.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@Column(name="date_created")
	private Date dateCreated;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name="itinerary_flights",
			joinColumns=@JoinColumn(name="itinerary_id", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="trip_id", referencedColumnName="id"))
	private List<Trip> flights;

	public Itinerary() {
		super();
	}
	
	public Itinerary(Long id, User user) {
		this.id = id;
		this.user = user;
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
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public List<Trip> getFlights() {
		return flights;
	}

	public void setFlights(List<Trip> flights) {
		this.flights = flights;
	}
	
	

}
