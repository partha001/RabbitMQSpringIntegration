package com.partha.ex04;

import java.io.Serializable;

public class Employee implements Serializable{
	
	public int empid;
	public String empname;
	
	public Employee(int empid, String empname) {
		super();
		this.empid = empid;
		this.empname = empname;
	}

	
}
