package com.training.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.JwtUserRequest;

@RestController
public class JwtUserController {

	@PostMapping("/register")
	ResponseEntity<Void> registerUser(@RequestBody JwtUserRequest jwtuserRequest){
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	//user is authenticated and the token is returned back to the client
	@PostMapping("/login")
	ResponseEntity<String> authenticateUser(@RequestBody JwtUserRequest jwtuserRequest){
		
		//get the token
		String token = null;		
		//return the jwttoken to the client
		return ResponseEntity.ok(token);
	}
}	

