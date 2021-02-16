package com.gym.app.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="User")
public class User 
{
	@Id
	private String id;
	private String name;
	
	@Indexed(unique=true, direction = IndexDirection.DESCENDING, dropDups= true)
	private String email;
	private String password;
	
	private String DateOfBirth;
	private String cin;
	
	@DBRef
	private Set<Role> roles = new HashSet<>();
	private List<String> gymclasses;
	
	public User()
	{
		super();
	}
	
	public User(String name, String email, String dateOfBirth, String cin, String password, Set<Role> roles,
			List<String> gymclasses) {
		super();
		this.name = name;
		this.email = email;
		DateOfBirth = dateOfBirth;
		this.cin = cin;
		this.password = password;
		this.roles =roles;
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
	
	public Set<Role> getRoles() 
	{
		return roles;
	}
	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
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
