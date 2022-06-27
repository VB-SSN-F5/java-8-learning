package com.java.eight.pracs.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TestStream {
	
	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("Hi");
		l.add("Hello");
		l.add("Vijay");
		l.add("adsfdfjfftuiuyqw");
		
		Predicate<String> predicate = s->s.length()>=5;
		
		Stream s = l.stream().filter(predicate);
		System.out.println(s.count());
		
		//-> Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
//		System.out.println(s.count()); 
		
		Function<String, Integer> function = str -> str.length();
		Stream s1 = l.stream().map(function);
		System.out.println(s1.count());
		
		Stream s2 = l.stream().map(str -> {
			String input = str + "DONE";
			
			//this will not print due to lazy loading of intermediate streams and terminal (ex: forEach) operation is commented below
			System.out.println("Test type... to know multi lines inside lambda exp is allowed"); 
			return input + "Heloooooo";
		});
//		s2.forEach(x -> System.out.println(x));
		
		
	}

}
