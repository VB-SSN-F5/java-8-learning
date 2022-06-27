package com.java.eight.pracs.defaultmethods;

public class TestStatic implements InterStatic{
	
	public static void main(String[] args) {
		
		TestStatic t = new TestStatic();
		String hello = InterStatic.sayHello();
		System.out.println(hello);
		
		System.out.println(t.sayHello());
		//System.out.println(TestStatic.sayHello());
		
	}
	
	//it is not overriding the interface static method
	public /* static */ String sayHello()
	{
		return "Hello world";
	}

}
