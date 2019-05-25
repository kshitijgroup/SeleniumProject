package com.selenium.testproject.testproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginTest extends baseUtils {

	@Test(retryAnalyzer = Retry.class)
	public void test1() throws Exception {

		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.abhibus.com/");
		driver.manage().window().maximize();
		String title = driver.getTitle();

		Assert.assertEquals("Online Bus Ticket Booking - Get Upto Rs.350 Off on Bus Booking",
				"Online Bus Ticket Booking - Get Upto Rs.350 Off on Bus Booking");
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Log.logger(" Step 1 : Abhibus page loaded successfully");
		Thread.sleep(5000);

		try {
			baseUtils.clickOnElement(driver, By.xpath("//*[@id='AccLogin']/span"));
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			baseUtils.clickOnElement(driver, By.xpath("//*[@id='AccLogin']/span"));
		}

		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Log.logger("Step 2 : Clicked on LogIn Button");
		baseUtils.clickOnElement(driver, By.xpath("//*[@id='EmailID']"));

		baseUtils.sendText(driver, By.xpath("//*[@id='EmailID']"), readJSON("username"));
		baseUtils.clickOnElement(driver, By.xpath("//*[@id='LoginPassword']"));
		baseUtils.sendText(driver, By.xpath("//*[@id='LoginPassword']"), readJSON("password"));

		baseUtils.clickOnElement(driver, By.xpath("//div[@class='abhi-pop-login']//*[@id='SignINAjx']"));

		// System.out.println("Step 3 : entered username password details");
		Log.logger("Step 3 : entered username password details");
		Thread.sleep(5000);
		String username = baseUtils.captureText(driver, By.xpath("//*[@id='AccLogin']/span"));

		Log.logger("Username displayed is " + username);
		baseUtils.verifyContainsText(driver, username, "Ampy");

		baseUtils.clickOnElement(driver, By.xpath("//*[@id='source']"));

		baseUtils.sendText(driver, By.xpath("//*[@id='source']"), "Bangal");
		baseUtils.clickOnElement(driver, By.xpath("//*[@id='ui-id-1']/li[text()='Bangalore']"));

		baseUtils.clickOnElement(driver, By.xpath("//*[@id='destination']"));
		baseUtils.sendText(driver, By.xpath("//*[@id='destination']"), "Chenna");

		Thread.sleep(1000);
		baseUtils.clickOnElement(driver, By.xpath("//*[@id='ui-id-2']/li[text()='Chennai']"));

		Thread.sleep(5000);
		baseUtils.clickOnElement(driver, By.xpath("//*[@id='datepicker1']"));

		baseUtils.clickOnElement(driver, By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));

		Thread.sleep(3000);
		baseUtils.clickOnElement(driver, By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']"));

		baseUtils.clickOnElement(driver, By.xpath("(//a[@class='ui-state-default' and contains(text(),'24')])[1]"));
		Thread.sleep(3000);
		baseUtils.clickOnElement(driver, By.xpath("//a[@class='btnab icosearch']"));

		Thread.sleep(10000);

		Log.logger("Select Ticket for boarding journey");
		System.out.println("Move to select button");
		Thread.sleep(5000);
		try {
			baseUtils.jsclickonElement(driver, By.xpath("(//*[@class='mainsection']//*[@class='btnab book1'])[1]"));
		} catch (Exception e) {
			baseUtils.clickOnElement(driver, By.xpath("(//*[@class='mainsection']//*[@class='btnab book1'])[1]"));
		}
		Thread.sleep(5000);
		baseUtils.clickOnElement(driver, By.xpath("//*[@class='borderdtd']//ul[2]/li[1]/a"));

		Thread.sleep(2000);
		baseUtils.clickOnElement(driver, By.xpath("//*[@id='boardingpoint_id']"));

		Thread.sleep(2000);
		baseUtils.clickOnElement(driver, By.xpath("//option[contains(text(),'Madiwala')]"));
		Thread.sleep(2000);
		String username1 = baseUtils.captureText(driver, By.xpath("//*[@class='red-landmark']"));

		Log.logger("Username displayed is " + username1);
		baseUtils.verifyContainsText(driver, username1, "Madiwala");
		baseUtils.clickOnElement(driver, By.xpath("//input[@type='submit']"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Log.logger("Test case passed");
	}
}

/*
 * driver.findElement(By.xpath(
 * "//div[@class='abhi-pop-login']//*[@id='SignINAjx']")).click();
 * Thread.sleep(5000);
 * System.out.println("Step 3 : entered username password details");
 * 
 * String username =
 * driver.findElement(By.xpath("//*[@id='AccLogin']/span")).getText();
 * System.out.println("Username displayed is "+ username); if
 * (username.contains("Ampy")) { System.out.println("Successfull LogIn"); } else
 * { throw new IllegalArgumentException("Invalid Username found"); }
 * 
 * driver.findElement(By.xpath("//*[@id='source']")).click();
 * driver.findElement(By.xpath("//*[@id='source']")).sendKeys("Bangal");
 * Thread.sleep(1000);
 * driver.findElement(By.xpath("//*[@id='ui-id-1']/li[text()='Bangalore']")).
 * click(); driver.findElement(By.xpath("//*[@id='destination']")).click();
 * driver.findElement(By.xpath("//*[@id='destination']")).sendKeys("Chenna");
 * Thread.sleep(1000);
 * driver.findElement(By.xpath("//*[@id='ui-id-2']/li[text()='Chennai']")).click
 * (); Thread.sleep(5000);
 * driver.findElement(By.xpath("//*[@id='datepicker1']")).click();
 * driver.findElement(By.
 * xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
 * Thread.sleep(3000); driver.findElement(By.
 * xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
 * driver.findElement(By.
 * xpath("(//a[@class='ui-state-default' and contains(text(),'24')])[2]")).click
 * (); driver.findElement(By.xpath("//*[@id='datepicker2']")).click();
 * driver.findElement(By.
 * xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
 * driver.findElement(By.
 * xpath("(//a[@class='ui-state-default' and contains(text(),'28')])[1]")).click
 * (); Thread.sleep(3000);
 * driver.findElement(By.xpath("//a[@class='btnab icosearch']")).click();
 * Thread.sleep(10000);
 * System.out.println("Select Ticket for boarding journey");
 * //js.executeScript("arguments[0].click();", driver.findElement(By.
 * xpath("(//*[@class='mainsection']//*[@class='btnab book1'])[1]")));
 * //driver.findElement(By.
 * xpath("(//*[@class='mainsection']//*[@class='btnab book1'])[1]")).click();
 * //action.moveToElement(driver.findElement(By.
 * xpath("(//*[@class='mainsection']//*[@class='btnab book1'])[1]"))).build().
 * perform(); System.out.println("Move to select button"); Thread.sleep(5000);
 * try { js.executeScript("arguments[0].click();", driver.findElement(By.
 * xpath("(//*[@class='mainsection']//*[@class='btnab book1'])[1]")));
 * System.out.println("Clicked using javascript"); } catch (Exception e) {
 * driver.findElement(By.
 * xpath("(//*[@class='mainsection']//*[@class='btnab book1'])[1]")).click();
 * System.out.println("Clicked using webelement"); } Thread.sleep(5000);
 * driver.findElement(By.xpath("//*[@class='borderdtd']//ul[2]/li[1]/a")).click(
 * ); Thread.sleep(2000);
 * driver.findElement(By.xpath("//*[@id='boardingpoint_id']")).click();
 * Thread.sleep(2000);
 * driver.findElement(By.xpath("//option[contains(text(),'Madiwala')]")).click()
 * ; Thread.sleep(1000); String username1 =
 * driver.findElement(By.xpath("//*[@class='red-landmark']")).getText(); if
 * (username1.contains("Madiwala")) {
 * System.out.println("Correct Boarding point selected"); } else { throw new
 * IllegalArgumentException("Invalid Username found"); }
 * driver.findElement(By.xpath("//input[@type='submit']")).click();
 * 
 * //Return Journey //System.out.println("Select Ticket for return journey");
 * try { js.executeScript("arguments[0].click();", driver.findElement(By.
 * xpath("(//*[@class='mainsection']//*[@class='btnab book1'])[1]")));
 * System.out.println("Clicked using javascript"); } catch (Exception e) {
 * driver.findElement(By.
 * xpath("(//*[@class='mainsection']//*[@class='btnab book1'])[1]")).click();
 * System.out.println("Clicked using webelement"); } Thread.sleep(5000); try {
 * js.executeScript("arguments[0].click();", driver.findElement(By.
 * xpath("(//*[@class='mainsection']//*[@class='btnab book1'])[12]")));
 * System.out.println("Clicked using javascript"); } catch (Exception e) {
 * driver.findElement(By.
 * xpath("(//*[@class='mainsection']//*[@class='btnab book1'])[12]")).click();
 * System.out.println("Clicked using webelement"); }
 * 
 * //driver.findElement(By.
 * xpath("(//*[@class='mainsection']//*[contains(text(),'Select Seat')])[1]")).
 * click(); Thread.sleep(2000);
 * driver.findElement(By.xpath("(//*[@class='borderdtd']//ul[2]/li[1]/a)[2]")).
 * click(); Thread.sleep(2000);
 * driver.findElement(By.xpath("//*[@id='boardingpoint_id1']")).click();
 * Thread.sleep(2000);
 * driver.findElement(By.xpath("//option[contains(text(),'Velachery')]")).click(
 * ); Thread.sleep(1000); String username2 =
 * driver.findElement(By.xpath("(//*[@class='red-landmark'])[2]")).getText(); if
 * (username2.contains("Velachery")) {
 * System.out.println("Correct Boarding point selected"); } else { throw new
 * IllegalArgumentException("Invalid Username found"); }
 * driver.findElement(By.xpath("//input[@type='submit']")).click();
 * System.out.println("Test case passed"); //driver.close(); //driver.quit(); }
 * }
 */