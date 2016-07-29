package com.cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByUsername(String username);
	
	public User findByUsernameAndPassword(String username, String password);
	
	public User findByFirstNameAndLastName(String firstName, String lastName);
	
	public User findByEmail(String email);
	
	public List<User> findAll();
	
	public User findByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);
	

}
