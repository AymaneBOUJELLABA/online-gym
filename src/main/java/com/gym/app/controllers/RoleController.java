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

import com.gym.app.entities.Role;
import com.gym.app.repositories.RoleRepository;

@RestController
@RequestMapping("/role")
public class RoleController
{
	 @Autowired
	 RoleRepository roleRepository;
	 
	 @GetMapping("/all")
		public List<Role> getAll()
		{
			return roleRepository.findAll();
		}
		
		@GetMapping("/{id}")
		public Role getById(@PathVariable("id") String id)
		{
			Optional<Role> rs = roleRepository.findById(id);
			return rs.get();
		}
		
		@PutMapping("/add")
		public Role add(@RequestBody Role role)
		{
			return roleRepository.insert(role);
		}
		
		@PostMapping("/update")
		public Role update(@RequestBody Role role)
		{
			return roleRepository.save(role);
		}
		
		@DeleteMapping("/delete/{id}")
		public void delete(@PathVariable("id") String id)
		{
			roleRepository.deleteById(id);
		}
	 
}
