package com.java.eight.pracs.doublecolon.operator;

public class DoubleColon {

	public static void main(String[] args) {
		TestColonInterface t = ()-> System.out.println("Hello from reference t");
		
		DoubleColon d = new DoubleColon();
		TestColonInterface t2 = d::m2; //reusing the same code instead of implementing using lambda expression
		
		t.m1();
		t2.m1();
		TestColonInterface t3 = DoubleColon::m3;//reusing the same code instead of implementing using lambda expression
		t3.m1();
	}
	
	public void m2()
	{
		System.out.println("Hello From reference t2");
	}
	
	public static void m3()
	{
		System.out.println("Hello From reference t3");
	}
	

}
