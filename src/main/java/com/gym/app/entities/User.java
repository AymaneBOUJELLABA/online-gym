package com.gym.app.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="User")
public class User 
{
	@Id
	private String id;
	private String name;
	private String email;
	private String DateOfBirth;
	private String cin;
	private String password;
	
	private String role_id;
	private List<String> gymclasses;
	
	protected User () 
	{	
		super();
		this.gymclasses = new ArrayList<String>();
		
	}
	public User(String name, String email, String dateOfBirth, String cin, String password, String role_id,
			List<String> gymclasses) {
		super();
		this.name = name;
		this.email = email;
		DateOfBirth = dateOfBirth;
		this.cin = cin;
		this.password = password;
		this.role_id = role_id;
		this.gymclasses = gymclasses;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getDateOfBirth() 
	{
		return DateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) 
	{
		DateOfBirth = dateOfBirth;
	}
	public String getCin() 
	{
		return cin;
	}
	public void setCin(String cin) 
	{
		this.cin = cin;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getRole_id() 
	{
		return role_id;
	}
	public void setRole_id(String role_id) 
	{
		this.role_id = role_id;
	}
	public List<String> getGymclasses() 
	{
		return gymclasses;
	}
	public void setGymclasses(List<String> gymclasses) 
	{
		this.gymclasses = gymclasses;
	}
	
	
	
	
	
}
