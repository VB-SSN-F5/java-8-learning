package com.java.eight.pracs.hashcode;

public class Team {

	private String location;
	private String department;
	public Team(String location, String department) {
		super();
		this.location = location;
		this.department = department;
	}
	@Override
	public int hashCode() {
		
		int result = 17;
	    if (location != null) {
	        result = 31 * result + location.hashCode();
	    }
	    if (department != null) {
	        result = 31 * result + department.hashCode();
	    }
	    return result;
	    
		//return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
}
