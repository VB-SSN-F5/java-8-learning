package com.java.eight.pracs.lambda;

import java.util.function.Function;

public class Lambda {
	
	public static void main(String[] args) {
		
		TestInterface i = (a,b) -> System.out.println(a+ b);		
		i.add(2, 3);
		
		Employee e = new Employee(new EmpInterface() {
			
			@Override
			public String getMessage(String name) {				
				return "Without Lambda -> Hello " +name;
			}
		});
		
		e.getMessageFromInterface("VB");
		
		Employee e2 = new Employee((name) -> {
			return "With Lambda -> Hello " +name;
			}); 
		
		e2.getMessageFromInterface("Nivetha");
		
		//Functions Interface
		Function<Integer, Integer> f = (a) ->(a+ 6);
		Integer  retVaue = f.apply(3);
		System.out.println(retVaue);
		
	}
	
}
