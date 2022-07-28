package com.hackerrank.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyOfCharacters {
	
	public static void main(String[] args) {
		String inputString = "cats";
		
		int length = inputString.length();
		
		Map<Character, Integer> frequencyMap = new HashMap<>();
		
		for(int i =0; i<length; i++)
		{
			//System.out.println(inputString.charAt(i));
			
			Character c = inputString.charAt(i);
			if(frequencyMap.containsKey(c))
			{
				int count = frequencyMap.get(c) + 1;
				frequencyMap.put(c, count);
			}
			else
			{
				frequencyMap.put(c, 1);
			}
		}
		
		List<Character> list = new ArrayList<>();
		for(Map.Entry<Character, Integer> entry : frequencyMap.entrySet())
		{
			if(entry.getValue() > 1)
			{
				list.add(entry.getKey());
			}
		}
		
		System.out.println("Input String: " +inputString);
		System.out.println("Repeated Characters: " +list);
		int count = list.isEmpty()  ? 1 : list.size() ;
		System.out.println("No of repeated characters"+ " " +count);
		
	}

}
