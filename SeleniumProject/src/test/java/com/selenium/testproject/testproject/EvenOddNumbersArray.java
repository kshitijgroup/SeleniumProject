package com.selenium.testproject.testproject;

import java.util.ArrayList;

public class EvenOddNumbersArray {

	public static void main(String[] args) {

		int arr[] = {2,5,3,7,8,4,5};
		int total1 = 0, total2 = 0;
		
		ArrayList<Integer> al1 = new ArrayList<>();
		ArrayList<Integer> al2 = new ArrayList<>();
		
		for(int i=0;i< arr.length-1;i++) {
			if(i%2==0) {
				al1.add(i);
				total1 = total1 + i;
			}
			else {
				al2.add(i);
				total2 = total2 + i;
			}
		}
		
		System.out.println("Even numbers in array are: " +al1.size());
		for(Integer i: al1) {
			System.out.print(i +",");
		}
		
		System.out.println();
		System.out.println("Sum of all Even numbers in array is: " +total1);
		
		System.out.println("**********************************************");
		
		System.out.println("Odd numbers in array are: " +al2.size());
		for(Integer i: al2) {
			System.out.print(i +",");
		}
		
		System.out.println();
		System.out.println("Sum of all Odd numbers in array is: " +total2);
	}

}
