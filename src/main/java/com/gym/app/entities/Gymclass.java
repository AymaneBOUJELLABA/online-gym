package com.gym.app.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection ="Gymclasses")
public class Gymclass
{
	@Id
	private String id;
	private String name;
	private String trainer_id;
	private List<String> videos;// list of IDs
	
	public Gymclass(String name, String trainer_id,List<String> videos)
	{
		super();
		this.name = name;
		this.trainer_id = trainer_id;
		this.videos = videos;
	}

	protected Gymclass() 
	{
		super();
		videos = new ArrayList<String>();
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getTrainer_id()
	{
		return trainer_id;
	}

	public void setTrainer_id(String trainer_id)
	{
		this.trainer_id = trainer_id;
	}

	public List<String> getVideos() {
		return videos;
	}

	public void setVideos(List<String> videos) {
		this.videos = videos;
	}
	
}
