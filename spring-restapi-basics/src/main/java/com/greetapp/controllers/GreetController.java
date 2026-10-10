package com.greetapp.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
	
	
	@GetMapping("/show")
	String showMessage() {
		return "Welcome. Have a great day!";
	}
	
//	@GetMapping("/greet{name}")
//	String greetUser(@PathVariable("name") String userName) {
//		return "Welcome " +userName;
//	}
	
	//or
	
	@GetMapping("/greet{userName}")
	String greetUser(@PathVariable String userName) {
		return "Welcome " +userName;
	}
	
	@GetMapping("/show-books")
	List<String> showBooks(){
		return Arrays.asList("Java","Angular","Spring");
	}
	
	@GetMapping("/print")
	String printDetails(@RequestParam("username") String name,@RequestParam("city") String city){
		return "Hellow " + name + ". Welcome to " + city + ". ";
	}

}
