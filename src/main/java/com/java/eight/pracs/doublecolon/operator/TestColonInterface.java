package com.java.eight.pracs.doublecolon.operator;

public interface TestColonInterface {
	
	void m1();
	
	//uncommenting this line will throw compile error -> :: operator is applicable only for functional interface.
	//FUnctional Interface must have only one abstract method. :: is alternate to lambda expression.
//	void m4();
	
	public static void getReturnString(String input)
	{
		System.out.println("Your Input String: "+input);
	}

}
