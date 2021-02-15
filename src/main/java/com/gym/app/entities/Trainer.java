package com.gym.app.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Trainer")
public class Trainer extends User 
{
	
	@Id
	private String id;
	private String speciality;
	
	private String user_id;

	public Trainer() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Trainer(String name, String email, String dateOfBirth, String cin, String password, String role_id,
			List<String> gymclasses, String speciality, String user_id) 
	{
		super(name, email, dateOfBirth, cin, password, role_id, gymclasses);
		this.speciality = speciality;
		this.user_id = user_id;
		// TODO Auto-generated constructor stub
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getSpeciality() 
	{
		return speciality;
	}

	public void setSpeciality(String speciality)
	{
		this.speciality = speciality;
	}

	public String getUser_id()
	{
		return user_id;
	}

	public void setUser_id(String user_id)
	{
		this.user_id = user_id;
	}
	
	

}
