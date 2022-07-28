package com.some.general.questions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Vowels {

	public static void main(String[] args) {
		String word = "Welcome to Java";
		 //findVowelsCount(word);
		 findVowels(word);
		
	}
	
	public static void findVowelsCount(String word)
	{
		int vowelsCount = 0;
		List<Character> vowels = Arrays.asList('a','e','i','o','u');
		
		for(int i =0; i< word.length(); i++)
		{
			Character c = word.charAt(i);
			vowelsCount = vowels.contains(c) ? vowelsCount+1 : vowelsCount;
		}
		
		System.out.println("No of Vowels: "+ vowelsCount);
	}
	
	public static void findVowels(String word)
	{
		List<Character> vowels = Arrays.asList('a','e','i','o','u');
		
		Predicate<Character> testVowels = c -> vowels.contains(c);
		
		for(int i =0; i< word.length(); i++)
		{
			Character character = word.charAt(i);
			boolean result = testVowels.test(character);
			 
			if(result)
			{
				System.out.println(character);
			}
		}
	}
}
