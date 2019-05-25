package com.selenium.testproject.testproject;

public class Pattern1 {

	public static void main(String[] args) {

		int num = 10;

		// Pattern 1
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("********************************************************");

		// Pattern 2
		for (int i = 1; i < num; i++) {

			for (int j = num; j >= i; j--) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print(" *");
			}
			System.out.println();
		}

		System.out.println("********************************************************");

		// Pattern 3
		for (int i = 1; i < num; i++) {

			for (int j = num; j >= i; j--) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print(" " + k);
			}
			System.out.println();
		}
		
		System.out.println("********************************************************");

		// Pattern 4
		for (int i = 1; i < num; i++) {

			for (int j = num; j >= i; j--) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print(" " + i);
			}
			System.out.println();
		}
	}

}
