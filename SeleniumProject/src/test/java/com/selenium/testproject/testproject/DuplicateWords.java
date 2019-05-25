package com.selenium.testproject.testproject;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class DuplicateWords {

	public static void main(String[] args) {
		
		System.out.print("Please enter the string to analyze: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		String sentence[] = input.split(" ");
		HashMap<String, Integer> wordmap = new LinkedHashMap<String, Integer>();

		for (String word : sentence) {
			if (wordmap.get(word) != null) {
				wordmap.put(word, wordmap.get(word)+1);
			}else {
				wordmap.put(word, 1);
			}
		}
		
		Set<String> values = wordmap.keySet();
		for(String value : values) {
			if(wordmap.get(value)>1) {
			System.out.println(value + " occurred " +wordmap.get(value) + " times");
			}
		}
	}

}
