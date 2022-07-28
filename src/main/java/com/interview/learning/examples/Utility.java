package com.interview.learning.examples;

import java.util.ArrayList;
import java.util.List;

public class Utility {
	
	public static List<EmployeeDetails> getEmployees()
	{
		EmployeeDetails emp1 = new EmployeeDetails(1, "Vijay", "Chennai", 3);
		EmployeeDetails emp2 = new EmployeeDetails(2, "Rajni", "Bengaluru", 6);
		EmployeeDetails emp3 = new EmployeeDetails(3, "Ajith", "Hyderabad", 2);
		EmployeeDetails emp4 = new EmployeeDetails(4, "Shivaji", "Hyderabad", 6);
		EmployeeDetails duplicateEmp1 = new EmployeeDetails(5, "Vijay", "Chennai", 3);
		EmployeeDetails emp5 = new EmployeeDetails(6, "Kamal", "Hyderabad", 30);
		EmployeeDetails emp6 = new EmployeeDetails(7, "Trisha", "Pune", 35);
		
		List<EmployeeDetails> employeesList = new ArrayList<>();
		employeesList.add(emp1);
		employeesList.add(emp2);
		employeesList.add(emp3);
		employeesList.add(emp4);
		employeesList.add(duplicateEmp1);
		employeesList.add(emp5);
		employeesList.add(emp6);
//		Set<EmployeeDetails> employeesSet = new HashSet<EmployeeDetails>();
//		employeesSet.add(emp1);
//		employeesSet.add(duplicateEmp1);
//		System.out.println(employeesSet);
		
		return employeesList;
	}
	

}
