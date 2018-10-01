package com.selenium.testproject.testproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.JsonObject;

public class baseUtils {

	WebDriver driver;
	
	public baseUtils() {
	driver = this.driver;
	}
	
	public static void clickOnElement(WebDriver driver,By by)
	{
		waitForDOM (driver, by);
		driver.findElement(by).click();	
	}
	
	public static void sendText(WebDriver driver,By by,String text)
	{
		waitForDOM (driver, by);
		driver.findElement(by).sendKeys(text);	
	}
	
	public static void waitForDOM(WebDriver driver,By by)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		
	}
	public static String captureText(WebDriver driver,By by)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return driver.findElement(by).getText();
		
	}
	
	public static boolean verifyContainsText(WebDriver driver,String expected,String actual)
	{
		boolean b = false;
		if (expected.contains(actual))
		{
			System.out.println("Successfull LogIn");
			b=true;
		}
		else
		{
			throw new IllegalArgumentException("Invalid Username found");
		}
		return b;	
	}
	public static void jsclickonElement(WebDriver driver,By by)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(by));
		System.out.println("Clicked using javascript");
		}
	
	public static String readJSON(String value)
	{
	JSONParser parser = new JSONParser();
	String str=null;
	try {
		Object	obj = parser.parse(new FileReader("src\\main\\resources\\json\\data.json"));
		JSONObject jsonObject = (JSONObject) obj;
		//System.out.println(jsonObject);
	
		str = (String) jsonObject.get(value);
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
	}
	return str; 
	}
	
	public static int readJSONInt(String value)
	{
	JSONParser parser = new JSONParser();
	String str=null;
	Object o = null;
	try {
		Object	obj = parser.parse(new FileReader("src\\main\\resources\\json\\data.json"));
		JSONObject jsonObject = (JSONObject) obj;
		//System.out.println(jsonObject);
	 o = jsonObject.get(value);
	
	//	str = (String) jsonObject.get(value);
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
	}
	return ((Number)o).intValue();
	}

}



/*Log.log(driver).info("Enter Address - Line 1");
WebElement addressLine1 = XPath.waitForVisibleElement(driver, "//*[@id='billingAddress-street1']", Constants.GLOBAL_DRIVER_TIMEOUT);
Utils.clearAndSendKeys(driver, addressLine1, "1151 Glendale Galleria");
Utils.sleep(250);*/
 /*public static WebElement waitForVisibleElement(WebDriver driver, String xpath, long timeout) throws Exception {
        return Utils.waitForVisibleElement(driver, By.xpath(xpath), timeout);
    }*/


/*public static WebElement waitForElement(WebDriver driver, WebElement parent, By locator, long timeout)
		throws Exception {
	waitForDomInteractiveNoException(driver);
	final By location = locator;
	final WebElement parentElement = parent;
	ExpectedCondition<WebElement> condition = new ExpectedCondition<WebElement>() {
		@Override
		public WebElement apply(WebDriver driver) {
			return parentElement.findElement(location);
		}
	};
	Wait<WebDriver> wait = new WebDriverWait(driver, timeout);
	WebElement element;
	try {
		element = wait.until(condition);
		// if (Utils.logWebElements)
		// Log.log(driver).info("Found: " + location.toString());
	} catch (Exception ex) {
		throw new WebElementNotFoundException("Failed to find element: " + location.toString(), ex, driver);
	}
	return element;
}*/