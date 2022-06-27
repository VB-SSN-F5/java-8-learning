package com.java.eight.pracs.interview.samples;

public class Test {
	
	public static void main(String... args) {
		StringBuffer str = new StringBuffer("Hello");
		System.out.println(str);
		StringBuffer str2 = str.append(new StringBuffer("world"));
		System.out.println(str);
		System.out.println(str2);
		
		main("Hello");
		System.out.println("Main Method");
		
		Sample s = new Sample();
		s.m1(args);
	}
	
	public static void main(String args) {
		System.out.println("Overloaded main called with input "+args);
		
		try
		{
		 System.out.println(10/0);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Finally");
		}
	}

}
