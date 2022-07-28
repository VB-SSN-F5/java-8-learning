package com.interview.learning.examples;

import java.util.Optional;

public class TestOPtional2 {
	
	public static void main(String[] args) {
		
		EmployeeDetails emp = new EmployeeDetails(7, "Trisha", "Pune", 35);
		//EmployeeDetails emp = new EmployeeDetails(7, null, "Pune", 35);
		
		//Optional<String> name = Optional.of(emp.getName()); //No Recommended
		Optional<String> name = Optional.ofNullable(emp.getName());
		
//		if(name.isPresent())
//		{
//			printName(name.get());
//		}
		
		//OR
		
		//name.ifPresent(n -> printName(n));
		
		//OR
		
		name.ifPresentOrElse(n -> printName(n.toUpperCase()), () -> getDefaultName());
		
		/* other methods  in Optional Class */
		System.out.println(name.isEmpty());
		
		Optional<Integer> nameLength = name.filter(n-> n != null).map(n -> n.length());
		nameLength.ifPresentOrElse(i -> System.out.println(i), () -> System.out.println(0));
	}
	
	public static void printName(String name)
	{
		System.out.println("Name -> "+name);
	}
	
	
	public static void getDefaultName()
	{
		System.out.println("Name is Null");
	}

}
