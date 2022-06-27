package com.interview.questions;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateNumbers {
	
	public static void main(String[] args) {
		
		//Remove duplicate number in an array
		forIntegerArray();
		forIntArray();
	}
	
	/**
	 * Remove duplicate numbers in array if the input is Integer[]
	 */
	public static void forIntegerArray()
	{
		System.out.println("***********If the input is Integer[]**************");
		Integer[] array = {1,1,2,3,2,4,5,4};
		List<Integer> list = Arrays.asList(array);
		Set<Integer> set = list.stream().collect(Collectors.toSet());
		set.stream().forEach((x -> System.out.println(x)));
	}
	
	/**
	 * Remove duplicate numbers in array if the input is int[]
	 * boxed() converts int elements in the stream to Integer elements
	 * set removes the duplicate numbers in the array
	 */
	public static void forIntArray()
	{
		System.out.println("***********If the input is int[]**************");
		int[] array = {1,1,2,3,2,4,5,4};
		Set<Integer> result = Arrays.stream(array).boxed().collect(Collectors.toSet());
		result.stream().forEach(x -> System.out.println(x));
	}
	
//	public static void intStreamExample()
//	{
//		int[] array = {1,1,2,3,2,4,5,4};
//		IntStream intStream = Arrays.stream(array);
//		System.out.println(Arrays.stream(array).sum());
//		System.out.println(Arrays.stream(array).min());
//		System.out.println(Arrays.stream(array).max());
//		System.out.println(Arrays.stream(array).average());
//	}

}
