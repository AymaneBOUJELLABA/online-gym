package com.gym.app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "videos")
public class Video
{
	@Id
	private String id;
	
	private String title;
	private String filepath;
	private String gymclass_id;
	
	public Video()
	{
		super();
	}
	public Video(String title, String url,String gymclass_id)
	{
		super();
		this.title = title;
		this.filepath = url;
		this.gymclass_id = gymclass_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String url) {
		this.filepath = url;
	}
	public String getGymclass_id() {
		return gymclass_id;
	}
	public void setGymclass_id(String gymclass_id) {
		this.gymclass_id = gymclass_id;
	}
}
