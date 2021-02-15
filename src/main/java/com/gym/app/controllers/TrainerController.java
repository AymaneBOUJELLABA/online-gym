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

import com.gym.app.entities.Trainer;
import com.gym.app.repositories.TrainerRepository;

@RestController
@RequestMapping("/trainer")
public class TrainerController 
{
	@Autowired
	TrainerRepository trainerRepository;
	
	@GetMapping("/all")
	public List<Trainer> getAll()
	{
		return trainerRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Trainer getById(@PathVariable("id") String id)
	{
		Optional<Trainer> rs = trainerRepository.findById(id);
		return rs.get();
	}
	
	@PutMapping("/add")
	public Trainer add(@RequestBody Trainer trainer)
	{
		return trainerRepository.insert(trainer);
	}
	
	@PostMapping("/update")
	public Trainer update(@RequestBody Trainer trainer)
	{
		return trainerRepository.save(trainer);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") String id)
	{
		trainerRepository.deleteById(id);
	}
}
