package com.java.eight.pracs.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMapStreams {
	
	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("Hi");
		l.add("Hello");
		l.add("Vijay");
		l.add("adsfdfjfftuiuyqw");
		
		//Process using Functions
		Stream s = l.stream();
		Function<String, String> function = str -> str.toUpperCase();
		List<String> result = (List<String>) s.map(function).collect(Collectors.toList());
		System.out.println(result);
		
		//Sorting
		Stream s2 = result.stream();
		List<String> defaultSortedResult = (List<String>) s2.sorted().collect(Collectors.toList());
		System.out.println("After default Sorting: " +defaultSortedResult);
		
		Stream s3 = result.stream();
		Comparator<String> comparator = (o1,o2)-> o1.compareTo(o2);
		List<String> sortedResult = (List<String>) s3.sorted(comparator).collect(Collectors.toList());
		System.out.println("After Customized Sorting: " +sortedResult);
		
		Stream s4 = result.stream();
		List<String> sortedResult2 = (List<String>) s4.sorted(new MyComparator()).collect(Collectors.toList());
		System.out.println("After Customized Sorting with MyComparator: " +sortedResult2);
		
		Stream s5 = result.stream();
		System.out.println(s5.min(new MyComparator()).get());
		
		Stream s6 = result.stream();
		System.out.println(s6.max(new MyComparator()).get());
		
		System.out.println("*************For Each****************");
		result.stream().forEach(input -> System.out.println(input));
		
		System.out.println("*************For Each DoubleColon operator****************");
		result.stream().forEach(System.out::println);
		
		//reduce method
		// create a list of integers
	    List<Integer> number = Arrays.asList(2,3,4,5);
	    int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
	    System.out.println(even); 
	}

}
