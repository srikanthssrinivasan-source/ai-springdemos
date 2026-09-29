package com.basics.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	private String name;
	private int empId;
	private double salary;
	
	
	private Address address;
	
	
	public Address getAddress() {
		return address;
	}
	
	@Autowired
	public void setAddress(Address address) {
		this.address = address;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int empId, double salary) {
		super();
		this.name = name;
		this.empId = empId;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}
	
	@Value("${employee.name}")
	public void setName(String name) {
		this.name = name;
	}

	public int getEmpId() {
		return empId;
	}
	
	@Value("${employee.empId}")
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public double getSalary() {
		return salary;
	}
	
	@Value("${employee.salary}")
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", empId=" + empId + ", salary=" + salary + ", address=" + address + "]";
	}
	
	
	
	
	

}
