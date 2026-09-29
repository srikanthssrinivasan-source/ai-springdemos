package com.spring.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		//create IoC container
		ApplicationContext context = new AnnotationConfigApplicationContext("com.spring");
		
		Employee employee = (Employee) context.getBean("employee");
		System.out.println(employee);
		
		//get the bean from IocContainer
		

	}

}
