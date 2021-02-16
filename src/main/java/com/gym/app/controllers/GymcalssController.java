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

import com.gym.app.entities.Gymclass;
import com.gym.app.repositories.GymclassRepository;

@RestController
@RequestMapping("/api/gyms")
 public class GymcalssController
{
	@Autowired
	private GymclassRepository gymclassrepo;
	
	@GetMapping("/all")
	public List<Gymclass> getAll()
	{
		return gymclassrepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Gymclass getById(@PathVariable("id") String id)
	{
		Optional<Gymclass> rs = gymclassrepo.findById(id);
		return rs.get();
	}
	
	@PutMapping("/add")
	public Gymclass add(@RequestBody Gymclass gym)
	{
		return gymclassrepo.insert(gym);
	}
	
	@PostMapping("/update")
	public Gymclass update(@RequestBody Gymclass gym)
	{
		return gymclassrepo.save(gym);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") String id)
	{
		gymclassrepo.deleteById(id);
	}
}
