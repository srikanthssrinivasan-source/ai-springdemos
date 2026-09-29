package com.basics.constructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	
	private String studentName;
	private int studentId;
	private Department department;
	
	//department will be injected automatically
	//no need to call Autowired for Department set method
	//since we are using Contructor based Dependency Injection
	
	public Student(Department department) {
		super();
		this.department = department;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getStudentName() {
		return studentName;
	}
	
	@Value("Roops")
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentId() {
		return studentId;
	}
	
	@Value("10")
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentId=" + studentId + ", department=" + department + "]";
	}
	

}
