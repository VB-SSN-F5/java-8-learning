package com.interview.learning.examples;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 91759
 * Employee Reminder Service to remind employees to complete the mandatory trainings.
 */
public class CompletableExample3 {
	
public static void main(String[] args) {
		
		File file = new File("D:\\Studies\\JEE\\STS\\workspace/java-eight-pracs/src/main/java/com/interview/learning/examples/employeedetails.json");
		CompletableExample3 c = new CompletableExample3();
		c.sendReminderToEmployees(file);
	}

public void sendReminderToEmployees(File file)
{
	Supplier<List<EmployeeDetails>> employeesSupplier = () -> {
		System.out.println("Fetch Employees: " +Thread.currentThread().getName());
		return fetchEmployees(file);
	};
	
	//Executor executor = Executors.newFixedThreadPool(1);
	
	CompletableFuture completableFuture = CompletableFuture.supplyAsync(
			employeesSupplier/* , executor */)
	  .thenApply(employees -> employees.stream()
			     .filter(emp -> emp.isNewJoiner()).collect(Collectors.toList()))
	  .thenApply(employees -> employees.stream()
			     .filter(emp -> emp.isTrainingPending()).collect(Collectors.toList()))
	  .thenApply(employees -> employees.stream().map(emp -> emp.getEmailID()).collect(Collectors.toList()))
	  .thenAccept((emails) -> emails.forEach(email -> sendEmail(email)));
	
	//thenApplyAsync and thenAcceptAsync can be used for AsynExecution
	try {
		completableFuture.get();
	} catch (InterruptedException | ExecutionException e) {
		e.printStackTrace();
	}
}

public void sendEmail(String email)
{
	System.out.println("Sending Email to : " +email);
}


public List<EmployeeDetails> fetchEmployees(File jsonFile)
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
