package com.selenium.testproject.testproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;
	
	By yourOrders = By.xpath("(.//*[text()='Your Orders'])[2]");
	By searchBar = By.xpath(".//*[@id='twotabsearchtextbox']");
	By submtiBtn = By.xpath(".//*[@id='nav-search']//input[@value='Go']");
	
	
	public HomePage(WebDriver driver){
		this.driver=driver;
	}
	
	public String getTitle(){
		String title = driver.getTitle();
		return title;
	}
	
	public boolean verifyPageTitle(){
		String expectedString = "Online Shopping site in India";
		return getTitle().contains(expectedString);
	}
	
	public void enterSearchText(String searchText) throws Exception{
		driver.findElement(searchBar).sendKeys(searchText);
		Thread.sleep(2000);
	}
	
	public void clickSearchBtn(){
		driver.findElement(searchBar).click();
	}
	
	public SigninPage clickYourOrder(){
		WebElement yourOrder = driver.findElement(yourOrders);
		if(yourOrder.isDisplayed()||yourOrder.isEnabled()){
			yourOrder.click();
		}
		else{
			System.out.println("Your Order link is not displayed");
		}
		return new SigninPage(driver);
	}
	
	public void scrollIntoView(WebElement aboutUsLink){
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", aboutUsLink);
		System.out.println("Scrolled to element");
	}
}