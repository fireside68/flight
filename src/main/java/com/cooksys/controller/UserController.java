package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.Itinerary;
import com.cooksys.entity.User;
import com.cooksys.model.LoginResponse;
import com.cooksys.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	@RequestMapping("/getUserById/{id}")
	public @ResponseBody User getUserById(Long id){
		return userServ.getUserById(id);
	}
	
	@RequestMapping("lookupEmail/{email}")
	public @ResponseBody User findByEmail(@PathVariable String email){
		return userServ.findByEmail(email);
	}
	
	@RequestMapping(value = "/lookupUsername/{username}")
	public @ResponseBody User findByUsername(@PathVariable String username){
		return userServ.findByUsername(username);
	}
	
	@RequestMapping("/listAllUsers")
	public @ResponseBody List<User> listAllUsers(){
		return userServ.listAllUsers();
	}
	
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public User loginUser(@RequestBody User user){
		System.out.println(user.toString());
		return userServ.loginUser(user);
	}
	
	@RequestMapping(value="/addNewUser", method=RequestMethod.POST)
	public @ResponseBody User addNewUser(@RequestBody User user){
		return userServ.addNewUser(user);
	}
	
	@RequestMapping(value="/updateUser", method=RequestMethod.POST)
	public @ResponseBody User updateUser(@RequestBody User user){
		return userServ.updateUser(user);
	}
	
	@RequestMapping(value="/getItinerary")
	public @ResponseBody List<Itinerary> getItinerary(String username){
		return userServ.getItinerary(username);
	}
	
}
