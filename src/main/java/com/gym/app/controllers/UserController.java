package com.gym.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.app.entities.User;
import com.gym.app.repositories.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/all")
	public List<User> getAll()
	{
		return userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public User getById(@PathVariable("id") String id)
	{
		Optional<User> rs = userRepository.findById(id);
		return rs.get();
	}
	
	@PutMapping("/add")
	public User add(@RequestBody User user)
	{
		return userRepository.insert(user);
	}
	
	@PostMapping("/update")
	public User update(@RequestBody User user)
	{
		return userRepository.save(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") String id)
	{
		userRepository.deleteById(id);
	}
}
