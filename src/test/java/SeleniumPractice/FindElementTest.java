package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		
		//Scenario 1
		//findElement() --  returns single webelement
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		searchBox.sendKeys("Kshitij");
		
		List<WebElement> li = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println(li.size());
		for(WebElement ele : li) {
			System.out.println(ele.getText());
		}
		List<WebElement> lis = driver.findElements(By.xpath("//img[contains(title,'Electronics')]"));
		System.out.println(lis.size());
		driver.quit();
	}

}
