package com.training.model;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class JwtUser implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	@Id
	@GeneratedValue
	private Integer jwtuserId;
	private String password;
	private String email;
	
	@ElementCollection
	@CollectionTable(name="user_roles",joinColumns = @JoinColumn(name = "jwtuser_id"))
	private Set<String> roles; //set - to have unique values//role is nothing but the authorities in User class

//User user; User is a class that implements UserDetails interface. User class provides built in help for authentications.
//But we will use our own class and implement UserDetails interface.
	
	
	
//roles has to be returned as GrantedAuthority
//"admin" => type of granted authority.
//to do this, we have to type cast our set of String - roles to GrantedAuthority.
//GrantedAuthority is an interface. So we can't directly use it. 
//We need to use some class that implements it which is SimpleGrantedAuthority buildin class	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//convert one by one string role into a granted authority object
		return roles.stream()
			.map(role-> new SimpleGrantedAuthority(role))
			.collect(Collectors.toSet());
		
		
	}
	
	

}
