package com.interview.learning.examples;

import java.util.Optional;

public class TestOptional {
	
	public static void main(String[] args) {
		
		//EmployeeDetails emp = new EmployeeDetails(7, "Trisha", "Pune", 35);
		EmployeeDetails emp = new EmployeeDetails(7, null, "Pune", 35);
		
		/* Optional.ofNullable(emp.getName()) ---> creates Optional<String> */
		/* getDefaultName() method will be called by orElse method even tough name is not null */
		//String name = Optional.ofNullable(emp.getName()).orElse(getDefaultName());
		
		/* getDefaultName() method will be called by orElseGet method only if the name is null */
		//String name = Optional.ofNullable(emp.getName()).orElseGet(() -> getDefaultName());
		
		/* Throw Exception  orElseThrow() or orElseThrow(Supplier<T> */
		//String name = Optional.ofNullable(emp.getName()).orElseThrow();
		String name = Optional.ofNullable(emp.getName()).orElseThrow(() -> new NullPointerException("Name cannot be null"));
		
		System.out.println("Name -> "+name);
	}
	
	public static String getDefaultName()
	{
		System.out.println("Default Name method called");
		return "VB";
	}
}
