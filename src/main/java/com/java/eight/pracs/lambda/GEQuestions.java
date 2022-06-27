package com.java.eight.pracs.lambda;

public class GEQuestions {
	
	public static void main(String[] args) {
		String inputStr = "This is a swap string";

		String[] splitStr = inputStr.split(" ");

		StringBuilder result = new StringBuilder();
		
		for(String str : splitStr)
		{
			char c = str.charAt(0);
			char cLast = str.charAt(str.length()-1);
			System.out.println(c + " " +cLast);
			
			String s3 = str.substring(1,str.length());
			
			result.append(cLast).append(s3).append(c).append(" ");
		}
//		char c = inputStr.charAt(0);
//		char cLast = inputStr.charAt(inputStr.length()-1);
//		System.out.println(c + " " +cLast);
		
		//String s1 = inputStr.substring(0);
	    //String s2 = inputStr.substring(inputStr.length()-1, inputStr.length());
	  
//	   String s3 = inputStr.substring(1,inputStr.length());
//	   result.append(cLast).append(s3).append(c);

	   //result.append(s2).append(s3).append(s1).toString();

//		for(String s : splitStr)
//		{
//		  String s1 = s.substring(0);
//		    String s2 = s.substring(s.length()-1, s.length());
//		  
//		   String s3 = s.substring(1,s.length());
//
//		   result.append(s2).append(s3).append(s1).toString();
//		}
		
		System.out.println(result);
	}

}
