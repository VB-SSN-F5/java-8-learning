package com.interview.learning.examples;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 91759
 * RunAsync Demo
 * Reference: https://www.youtube.com/watch?v=GJ5Tx43q6KM&t=1s
 */
public class CompletableExample {
	
	public static void main(String[] args) {
		
		File file = new File("D:\\Studies\\JEE\\STS\\workspace/java-eight-pracs/src/main/java/com/interview/learning/examples/employeedetails.json");
		try {
			saveEmployees(file);
			saveEmployeesWithCustomExecutor(file);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void saveEmployees(File jsonFile) throws InterruptedException, ExecutionException
	{
		ObjectMapper mapper = new ObjectMapper();
		
		CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
			try 
			{
				List<EmployeeDetails> listofEmployees = mapper.readValue(jsonFile, new TypeReference<List<EmployeeDetails>>() {
				});
				
				System.out.println("Thread: " +Thread.currentThread().getName());
				listofEmployees.stream().forEach(emp -> System.out.println(emp));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		});
		
		completableFuture.get();
	}
	
	
	public static void saveEmployeesWithCustomExecutor(File jsonFile) throws InterruptedException, ExecutionException
	{
		ObjectMapper mapper = new ObjectMapper();
		
		Executor executor = Executors.newFixedThreadPool(5); //custom thread
		
		CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
			try 
			{
				List<EmployeeDetails> listofEmployees = mapper.readValue(jsonFile, new TypeReference<List<EmployeeDetails>>() {
				});
				
				System.out.println("Thread: " +Thread.currentThread().getName());
				listofEmployees.stream().forEach(emp -> System.out.println(emp));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}, executor);
		
		completableFuture.get();
	}

}
