package com.java.eight.pracs.lambda;

public class Employee {
	
	private EmpInterface empInterface;
	
	private String empName;
	private String empLocation;
	
	public Employee()
	{
		//Constructor written for TestPredicate class
	}
	
	public Employee(String name)
	{
		this.empName = name;
	}
	
	
	public Employee(EmpInterface empInterface)
	{
		this.empInterface = empInterface;
	}
	
	public void getMessageFromInterface(String name)
	{
		String message = empInterface.getMessage(name);
		System.out.println(message);
	}
	
	//Method written for TestPredicate class
	public String getLocation()
	{
		return "Salem";
	}

	public EmpInterface getEmpInterface() {
		return empInterface;
	}

	public void setEmpInterface(EmpInterface empInterface) {
		this.empInterface = empInterface;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpLocation() {
		return empLocation;
	}

	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}
	
	

}
