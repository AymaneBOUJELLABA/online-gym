package com.gym.app.entities;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Role")
public class Role 
{
	@Id
	private String id;
	
	@Indexed(unique=true, direction = IndexDirection.DESCENDING, dropDups= true)
	private String role;
	
	
	
	protected Role() 
	{	
		super();	
	}
	
	

	public Role(String id, String role) {
		super();
		this.id = id;
		this.role = role;
	}



	public String getId()
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getRole() 
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}
	
	
	
}
