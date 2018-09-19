package com.selenium.testproject.testproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonTest extends TestBaseSetUp {

	public WebDriver driver;
	By aboutUs = By.xpath(".//*[@id='navFooter']//a[text()='About Us']");
	
	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test
	public void testAmazonScript() {

		try {
			HomePage homePage = new HomePage(driver);
			Assert.assertTrue(homePage.verifyPageTitle(),"Home page is not displayed");
			System.out.println("Home Page is displayed");
			WebElement aboutUsLink = driver.findElement(aboutUs);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", aboutUsLink);
			homePage.scrollIntoView(aboutUsLink);
			
			Thread.sleep(3000);
			System.out.println("Clicking on Your Orders link");
			homePage.clickYourOrder();
			System.out.println("Clicked on Your Orders link");

			SigninPage signIn = new SigninPage(driver);
			Assert.assertTrue(signIn.verifyPageTitle(), "Sign page is not displayed");
			System.out.println("Sign Page is displayed");
			
			Thread.sleep(3000);
			System.out.println("Entering Email ID");
			signIn.enterEmail("kshitijchaudhary21@gmail.com");
			
			System.out.println("Clicked on Continue button");
			signIn.clickContinue();

		} catch (Exception e) {
			System.out.println("Error is..." + e.getStackTrace());
		}
	}

}
