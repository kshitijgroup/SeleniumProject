package com.selenium.testproject.testproject;

import java.util.*;
import java.util.Map.Entry;

public class DuplicateElementsArray {

	public static void main(String[] args) {

		// Brute Force method
		int arr[] = { 2, 4, 3, 7, 4, 9, 7, 4 };
		System.out.println("Duplicate elements are: ");

		System.out.println("Using Brute Force: ");
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j] && (i != j)) {
					System.out.print(arr[i] + ",");
				}

			}
		}
		
		System.out.println();
		System.out.println("****************************************");

		// Using HastSet
		System.out.println("Using HashSet: ");
		Set<Integer> intSet = new HashSet<Integer>();
		for (int num : arr) {
			if (intSet.add(num) == false) {
				System.out.print(num + ",");
			}
		}
		
		System.out.println();
		System.out.println("****************************************");

		// Using HashMap/HashTable
		System.out.println("Using HashMap/HashTable: ");
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int num : arr) {
			if (hm.get(num) != null) {
				hm.put(num, hm.get(num) + 1);
			} else {
				hm.put(num, 1);
			}
		}
		
		//Set<Integer> intSet1 = hm.keySet();
		Set<Map.Entry<Integer, Integer>> intSet1 = hm.entrySet();
		for(Map.Entry<Integer, Integer> i: intSet1) {
			if(i.getValue()>1){
				System.out.print(i.getKey() + ",");
			}
		}
	}
}
