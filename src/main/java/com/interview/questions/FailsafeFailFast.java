package com.interview.questions;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FailsafeFailFast {
	
	public static void main(String[] args) {
		
		//Reference: https://www.javatpoint.com/fail-fast-and-fail-safe-iterator-in-java
		
		//failFast();
		failSafe();
	}
	
	public static void failFast()
	{
		//Fail Fast
//		Map<String, String> empName = new HashMap<String, String>(); 
		Map<String, String> empName = new ConcurrentHashMap<String, String>(); 
        empName.put("Sam Hanks", "New york");   
        empName.put("Will Smith", "LA");   
        empName.put("Scarlett", "Chicago");   
        Iterator iterator = empName.keySet().iterator();   
        while (iterator.hasNext()) {   
            System.out.println(empName.get(iterator.next()));   
            // adding an element to Map   
            // exception will be thrown on next call   
            // of next() method.   
            empName.put("Istanbul", "Turkey");   
        }		   
	}
	
	public static void failSafe()
	{
		//CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>(new Integer[] { 1, 7, 9, 11 });   
        //List<Integer> list = new CopyOnWriteArrayList<>();
		Set<Integer> list = new HashSet<Integer>();
		//Set<Integer> list = new CopyOnWriteArraySet<Integer>();
		list.add(5);
        list.add(3);
        list.add(10);
        list.add(7);
        
		Iterator itr = list.iterator();   
        while (itr.hasNext()) {   
        Integer i = (Integer)itr.next();   
        System.out.println(i);   
        if (i == 7)
        {
        	list.add(15); // It will not be printed  
            //This means it has created a separate copy of the collection  
        }
     }   
	}

}
