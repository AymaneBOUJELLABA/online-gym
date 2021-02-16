package com.gym.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.app.entities.AuthenticationResponse;
import com.gym.app.entities.User;
import com.gym.app.repositories.UserRepository;


@RestController
public class AuthController 
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/signup")
	private ResponseEntity<?> subscribeClient(@RequestBody com.gym.app.entities.AuthenticationRequest authenticationRequest){
		String email = authenticationRequest.getEmail();
		String password = authenticationRequest.getPassword();
		User newUser = new User();
		
		newUser.setEmail(email);
		newUser.setPassword(password);

		try 
		{
			userRepository.save(newUser);
			
		}catch(Exception e) 
		{
			return ResponseEntity.ok(new AuthenticationResponse("Error adding Client"));
		}
		
		return ResponseEntity.ok(new AuthenticationResponse("Client added succefully"));
	}
	
	@PostMapping("/login")
	private ResponseEntity<?> authenticateClient(@RequestBody com.gym.app.entities.AuthenticationRequest authenticationRequest)
	{
		
		try 
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
		
		}catch(BadCredentialsException e)
		{
			return ResponseEntity.ok(new AuthenticationResponse("Error login "));
		}
		
		return ResponseEntity.ok(new AuthenticationResponse("Client login succefully" ));
	}
}
