package com.selenium.testproject.testproject;

public class ElementAppearingOnceInArray {

	public static void main(String[] args) {
		
		int arr[]= {2,3,4,3,4,2,9};
		
		int res = arr[0];
		for(int i=1;i<arr.length;i++) {
			res = res^arr[i];
		}
		System.out.println("Unique element in array is: " +res);

	}

}
