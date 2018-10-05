package com.selenium.testproject.testproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBaseSetUp {

	public WebDriver driver;

	
	static String driverPathIE = "drivers/iedriver/IEDriverServer.exe";
	static String driverPathChrome = "drivers/chromedriver/chromedriver.exe";

	public WebDriver getDriver() {
		return driver;
	}
	static enum BrowserType{
		ie,chrome, firefox, safari;
	}

	public void setDriver(BrowserType browserType, String appUrl) {
		
		switch (browserType) {
		case ie:
			driver = initElementsIEdriver(appUrl);
			break;
		case chrome:
			driver = initElementsChromedriver(appUrl);
			break;
		}
	}

	private WebDriver initElementsChromedriver(String appUrl) {
		System.out.println("Starting Chrome driver");
		System.setProperty("webdriver.chrome.driver", driverPathChrome);
		driver = new ChromeDriver();
		driver.navigate().to(appUrl);
		driver.manage().window().maximize();
		return driver;
	}

	private WebDriver initElementsIEdriver(String appUrl) {
		System.out.println("Starting IE driver");
		System.setProperty("webdriver.ie.driver", driverPathIE);
		driver = new InternetExplorerDriver();
		driver.navigate().to(appUrl);
		driver.manage().window().maximize();
		return driver;
	}

	@Parameters({ "browserType", "appUrl" })

	@BeforeClass
	public void testBaseSetupInitialization(String browserType, String appUrl) {
		try {
			setDriver(BrowserType.valueOf(browserType), appUrl);
		} catch (Exception e) {
			System.out.println("Error is..." + e.getStackTrace());
		}
	}

	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
}
