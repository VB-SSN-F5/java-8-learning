package com.interview.learning.examples;

import java.util.Objects;

public class EmployeeDetails {
	
	private int id;
	
	private String name;
	
	private String location;
	
	private int experience;
	
	private boolean newJoiner;
	
	private boolean trainingPending;
	
	private String emailID;
	
	

	public EmployeeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDetails(int id, String name, String location, int experience) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.experience = experience;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		//Alternate way
//		final int prime = 31;
//		int result = 0;
//		result = prime * result + ((name!= null) ? name.hashCode() : 0);
//		return result;
		
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDetails other = (EmployeeDetails) obj;
		
		if(!name.equals(other.name))
		{
			return false;
		}
		return true;
		//alternate way for above if condition
		//return Objects.equals(name, other.name);
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public boolean isNewJoiner() {
		return newJoiner;
	}

	public void setNewJoiner(boolean newJoiner) {
		this.newJoiner = newJoiner;
	}

	public boolean isTrainingPending() {
		return trainingPending;
	}

	public void setTrainingPending(boolean trainingPending) {
		this.trainingPending = trainingPending;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [id=" + id + ", name=" + name + ", location=" + location + ", experience=" + experience
				+ ", newJoiner=" + newJoiner + ", trainingPending=" + trainingPending + ", emailID=" + emailID + "]";
	}
	
	

}
