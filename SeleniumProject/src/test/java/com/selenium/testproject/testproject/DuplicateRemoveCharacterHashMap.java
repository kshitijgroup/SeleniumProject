package com.selenium.testproject.testproject;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemoveCharacterHashMap {

	public static void main(String[] args) {
				
		System.out.println("Enter the string to analyze: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		char strArr[] = input.toCharArray();
		HashMap<Character, Integer> hm = new LinkedHashMap<Character, Integer>();
		
		for(Character c: strArr) {
			if(hm.containsKey(c)) {
				hm.put(c, hm.get(c)+1);
			}
			else {
				hm.put(c, 1);
			}
		}
		
		Set<Character> values = hm.keySet();
		for(Character value: values) {
			if(hm.get(value)>1) {
				System.out.println("Character " +value + " repeats " +hm.get(value) + " times");
				hm.remove(values);
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(char c: values) {
			sb.append(c);
		}
		System.out.println("Final string is: " +sb.toString());

	}

}
