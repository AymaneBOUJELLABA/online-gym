package com.gym.app.entities;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Admin")
public class Admin extends User
{
	
	public Admin() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String name, String email, String dateOfBirth, String cin, String password, String role_id,
			List<String> gymclasses)
	{
		super(name, email, dateOfBirth, cin, password, role_id, gymclasses);
	
		// TODO Auto-generated constructor stub
	}


	
	
	
}
