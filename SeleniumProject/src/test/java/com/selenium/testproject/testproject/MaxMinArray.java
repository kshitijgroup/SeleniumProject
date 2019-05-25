package com.selenium.testproject.testproject;

public class MaxMinArray {
	
	public static int maxnum(int arr[]) {
		
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}	
	
	public static int minnum(int arr[]) {
		int min = arr[0];
		for(int i=1; i<arr.length;i++) {
			if(arr[i]<min) {
				min=arr[i];
			}
		}
		
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 2, 5, 3, 8, 9, 1 };
		MaxMinArray number = new MaxMinArray();
		int max = number.maxnum(arr);
		int min = number.minnum(arr);
		System.out.println("Maximum number in an array is: " +max);
		System.out.println("Minimum number in an array is: " +min);
	}
}
