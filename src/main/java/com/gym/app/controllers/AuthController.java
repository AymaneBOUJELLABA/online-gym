package com.gym.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.app.entities.AuthenticationResponse;
import com.gym.app.entities.Trainer;
import com.gym.app.entities.User;
import com.gym.app.repositories.TrainerRepository;
import com.gym.app.repositories.UserRepository;
import com.gym.app.services.UserService;
import com.gym.utils.JwtUtils;


@RestController
@RequestMapping("/api/auth")
public class AuthController 
{
	@Autowired
	private TrainerRepository trainerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	
	@PostMapping("/signup/user")
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
	
	@PostMapping("/signup/trainer")
	private ResponseEntity<?> subscribeTrainer(@RequestBody com.gym.app.entities.AuthenticationRequest authenticationRequest){
		String email = authenticationRequest.getEmail();
		String password = authenticationRequest.getPassword();
		Trainer newUser = new Trainer();
		
		newUser.setEmail(email);
		newUser.setPassword(password);

		try 
		{
			trainerRepository.save(newUser);
			
		}catch(Exception e) 
		{
			return ResponseEntity.ok(new AuthenticationResponse("Error adding Client"));
		}
		
		return ResponseEntity.ok(new AuthenticationResponse(" adding Client succefuly"));
	}
	
	@PostMapping("/login")
	private ResponseEntity<?> authenticateClient(@RequestBody com.gym.app.entities.AuthenticationRequest authenticationRequest)
	{
		
		try 
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
		
		}catch(Exception e)
		{
			return ResponseEntity.ok(new AuthenticationResponse("Error login "));
		}
		
		UserDetails loadedUser = userService.loadUserByUsername(authenticationRequest.getEmail());
		
		String generatedToken = jwtUtils.generateToken(loadedUser);
		
		
		
		return ResponseEntity.ok(new AuthenticationResponse(generatedToken));
	}
}
