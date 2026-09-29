package com.basics.constructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Department {
	
	private String deptName;
	private int deptId;
	
	
	public String getDeptName() {
		return deptName;
	}
	
	@Value("CS")
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getDeptId() {
		return deptId;
	}
	
	@Value("123")
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	

	@Override
	public String toString() {
		return "Department [deptName=" + deptName + ", deptId=" + deptId + "]";
	}
	
	

}
