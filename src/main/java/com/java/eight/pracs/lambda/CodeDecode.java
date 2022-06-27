package com.java.eight.pracs.lambda;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CodeDecode {
	
	public static void main(String[] args) {
		Predicate<Employee> empNameCheck = e->e.getEmpName().isEmpty();
		Predicate<Employee> empLocationCheck = e->e.getEmpLocation().isEmpty();
		
		Employee emp = new Employee();
		emp.setEmpName("");
		emp.setEmpLocation("Chennai");
		
		boolean result = empNameCheck.and(empLocationCheck).test(emp);
		
		boolean result2 = empNameCheck.and(empLocationCheck).negate().test(emp);
		
		System.out.println("Result : " +result);
		System.out.println("Result2 : " +result2);
		
		//Function Interface with "andThen() method example"
		Function<String, Employee> f1 = empName->new Employee(empName);
		Function<Employee, String> f2 = employee -> "Hello " +employee.getEmpName();
		System.out.println(f1.andThen(f2).apply("Vijaya Balaji Soundararajan"));
		
		
//		For compose() method reverse the input and return type of f1 and f2 and try.
		
		//Consumer == method that takes arguments but returns nothing (void return type)
		Consumer<Employee> consumer = (empl) -> empl.setEmpLocation("Chennai");
		Consumer<Employee> consumer2 = empl-> System.out.println("Employee's Working location is " +empl.getEmpLocation());
		
		consumer.andThen(consumer2).accept(emp); //the object type of both consumers should be of same type
		//No compose() method in Comsumer
		
		//Supplier == method that takes nothing (no args method) but returns object (return object)
		Supplier<Date> getCurrentDateSupplier = () -> new Date();
		System.out.println("Today's Date is " +getCurrentDateSupplier.get());
		//No Chaining in Supplier
		
		//Tried on my own -> consumer and supplier
		Consumer<Supplier<Date>> printDate = supplier -> System.out.println("Today's Date using Consumer & Supplier is " +supplier.get());
		printDate.accept(getCurrentDateSupplier);
		
	}

}
