package com.spring.auto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	
	
	//to pick and choose a specific bean, use @Qualifier
	@Autowired
	@Qualifier("indian") //bean name must be lower case of the actual classname that is being called
	private IMenu menu; //similar to menu = new Indian();
	
	
	//if the instance variable is same as that of the bean name
	//autowiring by name
	@Autowired
	private IMenu italian; //italian = new Italian
	
	
	//autowiring by constructor //no need of @Autowired above this. It will be injected automatically
	private IMenu newMenu;
	
	//since the IMenu has 3 implementation classes, we need to mention @Qualifier in cons parameter

	public Restaurant(@Qualifier("chinese") IMenu newMenu) {
		super();
		this.newMenu = newMenu;
	}


	public List<String> showMenu(String choice){
		List<String> menuItems = new ArrayList<>();
		
		if(choice.equalsIgnoreCase("in"))
			menuItems = menu.ItemsAvailable();
		else if(choice.equalsIgnoreCase("it"))
			menuItems = italian.ItemsAvailable();
		else if(choice.equalsIgnoreCase("ch"))
			menuItems = newMenu.ItemsAvailable();
		else
			menuItems = Arrays.asList("No items available");
		
		return menuItems;
		
	}

}
