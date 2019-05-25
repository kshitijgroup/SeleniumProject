package com.selenium.testproject.testproject;

import java.util.HashSet;
import java.util.Set;

public class FirstDuplicateElementArray {

	public static void main(String[] args) {

		int arr[] = { 7, 5, 1, 7, 6, 6 };
		
		//Using Brute Force
		System.out.println("Using Brute Force");
		int temp = 0;
		
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					System.out.println("First duplicate Element is: " + arr[i]);
					temp = temp + 1;
					break;
				}
			}
			if (temp > 0) {
				break;
			}
		}
		
		System.out.println("**********************************");
		
		System.out.println("Using HashSet");
		//Using HasSet
		int temp1 = -1;
		Set<Integer> hs = new HashSet<>();
		for(int i=arr.length-1; i>=0;i--) {
			if(hs.contains(arr[i])) {
				temp1 = i;
			}
			else {
				hs.add(arr[i]);
			}
		}
		if(temp1!=-1) {
			System.out.println("First Duplicate Element in an Array is: " +arr[temp1]);
		}
		else {
			System.out.println("First duplicate element not found");
		}
	}	

}
