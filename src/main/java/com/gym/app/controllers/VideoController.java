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

import com.gym.app.entities.Video;
import com.gym.app.repositories.VideoRepository;

@RestController
@RequestMapping("/videos")
public class VideoController
{
	@Autowired
	private VideoRepository videorepo;
	
	@GetMapping("/all")
	public List<Video> getAll()
	{
		return videorepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Video getById(@PathVariable("id") String id)
	{
		Optional<Video> rs = videorepo.findById(id);
		return rs.get();
	}
	
	@PutMapping("/add")
	public Video add(@RequestBody Video video)
	{
		return videorepo.insert(video);
	}
	
	@PostMapping("/update")
	public Video update(@RequestBody Video video)
	{
		return videorepo.save(video);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") String id)
	{
		videorepo.deleteById(id);
	}

}
