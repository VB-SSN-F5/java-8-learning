package com.interview.learning.examples;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 91759
 * SupplyAsync Demo
 */
public class CompletableExample2 {
	
	public static void main(String[] args) {
		
		File file = new File("D:\\Studies\\JEE\\STS\\workspace/java-eight-pracs/src/main/java/com/interview/learning/examples/employeedetails.json");
		
		try {
			CompletableFuture<List<EmployeeDetails>> completableFuture = CompletableFuture.supplyAsync(() -> fetchEmployees(file));
			List<EmployeeDetails> empDetails = completableFuture.get();
			empDetails.stream().forEach(emp -> System.out.println(emp));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static List<EmployeeDetails> fetchEmployees(File jsonFile)
	{
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			return mapper.readValue(jsonFile, new TypeReference<List<EmployeeDetails>>() {
				
			});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null; 
	}
}
