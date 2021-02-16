package com.gym.app.entities;

import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Admin")
public class Admin extends User
{
	
	public Admin() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String name, String email, String dateOfBirth, String cin, String password, Set<Role> roles,
			List<String> gymclasses)
	{
		super(name, email, dateOfBirth, cin, password, roles, gymclasses);
	
		// TODO Auto-generated constructor stub
	}


	
	
	
}
