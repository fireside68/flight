package com.cooksys.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.Itinerary;
import com.cooksys.entity.User;
import com.cooksys.model.LoginResponse;
import com.cooksys.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public User findByUsername(String username){
		return repo.findByUsername(username);
	}


	public User findByWholeName(String firstName, String lastName){
		return repo.findByFirstNameAndLastName(firstName, lastName);
	}

	public List<User> listAllUsers(){
		return repo.findAll();
	}

	public User findByEmail(String email){
		return repo.findByEmail(email);
	}

	public User lostPassword(String firstName, String lastName, String email){
		return repo.findByFirstNameAndLastNameAndEmail(firstName, lastName, email);

	}

	public User loginUser(User user){
		User response = new User();
		if(repo.findByUsername(user.getUsername()) == null){
			response.setUsername("unregistered");
			return response;
		} else if(repo.findByUsernameAndPassword(user.getUsername(), user.getPassword()) == null){
				response.setUsername("invalid");
				return response;
			} else
				response = repo.findByUsername(user.getUsername());
				return response;
	}
	public User addNewUser(User user){
		user.setDateCreated(new Date());
		user.setDateUpdated(new Date());
		repo.save(user);
		return user;
	}

	public User updateUser(User user){
		User temp = repo.findOne(user.getId());
		temp.setId(user.getId());
		if(user.getUsername() != null){
			temp.setUsername(user.getUsername());
		}
		if(user.getPassword() != null){
			temp.setPassword(user.getPassword());
		}
		if(user.getFirstName() != null) {
			temp.setFirstName(user.getFirstName());
		}
		if(user.getLastName() != null) {
			temp.setLastName(user.getLastName());
		}
		if(user.getEmail() != null){
			temp.setEmail(user.getEmail());
		}
		temp.setItinerary(user.getItinerary());
		temp.setDateUpdated(new Date());
		repo.save(temp);
		return temp;
	}


	public List<Itinerary> getItinerary(String username) {
		User temp = repo.findByUsername(username);
		List<Itinerary> list = temp.getItinerary();
		return list;
	}


	public User getUserById(Long id) {
		return repo.findOne(id);
	}

}
