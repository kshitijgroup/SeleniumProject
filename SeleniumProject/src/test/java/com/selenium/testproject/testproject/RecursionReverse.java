package com.selenium.testproject.testproject;

public class RecursionReverse {

	public static void main(String[] args) {

		String str = "hello";
		System.out.println("Reverse string is: " + reverseStr(str));

	}

	public static String reverseStr(String str) {
		//System.out.println("**********Next loop**************");
		//System.out.println("Lenght is: " +str.length());
		if (str.length() <= 1) {
			//System.out.println("Inside termination loop: " +str);
			return str;
		}
		//System.out.println("Character at 0 position: " +str.charAt(0));
		//System.out.println("Substring is: " +str.substring(1));
		//System.out.println("Concatenated Return argument is: " +str.substring(1) +" "+ str.charAt(0));
			return reverseStr(str.substring(1)) + str.charAt(0);
		}
	}
