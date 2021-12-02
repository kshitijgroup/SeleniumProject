package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckWebElement {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		
		WebElement searchStore = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		System.out.println(searchStore.isDisplayed());
		System.out.println(searchStore.isEnabled());
		
		WebElement radiobtnMale = driver.findElement(By.xpath("//input[@id='gender-male']"));
		System.out.println(radiobtnMale.isSelected());
		
		WebElement radiobtnFemale = driver.findElement(By.xpath("//input[@id='gender-female']"));
		radiobtnFemale.click();
		System.out.println(radiobtnFemale.isSelected());
		
		//driver.quit();
	}

}
