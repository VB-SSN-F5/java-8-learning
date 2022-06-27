package com.java.eight.pracs.defaultmethods;

public interface InterStatic {

	public static String sayHello()
	{
		return "Hello";
	}
	
	public static void main(String[] args) {
		System.out.println("Main method inside nterface is allowed from java 8");
	}
}
