package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.auto.Restaurant;
import com.spring.javabased.Theatre;

@SpringBootApplication
public class SpringBootAssignmentsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAssignmentsApplication.class, args);
	}
	
	
	private Restaurant restaurant;
	
	@Autowired
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	@Autowired
	private Theatre theatre;

	@Override
	public void run(String... args) throws Exception {
		restaurant.showMenu("in").forEach(System.out::println);
		restaurant.showMenu("it").forEach(System.out::println);
		restaurant.showMenu("ch").forEach(System.out::println);
		
		theatre.showMovies().forEach(System.out::println);
		
	}

}
