package com.selenium.testproject.testproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBaseSetUp {

	public WebDriver driver;

	private Properties prop;
	private final static String FILEPATH = "src\\main\\resources\\config.properties";
	static String driverPathIE = "drivers/iedriver/IEDriverServer.exe";
	static String driverPathChrome = "drivers/chromedriver/chromedriver.exe";

	public TestBaseSetUp () throws FileNotFoundException
	{
	try{
		BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
		prop = new Properties();
		prop.load(reader);
		reader.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	public String getBrowserName ()
	{
		String browserName = prop.getProperty("browser");
		if(browserName!= null) 
			return browserName;
		else throw new RuntimeException("driverName not specified in the Config.properties file.");
	}
	public String getUrl ()
	{
		String url = prop.getProperty("url");
		if(url!= null) 
			return url;
		else throw new RuntimeException("URL not specified in the Config.properties file.");
	}
	public WebDriver getDriver() {
		return driver;
	}


	/*public void setDriver(BrowserType browserType, String appUrl) {
		
		switch (browserType) {
		case ie:
			driver = initElementsIEdriver(appUrl);
			break;
		case chrome:
			driver = initElementsChromedriver(appUrl);
			break;
		}
	}*/
	
	public void setDriver1() {
		String browsername = getBrowserName();
		String UrlName = getUrl();
		switch (browsername) {
		case "ie":
			driver = initElementsIEdriver(UrlName);
			break;
		case "chrome":
			driver = initElementsChromedriver(UrlName);
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

	//@Parameters({ "browserType", "appUrl" })

	//@BeforeClass
	/*public void testBaseSetupInitialization(String browserType, String appUrl) {
		try {
			setDriver(BrowserType.valueOf(browserType), appUrl);
		} catch (Exception e) {
			System.out.println("Error is..." + e.getStackTrace());
		}
	}*/

	@BeforeClass
	public void testBaseSetupInitialization1() {
		try {
			setDriver1();
		} catch (Exception e) {
			System.out.println("Error is..." + e.getStackTrace());
		}
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
