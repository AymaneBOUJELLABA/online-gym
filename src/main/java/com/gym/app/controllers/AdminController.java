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

import com.gym.app.entities.Admin;
import com.gym.app.repositories.AdminRepository;

@RestController
@RequestMapping("/admin")
public class AdminController
{
	@Autowired
	AdminRepository adminRepository;
	
	@GetMapping("/all")
	public List<Admin> getAll()
	{
		return adminRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Admin getById(@PathVariable("id") String id)
	{
		Optional<Admin> rs = adminRepository.findById(id);
		return rs.get();
	}
	
	@PutMapping("/add")
	public Admin add(@RequestBody Admin admin)
	{
		return adminRepository.insert(admin);
	}
	
	@PostMapping("/update")
	public Admin update(@RequestBody Admin admin)
	{
		return adminRepository.save(admin);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") String id)
	{
		adminRepository.deleteById(id);
	}
}
