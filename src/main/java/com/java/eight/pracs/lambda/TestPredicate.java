package com.java.eight.pracs.lambda;

import java.util.function.Predicate;

public class TestPredicate {
	
	public static void main(String[] args) {
		Predicate<String> p = s->(s.length()>10);
		Predicate<String> p2 = s->(s.isEmpty());
		
		/*
		 * boolean b = p.test("Hello"); boolean b1 = p.test("NivethaMentalu");
		 * 
		 * System.out.println(b); System.out.println(b1);
		 */
		
		Predicate<Employee> empPredicate = e-> e.getLocation().isEmpty();
		System.out.println(empPredicate.test(new Employee()));
		
		//Predicate Joining
		System.out.println("Predicate Joining"); 
		/*
		 * Predicate<String> joiningPredicate =
		 * p.or(p2); System.out.println(joiningPredicate.test("Hi"));
		 * System.out.println(joiningPredicate.negate());
		 */
		
		int x[] = {1,2,3};
		Predicate<Integer> p3 = i->i<=10;
		Predicate<Integer> p4 = i->i%2==0;
		for(Integer i: x)
		{
			System.out.println("P3: " +p3.test(i));
			System.out.println("P4: " +p4.test(i));
			Predicate<Integer> joinPred = p3.and(p4);
			System.out.println("Joining Result for number " +i +" is " +joinPred.test(10));
		}
	}

}
