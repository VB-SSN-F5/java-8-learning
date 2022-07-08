package com.interview.learning.examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test1 {
	
	public static void main(String[] args) {
		List<EmployeeDetails> employeesList = getEmployees();
		
		/* Group Employees by Experience */
		Map<Integer, List<EmployeeDetails>> emplGroupByExp = employeesList.stream().collect(Collectors.groupingBy(emp -> emp.getExperience()));
		System.out.println("Employees Group by Experience--> " +emplGroupByExp);
		
		/* Group Employees by Experience by remove duplicate, 
		 * If the employee name is same then it is duplicate employee object
		 * For this, override hashcode and equals only for employee name in EmployeeDetails class
		 */
		Map<Integer, Set<EmployeeDetails>> emplGroupByExp2 = employeesList.stream().collect(Collectors.groupingBy(emp -> emp.getExperience(), Collectors.toSet()));
		System.out.println("Employees Group by Experience without duplicates: \n " +emplGroupByExp2);
		
		/* Max, min, average */
		List<Integer> emplExperienceList = employeesList.stream().map(emp -> emp.getExperience()).collect(Collectors.toList());
		System.out.println("Experience List " +emplExperienceList);
//		int sumOfExp = emplExperienceList.stream().mapToInt(e -> e).sum();
//		System.out.println(sumOfExp);
		int maxExp = emplExperienceList.stream().mapToInt(e -> e).summaryStatistics().getMax();
		System.out.println(maxExp);
		int minExp = emplExperienceList.stream().mapToInt(e -> e).summaryStatistics().getMin();
		System.out.println(minExp);
		long sumOfExp = emplExperienceList.stream().mapToInt(e -> e).summaryStatistics().getSum();
		System.out.println(sumOfExp);
		
		/* Second highest Experience */
		Comparator<Integer> expCoomparator = (i1, i2) -> i2 > i1 ? 1: -1;
		List<Integer> firstHighest = emplExperienceList.stream().sorted(expCoomparator).limit(1).collect(Collectors.toList());
		System.out.println("First Highest: " +firstHighest);
		List<Integer> secondHighest = emplExperienceList.stream().sorted(expCoomparator).skip(1).limit(1).collect(Collectors.toList());
		System.out.println("Second Highest: " +secondHighest);
		
		/*Convert String (employee names to uppercase and join them with coma*/
		List<String> nameList = employeesList.stream().map(emp -> emp.getName().toUpperCase()).sorted().collect(Collectors.toList());
	    System.out.println(nameList);
	    String s1 = nameList.stream().collect(Collectors.joining());
	    System.out.println("Joined Names: " +s1);
	    
	    String s2 = nameList.stream().collect(Collectors.joining(","));
	    System.out.println("Joined Names with Comma: " +s2);
	}
	
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
