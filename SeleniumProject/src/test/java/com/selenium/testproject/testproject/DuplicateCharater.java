package com.selenium.testproject.testproject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateCharater {

	public static void main(String[] args) {
		
		System.out.print("Enter the string to analyze: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		char strArr[] = input.toCharArray();
		
		//Using HashSet
		/*Set<Character> charSet = new LinkedHashSet<Character>();
		for(char c: strArr) {
			charSet.add(c);
		}*/
		
		//Using ArrayList
		ArrayList<Character> charSet = new ArrayList();
		for(char ch: strArr) {
			if(!charSet.contains(ch)) {
				charSet.add(ch);
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(char ch: charSet) {
			sb.append(ch);
		}
		
		System.out.println("Final output string is: " +sb.toString());
	}

}
