package com.selenium.testproject.testproject;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	int counter =0;
	int retrycount =2;
	public boolean retry(ITestResult result) {
		if (counter < retrycount)
		{
			counter++;
			return true;
		}
		return false;
	}

}
