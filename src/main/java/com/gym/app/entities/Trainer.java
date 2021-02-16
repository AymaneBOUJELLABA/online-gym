package com.gym.app.entities;

import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Trainer")
public class Trainer extends User 
{
	
	private String speciality;
	

	public Trainer() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Trainer(String name, String email, String dateOfBirth, String cin, String password, Set<Role> roles,
			List<String> gymclasses, String speciality) 
	{
		super(name, email, dateOfBirth, cin, password, roles, gymclasses);
		this.speciality = speciality;
		// TODO Auto-generated constructor stub
	}

	public String getSpeciality() 
	{
		return speciality;
	}

	public void setSpeciality(String speciality)
	{
		this.speciality = speciality;
	}

	
	

}
