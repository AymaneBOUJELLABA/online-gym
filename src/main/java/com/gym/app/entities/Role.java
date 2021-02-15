package com.gym.app.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Role")
public class Role 
{
	@Id
	private String id;
	private String name;
	private List<String> users;
	
	protected Role() 
	{	
		super();
		this.users = new ArrayList<String>();
		
	}
	
	public Role(String name, List<String> users)
	{
		super();
		this.name = name;
		this.users = users;
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
	public List<String> getUsers() 
	{
		return users;
	}
	public void setUsers(List<String> users) 
	{
		this.users = users;
	}
	
	
}
