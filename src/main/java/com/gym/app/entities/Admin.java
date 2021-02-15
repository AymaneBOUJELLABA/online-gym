package com.gym.app.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Admin")
public class Admin extends User
{
	@Id
	private String id;
	
	private String user_id;
	
	public Admin() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String name, String email, String dateOfBirth, String cin, String password, String role_id,
			List<String> gymclasses, String user_id)
	{
		super(name, email, dateOfBirth, cin, password, role_id, gymclasses);
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
	
	public String getUser_id() 
	{
		return user_id;
	}

	public void setUser_id(String user_id)
	{
		this.user_id = user_id;
	}

	
	
	
}
