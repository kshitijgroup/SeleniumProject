package com.selenium.testproject.testproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SigninPage {
	
	public WebDriver driver;
	
	By emailAddress = By.xpath(".//*[@id='ap_email']");
	By continueBtn = By.xpath(".//*[@id='continue']");
	
	public SigninPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getTitle(){
		String title = driver.getTitle();
		return title;
	}
	
	public boolean verifyPageTitle(){
		String expectedString = "Amazon Sign In";
		return getTitle().contains(expectedString);
	}
	
	public void enterEmail(String email){
		WebElement emailText = driver.findElement(emailAddress); 
		if(emailText.isDisplayed()||emailText.isEnabled()){
		emailText.sendKeys(email);
		}else{
			System.out.println("Email ID field is not displayed");
		}
		System.out.println("Email ID entered is: " +email);
	}
	
	public void clickContinue(){
		driver.findElement(continueBtn).click();
	}

}
