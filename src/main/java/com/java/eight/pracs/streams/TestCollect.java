package com.java.eight.pracs.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCollect {
	
	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("Hi");
		l.add("Hello");
		l.add("Vijay");
		l.add("adsfdfjfftuiuyqw");
		
		Stream s = l.stream();
		Predicate<String> predicate = str->str.length()>5;
		List<String> result = (List<String>) s.filter(predicate).collect(Collectors.toList());
		System.out.println(result);
	}

}
