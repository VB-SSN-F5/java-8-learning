package com.interview.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatingCharacters {
	
	public static void main(String[] args) {
		
		String name = "Vijaya Balaji S";
		
		withoutJavaEight(name);
		//usingJavaEight(name);
	}
	
	public static void withoutJavaEight(String name)
	{
        Map<Character, Integer> result = new HashMap<>();
		
		int nameLength = name.length();
		
		for(int i=0; i<nameLength; i++)
		{
			Character c = name.charAt(i);
			if(!c.equals(' '))
			{
				Integer res = result.containsKey(c) ? result.put(c, result.get(c)+1) : result.put(c, 1);
			}
		}
		
		result.forEach((c,i) -> System.out.println(c + " = " +i));
	}
	
	public static void usingJavaEight(String name)
	{
		String[] s = name.split("");
		
		List<String> list = Arrays.asList(s);
		
		Map<String, Integer> resultMap = new HashMap<>();
		
		list.stream().forEach(str -> resultMap.put(str, resultMap.get(str)+1));
		
		resultMap.forEach((c,i) -> System.out.println(c + " = " +i));
	}

}
