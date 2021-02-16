package com.gym.app.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gym.app.entities.User;
import com.gym.app.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService
{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		User user = userRepository.findByEmail(email);
		
		if(user != null)
		{
			return buildUserForAuthentication(user, null);
		}else 
		{
			throw new UsernameNotFoundException("username not found");
		}
			
	}
	private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities)
	{
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}

}
